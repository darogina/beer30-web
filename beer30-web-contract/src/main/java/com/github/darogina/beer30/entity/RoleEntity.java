package com.github.darogina.beer30.entity;

import com.github.darogina.beer30.enums.Authority;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.envers.Audited;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
@Audited
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RoleEntity extends BaseEntity implements GrantedAuthority {

    @Transient
    private static final long serialVersionUID = -4631343806470314420L;

    @Column(name = "AUTHORITY", nullable = false, unique = true)
    private String authority;

    public RoleEntity() {
        this(Authority.ROLE_USER);
    }

    public RoleEntity(Authority authority) {
        Assert.notNull(authority, "authority is required; it must not be null");
        this.authority = authority.name();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof RoleEntity)) return false;
//
//        RoleEntity role = (RoleEntity) o;
//
//        if (!authority.equals(role.authority)) return false;
//        if (!getId().equals(role.getId())) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId().hashCode();
//        result = 31 * result + authority.hashCode();
//        return result;
//    }
}
