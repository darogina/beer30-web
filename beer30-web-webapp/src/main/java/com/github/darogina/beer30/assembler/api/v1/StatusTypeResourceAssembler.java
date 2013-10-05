package com.github.darogina.beer30.assembler.api.v1;

import com.github.darogina.beer30.assembler.api.GenericResourceAssemler;
import com.github.darogina.beer30.controller.api.v1.StatusTypeAPIv1Controller;
import com.github.darogina.beer30.entity.StatusTypeEntity;
import com.github.darogina.beer30.model.api.v1.StatusType;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Named("statusTypeResourceAssembler")
public class StatusTypeResourceAssembler extends GenericResourceAssemler<StatusTypeAPIv1Controller, StatusTypeEntity, StatusType> {

    private ModelMapper modelMapper;

    public StatusTypeResourceAssembler() {
        super(StatusTypeAPIv1Controller.class, StatusType.class);
    }

    @Override
    public StatusType toResource(StatusTypeEntity entity) {
        // will add also a link with rel self pointing itself
        StatusType resource = createResourceWithId(entity.getId(), entity);

        return resource;
    }

    @Override
    protected StatusType instantiateResource(StatusTypeEntity entity) {
        return entity == null ? null : modelMapper.map(entity, StatusType.class);
    }

    @PostConstruct
    private void init() {
        modelMapper = new ModelMapper();
    }
}
