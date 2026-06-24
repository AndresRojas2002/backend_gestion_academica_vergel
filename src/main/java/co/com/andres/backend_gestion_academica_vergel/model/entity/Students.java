package co.com.andres.backend_gestion_academica_vergel.model.entity;

import co.com.andres.backend_gestion_academica_vergel.model.shared.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(unique = true, nullable = false)
    private String studentNumber;

    @Column(unique = true, nullable = false)
    private String passwort;

    @Column(unique = true, nullable = false)
    private Role role;

    public Students(Long id) {
        this.id = id;
    }

}
