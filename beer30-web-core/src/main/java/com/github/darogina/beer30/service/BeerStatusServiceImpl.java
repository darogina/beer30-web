package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.BeerStatusEntity;
import com.github.darogina.beer30.repository.BeerStatusRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named("beerStatusService")
public class BeerStatusServiceImpl extends AbstractCrudService<BeerStatusEntity, Long, BeerStatusRepository> implements BeerStatusService {

    @Override @Inject
    public void setRepository(BeerStatusRepository beerStatusRepository) {
        this.repository = beerStatusRepository;
    }

}
