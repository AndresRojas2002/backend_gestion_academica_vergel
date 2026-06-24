package co.com.andres.backend_gestion_academica_vergel.model.Dto;

import co.com.andres.backend_gestion_academica_vergel.model.entity.Professors;

public record SubjectResponse(
    Long id,

    String nameSubject,

    String description,

    Professors professors

    // grado
) {
    
}
