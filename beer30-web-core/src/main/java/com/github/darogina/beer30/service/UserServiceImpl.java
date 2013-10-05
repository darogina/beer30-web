package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.UserEntity;
import com.github.darogina.beer30.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named("userService")
public class UserServiceImpl extends AbstractCrudService<UserEntity, Long, UserRepository> implements UserService {

    @Override @Inject
    public void setRepository(UserRepository userRepository) {
        this.repository = userRepository;
    }

}