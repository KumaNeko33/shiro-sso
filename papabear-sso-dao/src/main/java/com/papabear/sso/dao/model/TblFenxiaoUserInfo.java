package com.papabear.sso.dao.model;

import java.io.Serializable;
import java.util.Date;

public class TblFenxiaoUserInfo implements Serializable {
    private Long userId;

    private Byte isSuperior;

    private Long introducerId;

    private Byte isCertified;

    private Float money;

    private Float confirmMoney;

    private Float usableMoney;

    private Float lastMoney;

    /**
     * 1、白熊商城、2家之良品分销平台、3白熊APP
     *
     * @mbg.generated
     */
    private Byte origin;

    private Long mallGradeId;

    private String mallGradeName;

    private String bankName;

    private String bankNumber;

    private String realName;

    private String cardNumber;

    private String aliPayNumber;

    private Date createDateTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getIsSuperior() {
        return isSuperior;
    }

    public void setIsSuperior(Byte isSuperior) {
        this.isSuperior = isSuperior;
    }

    public Long getIntroducerId() {
        return introducerId;
    }

    public void setIntroducerId(Long introducerId) {
        this.introducerId = introducerId;
    }

    public Byte getIsCertified() {
        return isCertified;
    }

    public void setIsCertified(Byte isCertified) {
        this.isCertified = isCertified;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Float getConfirmMoney() {
        return confirmMoney;
    }

    public void setConfirmMoney(Float confirmMoney) {
        this.confirmMoney = confirmMoney;
    }

    public Float getUsableMoney() {
        return usableMoney;
    }

    public void setUsableMoney(Float usableMoney) {
        this.usableMoney = usableMoney;
    }

    public Float getLastMoney() {
        return lastMoney;
    }

    public void setLastMoney(Float lastMoney) {
        this.lastMoney = lastMoney;
    }

    public Byte getOrigin() {
        return origin;
    }

    public void setOrigin(Byte origin) {
        this.origin = origin;
    }

    public Long getMallGradeId() {
        return mallGradeId;
    }

    public void setMallGradeId(Long mallGradeId) {
        this.mallGradeId = mallGradeId;
    }

    public String getMallGradeName() {
        return mallGradeName;
    }

    public void setMallGradeName(String mallGradeName) {
        this.mallGradeName = mallGradeName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAliPayNumber() {
        return aliPayNumber;
    }

    public void setAliPayNumber(String aliPayNumber) {
        this.aliPayNumber = aliPayNumber;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", isSuperior=").append(isSuperior);
        sb.append(", introducerId=").append(introducerId);
        sb.append(", isCertified=").append(isCertified);
        sb.append(", money=").append(money);
        sb.append(", confirmMoney=").append(confirmMoney);
        sb.append(", usableMoney=").append(usableMoney);
        sb.append(", lastMoney=").append(lastMoney);
        sb.append(", origin=").append(origin);
        sb.append(", mallGradeId=").append(mallGradeId);
        sb.append(", mallGradeName=").append(mallGradeName);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankNumber=").append(bankNumber);
        sb.append(", realName=").append(realName);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", aliPayNumber=").append(aliPayNumber);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TblFenxiaoUserInfo other = (TblFenxiaoUserInfo) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getIsSuperior() == null ? other.getIsSuperior() == null : this.getIsSuperior().equals(other.getIsSuperior()))
            && (this.getIntroducerId() == null ? other.getIntroducerId() == null : this.getIntroducerId().equals(other.getIntroducerId()))
            && (this.getIsCertified() == null ? other.getIsCertified() == null : this.getIsCertified().equals(other.getIsCertified()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getConfirmMoney() == null ? other.getConfirmMoney() == null : this.getConfirmMoney().equals(other.getConfirmMoney()))
            && (this.getUsableMoney() == null ? other.getUsableMoney() == null : this.getUsableMoney().equals(other.getUsableMoney()))
            && (this.getLastMoney() == null ? other.getLastMoney() == null : this.getLastMoney().equals(other.getLastMoney()))
            && (this.getOrigin() == null ? other.getOrigin() == null : this.getOrigin().equals(other.getOrigin()))
            && (this.getMallGradeId() == null ? other.getMallGradeId() == null : this.getMallGradeId().equals(other.getMallGradeId()))
            && (this.getMallGradeName() == null ? other.getMallGradeName() == null : this.getMallGradeName().equals(other.getMallGradeName()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankNumber() == null ? other.getBankNumber() == null : this.getBankNumber().equals(other.getBankNumber()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getCardNumber() == null ? other.getCardNumber() == null : this.getCardNumber().equals(other.getCardNumber()))
            && (this.getAliPayNumber() == null ? other.getAliPayNumber() == null : this.getAliPayNumber().equals(other.getAliPayNumber()))
            && (this.getCreateDateTime() == null ? other.getCreateDateTime() == null : this.getCreateDateTime().equals(other.getCreateDateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getIsSuperior() == null) ? 0 : getIsSuperior().hashCode());
        result = prime * result + ((getIntroducerId() == null) ? 0 : getIntroducerId().hashCode());
        result = prime * result + ((getIsCertified() == null) ? 0 : getIsCertified().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getConfirmMoney() == null) ? 0 : getConfirmMoney().hashCode());
        result = prime * result + ((getUsableMoney() == null) ? 0 : getUsableMoney().hashCode());
        result = prime * result + ((getLastMoney() == null) ? 0 : getLastMoney().hashCode());
        result = prime * result + ((getOrigin() == null) ? 0 : getOrigin().hashCode());
        result = prime * result + ((getMallGradeId() == null) ? 0 : getMallGradeId().hashCode());
        result = prime * result + ((getMallGradeName() == null) ? 0 : getMallGradeName().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankNumber() == null) ? 0 : getBankNumber().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getCardNumber() == null) ? 0 : getCardNumber().hashCode());
        result = prime * result + ((getAliPayNumber() == null) ? 0 : getAliPayNumber().hashCode());
        result = prime * result + ((getCreateDateTime() == null) ? 0 : getCreateDateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}