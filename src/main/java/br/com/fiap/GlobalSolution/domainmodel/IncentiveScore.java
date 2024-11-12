package br.com.fiap.GlobalSolution.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_INCENTIVE_SCORE")
public class IncentiveScore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INCENTIVE_SCORE")
    @SequenceGenerator(name = "SQ_INCENTIVE_SCORE", sequenceName = "SQ_INCENTIVE_SCORE", allocationSize = 1)
    @Column(name = "ID_INCENTIVE_SCORE")
    private @Getter @Setter Long id;

    @Column(name = "POINT_INCENTIVE_SCORE")
    private @Getter @Setter Integer point;

    @Column(name = "TARGET_INCENTIVE_SCORE")
    private @Getter @Setter Integer target;

    @Column(name = "DATE_INCENTIVE_SCORE")
    private @Getter @Setter LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "USERS",
            referencedColumnName = "ID_USERS",
            foreignKey = @ForeignKey(
                    name = "FK_INCENTIVE_SCORE_USERS"
            )
    )
    private @Getter @Setter Users users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IncentiveScore incentiveScore)) return false;
        return id == incentiveScore.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
