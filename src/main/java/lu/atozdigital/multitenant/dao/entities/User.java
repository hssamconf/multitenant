package lu.atozdigital.multitenant.dao.entities;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class User extends AbstractPersistable<Long> {
    @Column(unique = true)
    private String username;
    private String password;
    private String firstname;
    private String lastname;
}
