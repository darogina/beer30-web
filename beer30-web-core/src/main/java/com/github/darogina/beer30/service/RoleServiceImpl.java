package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.RoleEntity;
import com.github.darogina.beer30.enums.Authority;
import com.github.darogina.beer30.repository.RoleRepository;
import org.springframework.util.Assert;

import javax.inject.Inject;
import javax.inject.Named;

@Named("roleService")
public class RoleServiceImpl extends AbstractCrudService<RoleEntity, Long, RoleRepository> implements RoleService {

    @Override @Inject
    public void setRepository(RoleRepository roleRepository) {
        this.repository = roleRepository;
    }

    @Override
    public RoleEntity findByAuthority(Authority authority) {
        Assert.notNull(authority, "authority is required; it must not be null");

        RoleEntity role = repository.findByAuthority(authority.name());
        if (role == null) {
            role = new RoleEntity(authority);
            role = create(role);
        }

        return role;
    }
}
