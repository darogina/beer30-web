package com.github.darogina.beer30.repository;

import com.github.darogina.beer30.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    /**
     * Get a {@code Role} by a specified {@code Authority}
     * @param authority Authority
     * @return Role
     */
    RoleEntity findByAuthority(String authority);

}
