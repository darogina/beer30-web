package com.github.darogina.beer30.repository;

import com.github.darogina.beer30.entity.BeerStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerStatusRepository extends JpaRepository<BeerStatusEntity, Long> {
}
