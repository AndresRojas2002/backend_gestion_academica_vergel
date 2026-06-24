package co.com.andres.backend_gestion_academica_vergel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.andres.backend_gestion_academica_vergel.model.entity.Professors;

public interface ProfessorRepository extends JpaRepository<Professors, Long> {

    List<Professors> findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String text, String text2);

    List<Professors> findByEmailContainingIgnoreCase(String email);

}
