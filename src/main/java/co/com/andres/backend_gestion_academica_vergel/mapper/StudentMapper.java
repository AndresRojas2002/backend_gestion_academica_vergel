package co.com.andres.backend_gestion_academica_vergel.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.StudentsRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.StudentsResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Students;

/**
 * Mapper para la conversión entre la entidad {@link Students} y sus DTOs.
 *
 * Utiliza MapStruct para generar automáticamente la implementación
 * en tiempo de compilación.
 *
 * @author Andres
 * @version 1.0
 * @since 2026
 */
@Mapper(componentModel = "spring", imports = Set.class)
public interface StudentMapper {

    /**
     * Convierte un {@link StudentsRequest} a la entidad {@link Students}.
     * El {@code id}, {@code roles} y {@code password} se gestionan fuera del mapper.
     *
     * @param request DTO con los datos del estudiante
     * @return entidad {@link Students} mapeada
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", expression = "java(Set.of(\"ROLE_STUDENT\"))")
    @Mapping(target = "enrollments", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "parent.id", source = "parentId")
    Students toEntity(StudentsRequest request);

    /**
     * Convierte una entidad {@link Students} a {@link StudentsResponse}.
     *
     * @param entity entidad del estudiante
     * @return DTO de respuesta con la información del estudiante
     */
    @Mapping(target = "nameParent", expression = "java(entity.getParent().getName() + ' ' + entity.getParent().getLastName())")
    @Mapping(target = "role", ignore = true)
    StudentsResponse toResponse(Students entity);

    /**
     * Actualiza una entidad {@link Students} existente con los datos del request.
     * El {@code id}, {@code roles}, {@code studentNumber}, {@code userName}
     * y {@code password} se conservan sin modificación.
     *
     * @param request DTO con los nuevos datos
     * @param entity  entidad a actualizar
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "studentNumber", ignore = true)
    @Mapping(target = "enrollments", ignore = true)
    @Mapping(target = "userName", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "parent.id", source = "parentId")
    void updateEntityFromRequest(StudentsRequest request, @MappingTarget Students entity);
}