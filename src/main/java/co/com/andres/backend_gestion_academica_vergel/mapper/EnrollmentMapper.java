package co.com.andres.backend_gestion_academica_vergel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.EnrollmentRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.EnrollmentResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Subject;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Enrollments;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Students;
import co.com.andres.backend_gestion_academica_vergel.model.shared.EnrollmentsState;

public interface EnrollmentMapper {
    @Mapper(componentModel = "spring", imports = { Students.class, Subject.class, EnrollmentsState.class })
    public interface EnrollmentsMapper {

        @Mapping(target = "id", ignore = true)
        @Mapping(target = "students", expression = "java(new Students(studentsDto.students()))")
        @Mapping(target = "courses", expression = "java(new Courses(studentsDto.courses()))")
        @Mapping(target = "enrollmentsState", expression = "java(EnrollmentsState.ACTIVE)")

        Enrollments toEntity(EnrollmentRequest studentsDto);

        EnrollmentResponse toResponse(Enrollments enrollmentsEntity);

    }
}
