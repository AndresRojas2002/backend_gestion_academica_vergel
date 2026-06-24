package co.com.andres.backend_gestion_academica_vergel.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.andres.backend_gestion_academica_vergel.config.exception.enrollmentException.EnrollmentByIdException;
import co.com.andres.backend_gestion_academica_vergel.mapper.EnrollmentMapper;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.EnrollmentRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.EnrollmentResponse;
import co.com.andres.backend_gestion_academica_vergel.model.shared.EnrollmentsState;
import co.com.andres.backend_gestion_academica_vergel.repository.EnrollmentsRepository;
import co.com.andres.backend_gestion_academica_vergel.service.EnrollmentService;
import lombok.RequiredArgsConstructor;

/**
 * Implementación del servicio de gestión de matrículas.
 * 
 * Esta clase proporciona la lógica de negocio para todas las operaciones
 * relacionadas con matrículas, incluyendo transformación de datos,
 * cambio de estado y manejo de excepciones personalizadas.
 * 
 * @author Andres
 * @version 1.0
 * @since 2026
 */
@Service
@RequiredArgsConstructor
public class EnrollmentServiceImp implements EnrollmentService {

    private final EnrollmentsRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    /**
     * Cancela una matrícula existente cambiando su estado a RETIRED.
     * 
     * No elimina el registro de la base de datos, solo actualiza su estado.
     * 
     * @param id Identificador único de la matrícula a cancelar
     * @throws EnrollmentByIdException si no se encuentra una matrícula con el ID especificado
     */
    @Override
    public void retiredEnrollments(Long id) {
        var idEnrollment = enrollmentRepository.findById(id);
        if (!idEnrollment.isPresent()) {
            throw new EnrollmentByIdException();
        }

        var enrollment = idEnrollment.get();
        enrollment.setEnrollmentsState(EnrollmentsState.RETIRED);
        enrollmentRepository.save(enrollment);
    }

    /**
     * Crea una nueva matrícula en el sistema.
     * 
     * Mapea los datos del DTO a la entidad y persiste la nueva matrícula.
     * 
     * @param enrollmentRequest Datos de la matrícula a crear
     * @return EnrollmentResponse con la información de la matrícula creada
     */
    @Override
    public EnrollmentResponse createEnrollments(EnrollmentRequest enrollmentRequest) {
        var entity = enrollmentMapper.toEntity(enrollmentRequest);

        var newEnrollment = enrollmentRepository.save(entity);

        return enrollmentMapper.toResponse(newEnrollment);
    }

    /**
     * Elimina una matrícula del sistema por su identificador único.
     * 
     * @param id Identificador único de la matrícula a eliminar
     * @throws EnrollmentByIdException si no se encuentra una matrícula con el ID especificado
     */
    @Override
    public void deleteEnrollments(Long id) {
        var idEnrollment = enrollmentRepository.findById(id);
        if (!idEnrollment.isPresent()) {
            throw new EnrollmentByIdException();
        }

        var enrollment = idEnrollment.get();
        enrollmentRepository.delete(enrollment);
    }

    /**
     * Obtiene la lista completa de matrículas registradas en el sistema.
     * 
     * @return Lista de matrículas transformada a DTOs de respuesta
     */
    @Override
    public List<EnrollmentResponse> getAllEnrollments() {
        return enrollmentRepository.findAll()
        .stream()
        .map(enrollmentMapper::toResponse)
        .toList();
    }

    /**
     * Busca una matrícula específica por su identificador único.
     * 
     * @param id Identificador único de la matrícula
     * @return EnrollmentResponse con la información de la matrícula encontrada
     * @throws EnrollmentByIdException si no se encuentra una matrícula con el ID especificado
     */
    @Override
    public EnrollmentResponse getByIdEnrollments(Long id) {
        return enrollmentRepository.findById(id)
        .map(enrollmentMapper::toResponse)
        .orElseThrow(() -> new EnrollmentByIdException());
    }

}