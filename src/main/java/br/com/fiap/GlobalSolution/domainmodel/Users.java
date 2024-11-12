package br.com.fiap.GlobalSolution.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_USERS")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USERS")
    @SequenceGenerator(name = "SQ_USERS", sequenceName = "SQ_USERS", allocationSize = 1)
    @Column(name = "ID_USERS")
    private @Getter @Setter Long id;

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }

    @Column(name = "NM_USERS")
    private @Getter @Setter String username;

    @Column(name = "EMAIL_USERS")
    private @Getter @Setter String email;

    @Column(name = "PASS_USERS")
    private @Getter @Setter String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users users)) return false;
        return id == users.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
