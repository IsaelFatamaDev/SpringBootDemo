package pe.edu.vallegrande.sprinbootpostgres.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Data
@Table("clients")
public class Client {

    @Id
    private Long clientId;

    private String clientName;
    private String clientLastName;
    private String email;
    private String phone;
    private String status;
    private LocalDateTime createdAt;
}
