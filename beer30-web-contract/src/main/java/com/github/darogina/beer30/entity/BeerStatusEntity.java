package com.github.darogina.beer30.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BEER_STATUS")
@Audited
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BeerStatusEntity extends BaseEntity {

    @Transient
    private static final long serialVersionUID = 374254987106527754L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "STATUS_TYPE_ID", nullable = false)
    private StatusTypeEntity statusType;

    @Column(name = "REASON", nullable = true)
    private String reason;

    @ManyToOne(optional = true)
    @JoinColumn(name = "USER_ID", nullable = true)
    private UserEntity user;

    public StatusTypeEntity getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusTypeEntity statusType) {
        this.statusType = statusType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof BeerStatusEntity)) return false;
//
//        BeerStatusEntity that = (BeerStatusEntity) o;
//
//        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
//        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
//        if (statusType != null ? !statusType.equals(that.statusType) : that.statusType != null) return false;
//        if (user != null ? !user.equals(that.user) : that.user != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId() != null ? getId().hashCode() : 0;
//        result = 31 * result + (statusType != null ? statusType.hashCode() : 0);
//        result = 31 * result + (reason != null ? reason.hashCode() : 0);
//        result = 31 * result + (user != null ? user.hashCode() : 0);
//        return result;
//    }
}
