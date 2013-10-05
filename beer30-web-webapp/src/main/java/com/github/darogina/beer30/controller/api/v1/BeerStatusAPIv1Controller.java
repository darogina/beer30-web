package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.assembler.api.v1.BeerStatusResourceAssembler;
import com.github.darogina.beer30.controller.ServiceBasedRestController;
import com.github.darogina.beer30.entity.BaseEntity;
import com.github.darogina.beer30.entity.BeerStatusEntity;
import com.github.darogina.beer30.entity.StatusTypeEntity;
import com.github.darogina.beer30.entity.UserEntity;
import com.github.darogina.beer30.exception.NotImplementedException;
import com.github.darogina.beer30.model.api.v1.BeerStatus;
import com.github.darogina.beer30.service.BeerStatusService;
import com.github.darogina.beer30.service.StatusTypeService;
import com.github.darogina.beer30.service.UserService;
import org.modelmapper.AbstractConverter;
import org.modelmapper.PropertyMap;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Controller
@ExposesResourceFor(BeerStatus.class)
@RequestMapping("/api/v1/beerStatus")
public class BeerStatusAPIv1Controller extends ServiceBasedRestController<BeerStatus, Long, BeerStatusService, BeerStatusResourceAssembler> {

    @Inject
    private UserService userService;

    @Inject
    private StatusTypeService statusTypeService;

    @Override @Inject
    public void setService(BeerStatusService service) {
        this.service = service;
    }

    @Override @Inject
    protected void setResourceAssembler(BeerStatusResourceAssembler resourceAssembler) {
        this.resourceAssembler = resourceAssembler;
    }

    @Override
    public BeerStatus update(@PathVariable Long aLong, @RequestBody BeerStatus resource) {
        throw new NotImplementedException("Update is currently not implemented");
    }

    @Override
    public void delete(@PathVariable Long aLong) {
        throw new NotImplementedException("Delete is currently not implemented");
    }

    @Override
    public BaseEntity toEntity(BeerStatus model) {
        if (model == null) {
            return null;
        }

        return modelMapper.map(model, BeerStatusEntity.class);
    }

    @PostConstruct
    private void init() {
        // Setup custom mapping
        modelMapper.addMappings(new PropertyMap<BeerStatus, BeerStatusEntity>() {
            @Override
            protected void configure() {
                using(new AbstractConverter<Long, StatusTypeEntity>() {
                    @Override
                    protected StatusTypeEntity convert(Long source) {
                        return statusTypeService.findById(source);
                    }
                }).map(source.getStatusTypeId()).setStatusType(null);

                using(new AbstractConverter<Long, UserEntity>() {
                    @Override
                    protected UserEntity convert(Long source) {
                        return userService.findById(source);
                    }
                }).map(source.getUserId()).setUser(null);
            }
        });
    }
}
