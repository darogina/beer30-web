package com.github.darogina.beer30.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.envers.Audited;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USER")
@Audited
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserEntity extends BaseEntity implements UserDetails {

    @Transient
    private static final long serialVersionUID = -8311177375639274321L;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = true)
    private String password;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled = true;

    @Column(name = "ACCOUNT_NON_EXPIRED", nullable = false)
    private boolean accountNonExpired = true;

    @Column(name = "ACCOUNT_NON_LOCKED", nullable = false)
    private boolean accountNonLocked = true;

    @Column(name = "CREDENTIALS_NON_EXPIRED", nullable = false)
    private boolean credentialsNonExpired = true;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private List<RoleEntity> roles = new ArrayList<RoleEntity>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<LinkedAccountEntity> linkedAccounts = new ArrayList<LinkedAccountEntity>();

    public UserEntity() {}

    public UserEntity(String username, String password, String email, String firstName, String lastName, Collection<LinkedAccountEntity> linkedAccounts, Collection<? extends RoleEntity> authorities) {
        Assert.hasText(username, "username must have text; it must not be null, empty, or blank");
        Assert.hasText(email, "email must have text; it must not be null, empty, or blank");
        Assert.hasText(firstName, "firstName must have text; it must not be null, empty, or blank");
        Assert.hasText(lastName, "lastName must have text; it must not be null, empty, or blank");
        Assert.notEmpty(authorities, "authorities must not be empty: it must contain at least 1 element");

        this.username = StringUtils.trimAllWhitespace(username.toLowerCase());
        this.password = password;
        this.email = StringUtils.trimAllWhitespace(email.toLowerCase());
        this.firstName = StringUtils.trimWhitespace(firstName);
        this.lastName = StringUtils.trimWhitespace(lastName);
        this.fullName = StringUtils.arrayToDelimitedString(new String[]{lastName, lastName}, " ");

        this.roles.addAll(authorities);

        if (!CollectionUtils.isEmpty(linkedAccounts)) {
            this.linkedAccounts.addAll(linkedAccounts);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<RoleEntity> getRoles() {
        if (roles == null) {
            roles = new ArrayList<RoleEntity>();
        }
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public List<LinkedAccountEntity> getLinkedAccounts() {
        if (linkedAccounts == null) {
            linkedAccounts = new ArrayList<LinkedAccountEntity>();
        }
        return linkedAccounts;
    }

    public void setLinkedAccounts(List<LinkedAccountEntity> linkedAccounts) {
        this.linkedAccounts = linkedAccounts;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Transient
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (RoleEntity role : getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        return authorities;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof UserEntity)) return false;
//
//        UserEntity user = (UserEntity) o;
//
//        if (accountNonExpired != user.accountNonExpired) return false;
//        if (accountNonLocked != user.accountNonLocked) return false;
//        if (credentialsNonExpired != user.credentialsNonExpired) return false;
//        if (enabled != user.enabled) return false;
//        if (email != null ? !email.equals(user.email) : user.email != null) return false;
//        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
//        if (fullName != null ? !fullName.equals(user.fullName) : user.fullName != null) return false;
//        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
//        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
//        if (linkedAccounts != null ? !linkedAccounts.equals(user.linkedAccounts) : user.linkedAccounts != null)
//            return false;
//        if (password != null ? !password.equals(user.password) : user.password != null) return false;
//        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
//        if (username != null ? !username.equals(user.username) : user.username != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId() != null ? getId().hashCode() : 0;
//        result = 31 * result + (username != null ? username.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
//        result = 31 * result + (enabled ? 1 : 0);
//        result = 31 * result + (accountNonExpired ? 1 : 0);
//        result = 31 * result + (accountNonLocked ? 1 : 0);
//        result = 31 * result + (credentialsNonExpired ? 1 : 0);
//        result = 31 * result + (roles != null ? roles.hashCode() : 0);
//        result = 31 * result + (linkedAccounts != null ? linkedAccounts.hashCode() : 0);
//        return result;
//    }
}
