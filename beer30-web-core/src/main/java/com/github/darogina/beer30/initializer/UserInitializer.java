package com.github.darogina.beer30.initializer;

import com.github.darogina.beer30.entity.UserEntity;
import com.github.darogina.beer30.enums.Authority;
import com.github.darogina.beer30.service.RoleService;
import com.github.darogina.beer30.service.UserService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

@Named("userInitializer")
public class UserInitializer {

    @Inject
    @Named("userService")
    private UserService userService;

    @Inject
    @Named("roleService")
    private RoleService roleService;

    @PostConstruct
    public void init() {
        userService.deleteAll();

        UserEntity user = new UserEntity("test1@test.com", "", "test1@test.com", "Test1First", "Test1Last", null, Arrays.asList(roleService.findByAuthority(Authority.ROLE_ADMIN)));
        UserEntity user2 = new UserEntity("test2@test.com", "", "test2@test.com", "Test2First", "Test2Last", null, Arrays.asList(roleService.findByAuthority(Authority.ROLE_USER)));

        userService.create(user);
        userService.create(user2);
    }
}