package co.com.andres.backend_gestion_academica_vergel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.NoteRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.NoteResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Note;

/**
 * Mapper para la conversión entre la entidad {@link Note} y sus DTOs.
 *
 * Utiliza MapStruct para generar automáticamente la implementación
 * en tiempo de compilación.
 *
 * @author Andres
 * @version 1.0
 * @since 2026
 */
@Mapper(componentModel = "spring")
public interface NoteMapper {

    /**
     * Convierte un {@link NoteRequest} a la entidad {@link Note}.
     * El {@code id} se gestiona fuera del mapper.
     *
     * @param request DTO con los datos de la nota
     * @return entidad {@link Note} mapeada
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enrollments.id", source = "enrollmentId")
    @Mapping(target = "subject.id", source = "subjectId")
    Note toEntity(NoteRequest request);

    /**
     * Convierte una entidad {@link Note} a {@link NoteResponse}.
     *
     * @param entity entidad de la nota
     * @return DTO de respuesta con la información de la nota
     */
    @Mapping(target = "studentName", source = "enrollments.students.name")
    @Mapping(target = "studentLastName", source = "enrollments.students.lastName")
    @Mapping(target = "subjectName", source = "subject.nameSubject")
    @Mapping(target = "professorName", expression = "java(entity.getSubject().getProfessors().getName() + ' ' + entity.getSubject().getProfessors().getLastName())")
    NoteResponse toResponse(Note entity);

    /**
     * Actualiza una entidad {@link Note} existente con los datos del request.
     * El {@code id} se conserva sin modificación.
     *
     * @param request DTO con los nuevos datos
     * @param entity  entidad a actualizar
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enrollments.id", source = "enrollmentId")
    @Mapping(target = "subject.id", source = "subjectId")
    void updateEntityFromRequest(NoteRequest request, @MappingTarget Note entity);
}