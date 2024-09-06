package pe.sermaluc.register.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class User {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerRegister;
    private String name;
    private String email;
    private String password;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @Column
    private LocalDateTime lastLogin;

    private String token;
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id") // Clave foránea en la tabla phones
    private List<Phone> phones;

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
        this.lastLogin = this.created;
        this.active = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.modified = LocalDateTime.now();
    }
}
