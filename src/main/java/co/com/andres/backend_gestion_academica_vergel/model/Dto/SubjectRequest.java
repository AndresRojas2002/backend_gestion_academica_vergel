package co.com.andres.backend_gestion_academica_vergel.model.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import co.com.andres.backend_gestion_academica_vergel.model.entity.Professors;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SubjectRequest(

        @NotBlank(message = "el curso no puede ser nulo") 
        @JsonAlias({"nombre_curso", "curso" }) 
        String nameSubject,


        @JsonAlias({ "descripcion" }) 
        String description,

        @JsonAlias({ "profesor","maestro" }) 
        @NotNull(message = "el curso debe tener un profesor asignado") 
        Professors professors

        // grado

    ) {
        
    public SubjectRequest {
        if (description == null) {
            description = "no hay descripcion disponible";

        }
       

    }

}
