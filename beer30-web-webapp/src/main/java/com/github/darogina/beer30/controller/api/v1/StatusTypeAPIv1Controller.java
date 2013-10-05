package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.assembler.api.v1.StatusTypeResourceAssembler;
import com.github.darogina.beer30.controller.ServiceBasedRestController;
import com.github.darogina.beer30.entity.BaseEntity;
import com.github.darogina.beer30.entity.StatusTypeEntity;
import com.github.darogina.beer30.model.api.v1.StatusType;
import com.github.darogina.beer30.service.StatusTypeService;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@ExposesResourceFor(StatusType.class)
@RequestMapping("/api/v1/statusType")
public class StatusTypeAPIv1Controller extends ServiceBasedRestController<StatusType, Long, StatusTypeService, StatusTypeResourceAssembler> {

    @Override @Inject
    public void setService(StatusTypeService service) {
        this.service = service;
    }

    @Override @Inject
    protected void setResourceAssembler(StatusTypeResourceAssembler resourceAssembler) {
        this.resourceAssembler = resourceAssembler;
    }

    @Override
    public BaseEntity toEntity(StatusType model) {
        if (model == null) {
            return null;
        }

        return modelMapper.map(model, StatusTypeEntity.class);
    }
}
