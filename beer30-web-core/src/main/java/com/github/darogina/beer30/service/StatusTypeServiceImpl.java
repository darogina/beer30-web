package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.StatusTypeEntity;
import com.github.darogina.beer30.repository.StatusTypeRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named("statusTypeService")
public class StatusTypeServiceImpl extends AbstractCrudService<StatusTypeEntity, Long, StatusTypeRepository> implements StatusTypeService {

    @Override @Inject
    public void setRepository(StatusTypeRepository statusTypeRepository) {
        this.repository = statusTypeRepository;
    }

}
