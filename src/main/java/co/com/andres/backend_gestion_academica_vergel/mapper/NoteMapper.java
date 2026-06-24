package co.com.andres.backend_gestion_academica_vergel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.NoteRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.NoteResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Note;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enrollment.id", source = "enrollmentId")
    @Mapping(target = "subject.id", source = "subjectId")
    Note toEntity(NoteRequest request);

    @Mapping(target = "studentName", source = "enrollment.student.name")
    @Mapping(target = "studentLastName", source = "enrollment.student.lastName")
    @Mapping(target = "subjectName", source = "subject.name")
    @Mapping(target = "professorName", expression = "java(entity.getSubject().getProfessor().getName() + ' ' + entity.getSubject().getProfessor().getLastName())")
    NoteResponse toResponse(Note entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enrollment.id", source = "enrollmentId")
    @Mapping(target = "subject.id", source = "subjectId")
    void updateEntityFromRequest(NoteRequest request, @MappingTarget Note entity);
}
    