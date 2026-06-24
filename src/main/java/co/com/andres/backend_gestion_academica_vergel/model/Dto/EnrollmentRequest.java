package co.com.andres.backend_gestion_academica_vergel.model.Dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;



import jakarta.validation.constraints.NotNull;

public record EnrollmentRequest(

    @NotNull(message = "el id del estudiante no puede ser nulo")
    @JsonAlias({"estudiante"})
    Long students,

    // grado


    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate enrollmentDate ){

 public EnrollmentRequest{

     if (enrollmentDate == null){
        enrollmentDate = LocalDate.now();
    }
}

}
