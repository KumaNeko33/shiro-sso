$(function() {
    // Waves初始化
    Waves.displayEffect();
    // 输入框获取焦点后出现下划线
    $('.form-control').focus(function() {
        $(this).parent().addClass('fg-toggled');
    }).blur(function() {
        $(this).parent().removeClass('fg-toggled');
    });
});
Checkbix.init();
$(function() {
    $("#loginData").validate({
        rules: {
            username: {
                required: true,
                minlength: 2
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 20
            },
        },
        messages: {
            username: {
                required: "请输入用户名",
                minlength: "用户名必需大于两个字母"
            },
            password: {
                required: "请输入密码",
                minlength: "密码长度不能小于 6 位",
                maxlength: "密码长度最多 20 位"
            },
        },
        errorPlacement: function (error, element) {
            if (error && error[0].innerHTML !=="") {
                // error.appendTo(element.siblings());
                cart();
                element.siblings().text(error[0].innerHTML).show();
                return;
            }else {
                element.siblings().text("").hide();
            }
        },
        success: function (element) {
        },
        submitHandler: function(form) {
            login();//表单都验证成功后的事件
        }
    });
    // 点击登录按钮
    $('#login-bt').click(function() {
        $("#loginData").validate;
    });
    // 回车事件
    $('#username, #password').keypress(function (event) {
        if (13 == event.keyCode) {
            var flag = $("#loginData").valid();
            if(!flag){
                return;
            }
            login();
        }
    });
    function cart(){
        $('.baixiong').animate({marginLeft:'-75px;'},50);
        setTimeout(function(){
            $(".baixiong") .animate({marginLeft:'-57px'},50)
        },50);
        setTimeout(function(){
            $(".baixiong") .animate({marginLeft:'-72px'},50)
        },100);
        setTimeout(function(){
            $(".baixiong") .animate({marginLeft:'-60px'},50)
        },150);
        setTimeout(function(){
            $(".baixiong") .animate({marginLeft:'-69px'},50)
        },200);
        setTimeout(function(){
            $(".baixiong") .animate({marginLeft:'-63px'},50)
        },250);
        setTimeout(function(){
            $(".baixiong") .animate({marginLeft:'-65px'},50)
        },300);
    }

    //让低版本的ie支持input的placeholder属性
    var JPlaceHolder = {
        //检测
        _check : function(){
            return 'placeholder' in document.createElement('input');
        },
        //初始化
        init : function(){
            if(!this._check()){
                this.fix();
            }
        },
        //修复
        fix : function(){
            jQuery(':input[placeholder]').each(function(index, element) {
                var self = $(this), txt = self.attr('placeholder');
                self.wrap($('<div></div>').css({position:'relative', zoom:'1', border:'none', background:'none', padding:'none', margin:'none'}));
                var pos = self.position(), h = self.outerHeight(true), paddingleft = self.css('padding-left');
                var holder = $('<span></span>').text(txt).css({position:'absolute', left:10+'px', top:pos.top, height:h, lineHeight:h+'px', paddingLeft:paddingleft, color:'#aaa'}).appendTo(self.parent());
                self.focusin(function(e) {
                    holder.hide();
                }).focusout(function(e) {
                    if(!self.val()){
                        holder.show();
                    }
                });
                holder.click(function(e) {
                    holder.hide();
                    self.focus();
                });
                if(self.val()){
                    holder.hide();
                }
            });
        }
    };
    //执行
    jQuery(function(){
        JPlaceHolder.init();
    });
});
// 登录
function login() {
    $.ajax({
        url: BASE_PATH + '/sso/login',
        type: 'POST',
        data: {
            username: $('#username').val(),
            password: $('#password').val(),
            rememberMe: $('#rememberMe').is(':checked'),
            backurl: BACK_URL
        },
        beforeSend: function() {

        },
        success: function(json){
            if (json.code == 1) {
                location.href = json.data;
            } else {
                alert(json.data);
                if (10103 == json.code || 10105 == json.code) {
                    $('.name-null').text(json.data).show();
                    return;
                }
                if (10104 == json.code) {
                    $('.pass-null').text(json.data).show();
                    return;
                }
                // if (10101 == json.code) {
                //     $('#username').focus();
                // }
                // if (10102 == json.code) {
                //     $('#password').focus();
                // }
            }
        },
        error: function(error){
            console.log(error);
        }
    });
}