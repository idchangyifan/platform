package com.orchard.platform.dao;

import java.io.Serializable;
import java.util.Objects;

/**
 *@Author orchard.chang
 *@Date 2018/10/1620:16
 *@Version 1.0
 **/
public interface Storeable<PK extends Serializable> {
    void setId(PK var1);

    PK getId();

    void logicDelete();

    default boolean comparePK(Storeable<PK> target) {
        if (!Objects.isNull(target) && !Objects.isNull(this.getId()) && !Objects.isNull(target.getId())) {
            return !this.getClass().equals(target.getClass()) ? false : this.getId().equals(target.getId());
        } else {
            return false;
        }
    }
}
