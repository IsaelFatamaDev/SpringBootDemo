package pe.edu.vallegrande.demomongo.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "clients")
public class Client {

    @Id
    private String clientId;
    private String clientName;
    private String clientLastName;
    private String email;
    private String phone;
    private String status;

    @CreatedDate
    private LocalDateTime createdAt;
}
