package com.papabear.sso.dao.model;

import java.io.Serializable;

public class TblBxnumTemp implements Serializable {
    private Long bxNum;

    private static final long serialVersionUID = 1L;

    public Long getBxNum() {
        return bxNum;
    }

    public void setBxNum(Long bxNum) {
        this.bxNum = bxNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bxNum=").append(bxNum);
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
        TblBxnumTemp other = (TblBxnumTemp) that;
        return (this.getBxNum() == null ? other.getBxNum() == null : this.getBxNum().equals(other.getBxNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBxNum() == null) ? 0 : getBxNum().hashCode());
        return result;
    }
}