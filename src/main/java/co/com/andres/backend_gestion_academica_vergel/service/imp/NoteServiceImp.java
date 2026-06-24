package co.com.andres.backend_gestion_academica_vergel.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.andres.backend_gestion_academica_vergel.config.exception.noteExeception.NoteByIdException;
import co.com.andres.backend_gestion_academica_vergel.mapper.NoteMapper;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.NoteRequest;
import co.com.andres.backend_gestion_academica_vergel.model.Dto.NoteResponse;
import co.com.andres.backend_gestion_academica_vergel.repository.NoteRepository;
import co.com.andres.backend_gestion_academica_vergel.service.NoteService;
import lombok.RequiredArgsConstructor;

/**
 * Implementación del servicio de gestión de notas.
 * 
 * Esta clase proporciona la lógica de negocio para todas las operaciones
 * relacionadas con notas, incluyendo transformación de datos
 * y manejo de excepciones personalizadas.
 * 
 * @author Andres
 * @version 1.0
 * @since 2026
 */
@Service
@RequiredArgsConstructor
public class NoteServiceImp implements NoteService{

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    /**
     * Crea una nueva nota en el sistema.
     * 
     * Mapea los datos del DTO a la entidad y persiste la nueva nota.
     * 
     * @param request Datos de la nota a crear
     * @return NoteResponse con la información de la nota creada
     */
    @Override
    public NoteResponse create(NoteRequest request) {
        var entity = noteMapper.toEntity(request);

        var newNote = noteRepository.save(entity);

        return noteMapper.toResponse(newNote);


     
    }

    /**
     * Elimina una nota del sistema por su identificador único.
     * 
     * @param id Identificador único de la nota a eliminar
     * @throws NoteByIdException si no se encuentra una nota con el ID especificado
     */
    @Override
    public void delete(Long id) {
        var idNote = noteRepository.findById(id);
        if (!idNote.isPresent()) {
            throw new NoteByIdException();
        }

        var note = idNote.get();
        noteRepository.delete(note);
        
    } 

    /**
     * Obtiene la lista completa de notas registradas en el sistema.
     * 
     * @return Lista de notas transformada a DTOs de respuesta
     */
    @Override
    public List<NoteResponse> findAll() {
        return  noteRepository.findAll()
        .stream()
        .map(noteMapper:: toResponse)
        .toList();
    }

    

    /**
     * Busca una nota específica por su identificador único.
     * 
     * @param id Identificador único de la nota
     * @return NoteResponse con la información de la nota encontrada
     * @throws NoteByIdException si no se encuentra una nota con el ID especificado
     */
    @Override
    public NoteResponse findById(Long id) {
        return noteRepository.findById(id)
        .map(noteMapper :: toResponse)
        .orElseThrow(()-> new NoteByIdException());
    }

   

   

    /**
     * Actualiza la información de una nota existente.
     * 
     * Verifica la existencia de la nota antes de proceder con la actualización,
     * conservando su ID original.
     * 
     * @param id Identificador único de la nota a actualizar
     * @param request Nuevos datos de la nota
     * @return NoteResponse con la información actualizada de la nota
     * @throws NoteByIdException si no se encuentra una nota con el ID especificado
     */
    @Override
    public NoteResponse update(Long id, NoteRequest request) {
        var idNote = noteRepository.findById(id);
        if (!idNote.isPresent()) {
            throw new NoteByIdException();
        }
          // Se mapea el DTO a la entidad y se conserva el ID original de la nota
          var entity = noteMapper.toEntity(request);
          entity.setId(idNote.get().getId());
          
          
          
  
          var update = noteRepository.save(entity);
          return noteMapper.toResponse(update);
    }
    
} 