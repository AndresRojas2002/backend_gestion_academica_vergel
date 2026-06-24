package co.com.andres.backend_gestion_academica_vergel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.andres.backend_gestion_academica_vergel.model.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade,Long> {
    
}
