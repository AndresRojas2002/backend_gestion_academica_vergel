package co.com.andres.backend_gestion_academica_vergel.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.andres.backend_gestion_academica_vergel.config.exception.subjectException.SubjectByIdException;
import co.com.andres.backend_gestion_academica_vergel.mapper.SubjectMapper;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.SubjectRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.SubjectResponse;
import co.com.andres.backend_gestion_academica_vergel.repository.SubjectRepository;
import co.com.andres.backend_gestion_academica_vergel.service.SubjectService;
import lombok.RequiredArgsConstructor;

/**
 * Implementación del servicio de gestión de materias.
 * 
 * Esta clase proporciona la lógica de negocio para todas las operaciones
 * relacionadas con materias, incluyendo transformación de datos
 * y manejo de excepciones personalizadas.
 * 
 * @author Andres
 * @version 1.0
 * @since 2026
 */
@Service
@RequiredArgsConstructor
public class SubjectServiceImp implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    /**
     * Crea una nueva materia en el sistema.
     * 
     * Mapea los datos del DTO a la entidad y persiste la nueva materia.
     * 
     * @param subjectRequest Datos de la materia a crear
     * @return SubjectResponse con la información de la materia creada
     */
    @Override
    public SubjectResponse createSubject(SubjectRequest subjectRequest) {
       
        var entity = subjectMapper.toEntity(subjectRequest);

        var newSubject = subjectRepository.save(entity);

        return subjectMapper.toResponse(newSubject);
    }
 
    /**
     * Elimina una materia del sistema por su identificador único.
     * 
     * @param id Identificador único de la materia a eliminar
     * @throws SubjectByIdException si no se encuentra una materia con el ID especificado
     */
    @Override
    public void deleteSubject(Long id) {
        var idSubject = subjectRepository.findById(id);
        if (!idSubject.isPresent()) {
            throw new SubjectByIdException();
        }

        var subject = idSubject.get();
        subjectRepository.delete(subject);
        
    }

    /**
     * Obtiene la lista completa de materias registradas en el sistema.
     * 
     * @return Lista de materias transformada a DTOs de respuesta
     */
    @Override
    public List<SubjectResponse> getAllSubject() {
       return subjectRepository.findAll()
       .stream()
       .map(subjectMapper::toResponse)
       .toList();
    }

    /**
     * Busca una materia específica por su identificador único.
     * 
     * @param id Identificador único de la materia
     * @return SubjectResponse con la información de la materia encontrada
     * @throws SubjectByIdException si no se encuentra una materia con el ID especificado
     */
    @Override
    public SubjectResponse getByIdSubject(Long id) {
        return subjectRepository.findById(id)
        .map(subjectMapper :: toResponse)
        .orElseThrow(()-> new SubjectByIdException());
    }

    /**
     * Actualiza la información de una materia existente.
     * 
     * Verifica la existencia de la materia antes de proceder con la actualización,
     * conservando su ID original.
     * 
     * @param id Identificador único de la materia a actualizar
     * @param subjectRequest Nuevos datos de la materia
     * @return SubjectResponse con la información actualizada de la materia
     * @throws SubjectByIdException si no se encuentra una materia con el ID especificado
     */
    @Override
    public SubjectResponse updateSubject(Long id, SubjectRequest subjectRequest) {
        var idSubject = subjectRepository.findById(id);
        if (!idSubject.isPresent()) {
            throw new SubjectByIdException();
        }

          // Se mapea el DTO a la entidad y se conserva el ID original de la materia
          var entity = subjectMapper.toEntity(subjectRequest);
          entity.setId(idSubject.get().getId());
          
          var update = subjectRepository.save(entity);
          return subjectMapper.toResponse(update);
    }
    
}