package com.github.darogina.beer30.repository;

import com.github.darogina.beer30.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
