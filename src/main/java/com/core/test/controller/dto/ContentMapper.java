package com.core.test.controller.dto;

import com.core.test.domain.Content;
import com.core.test.service.dto.ContentServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContentMapper {

    ContentServiceRequest toService(ContentControllerRequest controllerRequest);

//    @Mapping(source = "status", target = "status", defaultValue = "ACTIVE")
    @Mapping(target = "id", ignore = true)
    Content toEntity(ContentServiceRequest serviceRequest);

    ContentResponse toResponse(Content content);

}

