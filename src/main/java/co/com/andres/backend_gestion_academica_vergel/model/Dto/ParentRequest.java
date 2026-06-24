package co.com.andres.backend_gestion_academica_vergel.model.Dto;

public record ParentRequest(

        String name,

        String lastName,

        String phone,

        String addres,

        String email

        ) {
    

        public ParentRequest {
                if (phone == null){
                        phone = "no especificado"; 
                }
                if (addres == null) {
                        addres =  "no especificado";
                }

        }        
}   