package co.com.andres.backend_gestion_academica_vergel.service;

import java.util.List;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.SubjectRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.SubjectResponse;

public interface SubjectService {
    SubjectResponse createCourse(SubjectRequest courseRequest);

    List<SubjectResponse> getAllCourses();

    SubjectResponse updateCourse(Long id, SubjectRequest courseRequest);

    void deleteCourse(Long id);

    SubjectResponse getByIdCourse(Long id);
}
