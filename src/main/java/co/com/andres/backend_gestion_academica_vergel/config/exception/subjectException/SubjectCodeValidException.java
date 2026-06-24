package co.com.andres.backend_gestion_academica_vergel.config.exception.subjectException;


/**
 * Excepción personalizada que se lanza cuando el código del curso proporcionado
 * no cumple con el formato requerido (3-4 letras mayúsculas seguido de un guión y 3 dígitos).
 * 
 * Esta excepción extiende RuntimeException y se utiliza para validar que el
 * código del curso siga el patrón establecido por la universidad.
 * 
 * @author Andres
 * @version 1.0
 * @since 2024
 */
public class SubjectCodeValidException extends RuntimeException {
    
    /**
     * Constructor por defecto que inicializa la excepción con un mensaje
     * descriptivo sobre el formato requerido para el código del curso.
     */
    public SubjectCodeValidException() {
        super("EL CÓDIGO DEL CURSO NO ES VÁLIDO. DEBE SEGUIR EL FORMATO: 3-4 LETRAS MAYÚSCULAS SEGUIDO DE UN GUION Y 3 DÍGITOS (EJ: PROG-101)");
    }
}

