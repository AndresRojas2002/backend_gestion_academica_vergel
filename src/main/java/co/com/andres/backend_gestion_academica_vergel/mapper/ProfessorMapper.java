package co.com.andres.backend_gestion_academica_vergel.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.ProfessorRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.ProfessorResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Professors;

/**
 * Mapper para la conversión entre la entidad {@link Professors} y sus DTOs.
 *
 * Utiliza MapStruct para generar automáticamente la implementación
 * en tiempo de compilación.
 *
 * @author Andres
 * @version 1.0
 * @since 2026
 */
@Mapper(componentModel = "spring", imports = Set.class)
public interface ProfessorMapper {

    /**
     * Convierte un {@link ProfessorRequest} a la entidad {@link Professors}.
     * El {@code id}, {@code roles} y {@code subjects} se gestionan fuera del mapper.
     *
     * @param request DTO con los datos del profesor
     * @return entidad {@link Professors} mapeada
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", expression = "java(Set.of(\"ROLE_PROFESSOR\"))")
    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "password", ignore = true)
    Professors toEntity(ProfessorRequest request);

    /**
     * Convierte una entidad {@link Professors} a {@link ProfessorResponse}.
     *
     * @param entity entidad del profesor
     * @return DTO de respuesta con la información del profesor
     */
    @Mapping(target = "role", ignore = true)
    ProfessorResponse toResponse(Professors entity);

    /**
     * Actualiza una entidad {@link Professors} existente con los datos del request.
     * El {@code id}, {@code roles}, {@code professorNumber} y {@code subjects} se conservan.
     *
     * @param request DTO con los nuevos datos
     * @param entity  entidad a actualizar
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "professorNumber", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "userName", ignore = true)
    @Mapping(target = "password", ignore = true)
    void updateEntityFromRequest(ProfessorRequest request, @MappingTarget Professors entity);
}