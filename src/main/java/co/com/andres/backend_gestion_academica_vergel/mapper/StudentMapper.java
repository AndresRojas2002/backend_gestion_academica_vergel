package co.com.andres.backend_gestion_academica_vergel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.StudentsRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.StudentsResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Students;
import co.com.andres.backend_gestion_academica_vergel.model.shared.Role;

@Mapper(componentModel = "spring", imports = Role.class)
public interface StudentMapper {

    @Mapping (target = "id", ignore = true)
    @Mapping (target = "role", expression = "java(Role.STUDENT)")
    @Mapping(source = "addres", target = "address")
    @Mapping(source = "password", target = "passwort")
    Students toEntity(StudentsRequest studentsDto);


    @Mapping(source = "address", target = "addres")
    StudentsResponse toResponse (Students students);

     @Mapping(target = "id", ignore = true)
    @Mapping(target = "userName", ignore = true)
    @Mapping(target = "passwort", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(source = "addres", target = "address")
    void updateEntityFromRequest(StudentsRequest request, @MappingTarget Students student);

}
