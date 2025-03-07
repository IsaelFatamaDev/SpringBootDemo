package pe.edu.vallegrande.demomongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "clients")
public class Client {

    @Id
    private String clientId;
    private String clientName;
    private String clientLastName;
    private String status;


}
