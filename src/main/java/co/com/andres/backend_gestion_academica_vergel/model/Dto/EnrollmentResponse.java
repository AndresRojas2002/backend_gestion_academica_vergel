package co.com.andres.backend_gestion_academica_vergel.model.Dto;

import java.time.LocalDate;


import co.com.andres.backend_gestion_academica_vergel.model.entity.Students;
import co.com.andres.backend_gestion_academica_vergel.model.shared.EnrollmentsState;

public record EnrollmentResponse(
        Long id,

        Students students,

        // grado

        LocalDate enrollmentDate,

        EnrollmentsState enrollmentsState

        ) {

}
