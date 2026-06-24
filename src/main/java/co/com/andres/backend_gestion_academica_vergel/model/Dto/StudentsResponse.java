package co.com.andres.backend_gestion_academica_vergel.model.Dto;

import co.com.andres.backend_gestion_academica_vergel.model.shared.Role;

public record StudentsResponse(
        Long id,

        String name,

        String lastName,

        String phone,

        String addres,

        String email,

        Role role) {

}
