package co.com.andres.backend_gestion_academica_vergel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.GradeRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.GradeResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Grade;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    @Mapping(target = "id", ignore = true)
    Grade toEntity(GradeRequest request);

    GradeResponse toResponse(Grade entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(GradeRequest request, @MappingTarget Grade entity);

}
