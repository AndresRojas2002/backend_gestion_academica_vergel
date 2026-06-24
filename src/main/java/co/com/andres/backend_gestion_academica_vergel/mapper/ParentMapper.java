package co.com.andres.backend_gestion_academica_vergel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.ParentRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.ParentResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Parent;
import co.com.andres.backend_gestion_academica_vergel.model.shared.Role;

@Mapper(componentModel = "spring", imports = Role.class)
public interface ParentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(Role.PROFESSOR)")
    @Mapping(source = "addres", target = "address")
    @Mapping(source = "password", target = "passwort")
    Parent toEntity(ParentRequest professorDto);


    @Mapping(source = "address", target = "addres")
    ParentResponse toResponse(Parent professorsEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userName", ignore = true)
    @Mapping(target = "passwort", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(source = "addres", target = "address")
    void updateEntityFromRequest(ParentRequest request, @MappingTarget Parent professor);
    
}
