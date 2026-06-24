package co.com.andres.backend_gestion_academica_vergel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.backend_gestion_academica_vergel.model.Dto.ProfessorRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.ProfessorResponse;
import co.com.andres.backend_gestion_academica_vergel.model.entity.Professors;
import co.com.andres.backend_gestion_academica_vergel.model.shared.Role;

@Mapper(componentModel = "spring", imports = Role.class)
public interface ProfessorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(Role.PROFESSOR)")
    @Mapping(source = "addres", target = "address")
    @Mapping(source = "password", target = "passwort")
    Professors toEntity(ProfessorRequest professorDto);


    @Mapping(source = "address", target = "addres")
    ProfessorResponse toResponse(Professors professorsEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userName", ignore = true)
    @Mapping(target = "passwort", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(source = "addres", target = "address")
    void updateEntityFromRequest(ProfessorRequest request, @MappingTarget Professors professor);
    

}
