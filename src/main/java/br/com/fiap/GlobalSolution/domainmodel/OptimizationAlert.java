package br.com.fiap.GlobalSolution.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_OPTIMIZATION_ALERT")
public class OptimizationAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OPTIMIZATION_ALERT")
    @SequenceGenerator(name = "SQ_OPTIMIZATION_ALERT", sequenceName = "SQ_OPTIMIZATION_ALERT", allocationSize = 1)
    @Column(name = "ID_ALERT")
    private @Getter @Setter Long id;

    @Column(name = "TYPE_ALERT")
    private @Getter @Setter String type;

    @Column(name = "DATE_ALERT")
    private @Getter @Setter LocalDate date;

    @Column(name = "DESCRIPTION_ALERT")
    private @Getter @Setter String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "TELEPHONE",
            referencedColumnName = "ID_TEL",
            foreignKey = @ForeignKey(
                    name = "FK_OPTIMIZATION_ALERT_TELEPHONE"
            )
    )
    private @Getter @Setter Telephone telephone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OptimizationAlert optimizationAlert)) return false;
        return id == optimizationAlert.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
