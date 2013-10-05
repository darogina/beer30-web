package com.github.darogina.beer30.assembler.api.v1;

import com.github.darogina.beer30.assembler.api.GenericResourceAssemler;
import com.github.darogina.beer30.controller.api.v1.BeerStatusAPIv1Controller;
import com.github.darogina.beer30.entity.BeerStatusEntity;
import com.github.darogina.beer30.model.api.v1.BeerStatus;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Named("beerStatusResourceAssembler")
public class BeerStatusResourceAssembler extends GenericResourceAssemler<BeerStatusAPIv1Controller, BeerStatusEntity, BeerStatus> {

    private ModelMapper modelMapper;

    public BeerStatusResourceAssembler() {
        super(BeerStatusAPIv1Controller.class, BeerStatus.class);
    }

    @Override
    public BeerStatus toResource(BeerStatusEntity entity) {
        // will add also a link with rel self pointing itself
        BeerStatus resource = createResourceWithId(entity.getId(), entity);

        //TODO: add link to user who changed the status

        return resource;
    }

    @Override
    protected BeerStatus instantiateResource(BeerStatusEntity entity) {
        return entity == null ? null : modelMapper.map(entity, BeerStatus.class);
    }

    @PostConstruct
    private void init() {
        modelMapper = new ModelMapper();
    }
}