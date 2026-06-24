package co.com.andres.backend_gestion_academica_vergel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.SubjectRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.SubjectResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Subject;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "id", ignore = true)
    Subject toEntity(SubjectRequest courseDto);

    SubjectResponse toResponse(Subject coursesEntity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(SubjectRequest request, @MappingTarget Subject course);

}
