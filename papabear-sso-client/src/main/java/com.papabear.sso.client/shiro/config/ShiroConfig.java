package com.papabear.sso.client.shiro.config;

import com.papabear.sso.client.shiro.filter.UpmsAuthenticationFilter;
import com.papabear.sso.client.shiro.filter.UpmsSessionForceLogoutFilter;
import com.papabear.sso.client.shiro.listener.UpmsSessionListener;
import com.papabear.sso.client.shiro.realm.UpmsRealm;
import com.papabear.sso.client.shiro.session.UpmsSessionDao;
import com.papabear.sso.client.shiro.session.UpmsSessionFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
    * @Description: shiro的配置类
    * @author: miaohongshuai
    * @Date: 2017/10/30 0030
*/
@Configuration
public class ShiroConfig {
    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     *
     */
    @Value("papabear.sso.server.url")
    private String loginUrl;
    @Value("papabear.sso.successUrl")
    private String successUrl;
    @Value("papabear.sso.unauthorizedUrl")
    private String unauthorizedUrl;
    @Value("papabear.sso.session.timeout")
    private Long sessionTimeout;
    @Value("papabear.sso.rememberMe.timeout")
    private Integer rememberMeTimeout;
    @Value(("papabear.sso.session.id"))
    private String sessionId;

    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager, @Qualifier("upmsAuthenticationFilter") UpmsAuthenticationFilter upmsAuthenticationFilter) {
//        log.info("shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl(successUrl);
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);

        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("authc", upmsAuthenticationFilter);
        // 设置自定义拦截器
        shiroFilterFactoryBean.setFilters(filters);

        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/manage/index", "user");
        filterChainDefinitionMap.put("/manage/**", "upmsSessionForceLogout,authc");

        filterChainDefinitionMap.put("/druid/**", "user");
        filterChainDefinitionMap.put("/swagger-ui.html", "user");

        filterChainDefinitionMap.put("/resources/**", "anon");

        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");

//        filterChainDefinitionMap.put("/add", "perms[权限添加]");
        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    //    重写authc过滤器
    @Bean
    public UpmsAuthenticationFilter upmsAuthenticationFilter() {
        return new UpmsAuthenticationFilter();
    }
//    强制退出会话过滤器
    @Bean
    public UpmsSessionForceLogoutFilter upmsSessionForceLogoutFilter() {
        return new UpmsSessionForceLogoutFilter();
    }

    @Bean
    public SecurityManager securityManager(@Qualifier("authRealm") UpmsRealm authoRealm, @Qualifier("cookieRememberMeManager") CookieRememberMeManager cookieRememberMeManager, @Qualifier("sessionManager")SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(authoRealm);
        // 设置rememberMe管理器
        securityManager.setRememberMeManager(cookieRememberMeManager);
        // 设置会话管理器
        securityManager.setSessionManager(sessionManager);

        return securityManager;
    }

//    会话管理器
    @Bean
    public SessionManager sessionManager(@Qualifier("sessionDao") UpmsSessionDao sessionDao, @Qualifier("sessionIdCookie") SimpleCookie sessionIdCookie, @Qualifier("sessionListener") UpmsSessionListener sessionListener, @Qualifier("sessionFactory") UpmsSessionFactory sessionFactory) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        全局session超时时间
        sessionManager.setGlobalSessionTimeout(sessionTimeout);
        sessionManager.setSessionDAO(sessionDao);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(sessionIdCookie);
        sessionManager.setSessionValidationSchedulerEnabled(false);
        List<SessionListener> sessionListeners = new ArrayList<>();
        sessionListeners.add(sessionListener);
        sessionManager.setSessionListeners(sessionListeners);
        sessionManager.setSessionFactory(sessionFactory);

        return sessionManager;
    }

//        <!-- 会话DAO，可重写，持久化session -->
    @Bean(name = "sessionDao")
    public UpmsSessionDao upmsSessionDao() {
        return new UpmsSessionDao();
    }

//    <!-- 会话Cookie模板 -->
    @Bean(name = "sessionIdCookie")
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
//        不会暴露给客户端
        simpleCookie.setHttpOnly(true);
//        设置Cookie的过期时间，秒为单位，默认-1表示关闭浏览器时过期Cookie
        simpleCookie.setMaxAge(-1);
//        Cookie名称
        simpleCookie.setName(sessionId);

        return simpleCookie;
    }

//             <!-- 会话监听器 -->
    @Bean(name = "sessionListener")
    public UpmsSessionListener upmsSessionListener() {
        return new UpmsSessionListener();
    }

    //    <!-- session工厂 -->
    @Bean(name = "sessionFactory")
    public UpmsSessionFactory upmsSessionFactory() {
        return new UpmsSessionFactory();
    }

    /**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     * 不指定bean的name，则默认使用方法名
     * @return
     */
    @Bean(name = "authRealm")
    public UpmsRealm myAuthRealm() {
        UpmsRealm myAuthRealm = new UpmsRealm();
        return myAuthRealm;
    }

    /**
     * 缓存管理器
     * @return
     */
//    @Bean(value="ehCacheManager")
//    public EhCacheCacheManager ehCacheManager(@Qualifier("ehCacheManagerFactoryBean") EhCacheManagerFactoryBean bean) {
////        log.info("ehCacheManager()");
//        EhCacheCacheManager cacheManager = new EhCacheCacheManager();
//        cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
//        return cacheManager;
//    }

    /**
     * 记住我管理器 cookie管理对象;
     *
     * @return
     */
    @Bean(name = "cookieRememberMeManager")
    public CookieRememberMeManager rememberMeManager() {
//        System.out.println("rememberMeManager()");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
//      rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度（128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /**
     * cookie对象;
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
//        log.info("rememberMeCookie()");
        // 这个参数是cookie的名称，对应前端的checkbox 的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        // 记住我cookie生效时间
        simpleCookie.setMaxAge(rememberMeTimeout);
        return simpleCookie;
    }

    /**
     * 密码匹配凭证管理器
     *
     * @return
     */
//    @Bean(name = "hashedCredentialsMatcher")
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
////        log.info("hashedCredentialsMatcher()");
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//
//        hashedCredentialsMatcher.setHashAlgorithmName("MD5");// 散列算法:这里使用MD5算法;
//        hashedCredentialsMatcher.setHashIterations(1024);// 散列的次数，比如散列两次，相当于
//        // md5(md5(""));
//
//        return hashedCredentialsMatcher;
//    }

//    设置SecurityUtils，相当于调用SecurityUtils.setSecurityManager(securityManager)
    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setTargetClass(SecurityUtils.class);
        methodInvokingFactoryBean.setStaticMethod("setSecurityManager");
        methodInvokingFactoryBean.setArguments(new SecurityManager[]{securityManager});

        return methodInvokingFactoryBean;
    }

    /**
     * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持; Controller才能使用@RequiresPermissions
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            @Qualifier("securityManager") SecurityManager securityManager) {
//        log.info("authorizationAttributeSourceAdvisor()");
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //    Shiro生命周期处理器
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
