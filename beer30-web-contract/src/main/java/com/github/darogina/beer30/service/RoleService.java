package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.RoleEntity;
import com.github.darogina.beer30.enums.Authority;

public interface RoleService extends CrudService<RoleEntity, Long> {

    /**
     * Get a {@code Role} by a specified {@code Authority}
     * @param authority Authority
     * @return Role
     */
    RoleEntity findByAuthority(Authority authority);

}
