package co.com.andres.backend_gestion_academica_vergel.model.entity;

import java.time.LocalDate;

import co.com.andres.backend_gestion_academica_vergel.model.shared.EnrollmentsState;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Students students;

    //grado
    
    @Column(nullable = false)
    private LocalDate enrollmentDate;

    @Column(nullable = false)
    private EnrollmentsState enrollmentsState;

    
}
