package com.github.darogina.beer30.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LINKED_ACCOUNT", uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_ID", "ACCOUNT_SOURCE", "ACCOUNT_ID_TYPE", "ACCOUNT_ID"})})
@Audited
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LinkedAccountEntity extends BaseEntity {

    @Transient
    private static final long serialVersionUID = 7444886854828429987L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;

    @Column(name = "ACCOUNT_SOURCE", nullable = false)
    private String accountSource;

    @Column(name = "ACCOUNT_ID_TYPE", nullable = false)
    private String accountIdType;

    @Column(name = "ACCOUNT_ID", nullable = false)
    private String accountId;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getAccountSource() {
        return accountSource;
    }

    public void setAccountSource(String accountSource) {
        this.accountSource = accountSource;
    }

    public String getAccountIdType() {
        return accountIdType;
    }

    public void setAccountIdType(String accountIdType) {
        this.accountIdType = accountIdType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof LinkedAccountEntity)) return false;
//
//        LinkedAccountEntity that = (LinkedAccountEntity) o;
//
//        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
//        if (accountIdType != null ? !accountIdType.equals(that.accountIdType) : that.accountIdType != null)
//            return false;
//        if (accountSource != null ? !accountSource.equals(that.accountSource) : that.accountSource != null)
//            return false;
//        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
//        if (user != null ? !user.equals(that.user) : that.user != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId() != null ? getId().hashCode() : 0;
//        result = 31 * result + (user != null ? user.hashCode() : 0);
//        result = 31 * result + (accountSource != null ? accountSource.hashCode() : 0);
//        result = 31 * result + (accountIdType != null ? accountIdType.hashCode() : 0);
//        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
//        return result;
//    }
}
