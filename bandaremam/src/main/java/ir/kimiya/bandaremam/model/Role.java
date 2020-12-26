package ir.kimiya.bandaremam.model;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column(name = "rolename",nullable = false)
    private String rolename;

}
