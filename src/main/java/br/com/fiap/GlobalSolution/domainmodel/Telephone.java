package br.com.fiap.GlobalSolution.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_TELEPHONE")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEPHONE")
    @SequenceGenerator(name = "SQ_TELEPHONE", sequenceName = "SQ_TELEPHONE", allocationSize = 1)
    @Column(name = "ID_TEL")
    private @Getter @Setter Long id;

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }

    @Column(name = "DDI_TEL")
    private @Getter @Setter  String ddi;

    @Column(name = "DDD_TEL")
    private @Getter @Setter String ddd;

    @Column(name = "NUM_TEL")
    private @Getter @Setter String number;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "USERS",
            referencedColumnName = "ID_USERS",
            foreignKey = @ForeignKey(
                    name = "FK_TELEPHONE_USERS"
            )
    )

    private @Getter @Setter Users users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telephone telephone)) return false;
        return id == telephone.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
