package co.com.andres.backend_gestion_academica_vergel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.andres.backend_gestion_academica_vergel.model.entity.Students;

public interface StudentRepository extends JpaRepository<Students, Long> {

    List<Students> findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String text, String text2);

    List<Students> findByEmailContainingIgnoreCase(String email);

}
