package co.com.andres.backend_gestion_academica_vergel.config.exception.subjectException;

/**
 * Excepción personalizada que se lanza cuando se intenta registrar un curso
 * con un código que ya existe en el sistema.
 * 
 * Esta excepción extiende RuntimeException y se utiliza para manejar casos donde
 * se viola la restricción de unicidad del código del curso en la base de datos.
 * 
 * @author Andres
 * @version 1.0
 * @since 2024
 */
public class SubjectWithCodeExistException extends RuntimeException {

    /**
     * Constructor por defecto que inicializa la excepción con un mensaje
     * descriptivo sobre el error de duplicación del código del curso.
     */
    public SubjectWithCodeExistException() {
        super("ESTE CÓDIGO DE CURSO YA SE ENCUENTRA REGISTRADO");
    }

}
