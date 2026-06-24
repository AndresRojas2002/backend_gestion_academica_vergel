package co.com.andres.backend_gestion_academica_vergel.model.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.Email;    
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentsRequest(
        //@NotBlank(message = "el usuario no puede ser nulo")
        //@Min(value = 8, message = "el usuario debe contener al menos 8 caracteres")
        //@JsonAlias({"user_name", "usuario"})
        //String userName,

        @NotBlank(message = "el nombre no puede ser nulo")
        @JsonAlias({"nombre"})
        String name,

        @NotBlank(message = "el apellido no puede ser nulo")
        @JsonAlias({"apellido"})
        String lastName,

        @Size(min = 7, max = 15, message = "el mumero de telefono debe de tener entre 7 y 15 caracteres")
        @JsonAlias({"numero_telefono", "telefono"})
        String phone,

        @JsonAlias({"direccion"})
        String addres,

        @NotBlank(message = "el usuario no puede ser nulo")
        @Email (message = "el formato del correo electronico no es valido ")
        @JsonAlias({"correo_electronico", "email"})
        String email

       // @NotBlank(message = "la contraseña no puede ser nula")
       // @Size(min = 8, max = 20, message = "la contraseña debe tener entre 8 y 20 caracteres")
       // @JsonAlias({"contraseña"})
       // String password 
) {
        public StudentsRequest {
                if (phone == null){
                        phone = "no especificado"; 
                }
                if (addres == null) {
                        addres =  "no especificado";
                }

        }        
}
