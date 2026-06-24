package co.com.andres.backend_gestion_academica_vergel.config.exception.authenticate;

public class InvalidCredentialsProfessorException extends RuntimeException{
    
    /**
     * Constructor por defecto con mensaje predefinido en mayúsculas.
     * Se utiliza cuando las credenciales del profesor son incorrectas.
     */
    public InvalidCredentialsProfessorException() {
        super("EL CORREO ELECTRÓNICO O LA CONTRASEÑA DEL PROFESOR SON INCORRECTOS");
    }
}
