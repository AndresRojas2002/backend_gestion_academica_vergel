package co.com.andres.backend_gestion_academica_vergel.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.ParentRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.ParentResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Parent;

/**
 * Mapper para la conversión entre la entidad {@link Parent} y sus DTOs.
 *
 * Utiliza MapStruct para generar automáticamente la implementación
 * en tiempo de compilación.
 *
 * @author Andres
 * @version 1.0
 * @since 2026
 */
@Mapper(componentModel = "spring", imports = Set.class)
public interface ParentMapper {

    /**
     * Convierte un {@link ParentRequest} a la entidad {@link Parent}.
     * El {@code id}, {@code roles} y {@code password} se gestionan fuera del mapper.
     * La contraseña debe ser encriptada en el servicio antes de guardar.
     *
     * @param parentDto DTO con los datos del padre o acudiente
     * @return entidad {@link Parent} mapeada
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", expression = "java(Set.of(\"ROLE_PARENT\"))")
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "password", ignore = true)
    Parent toEntity(ParentRequest parentDto);

    /**
     * Convierte una entidad {@link Parent} a {@link ParentResponse}.
     *
     * @param parentEntity entidad del padre o acudiente
     * @return DTO de respuesta con la información del padre
     */
    @Mapping(target = "role", ignore = true)
    ParentResponse toResponse(Parent parentEntity);

    /**
     * Actualiza una entidad {@link Parent} existente con los datos del request.
     * El {@code id}, {@code roles}, {@code students}, {@code userName}
     * y {@code password} se conservan sin modificación.
     *
     * @param request DTO con los nuevos datos
     * @param parent  entidad a actualizar
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "userName", ignore = true)
    @Mapping(target = "password", ignore = true)
    void updateEntityFromRequest(ParentRequest request, @MappingTarget Parent parent);
}