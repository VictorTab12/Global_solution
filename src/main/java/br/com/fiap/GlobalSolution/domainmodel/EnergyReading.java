package br.com.fiap.GlobalSolution.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_ENERGY_READING")
public class EnergyReading {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENERGY_READING")
    @SequenceGenerator(name = "SQ_ENERGY_READING", sequenceName = "SQ_ENERGY_READING", allocationSize = 1)
    @Column(name = "ID_ENERGY_READING")
    private @Getter @Setter Long id;

    @Column(name = "DATE_ENERGY_READING")
    private @Getter @Setter LocalDate date;

    @Column(name = "CONSUMPTION_ENERGY_READING")
    private @Getter @Setter String consumption;

    @Column(name = "PRODUCTION_ENERGY_READING")
    private @Getter @Setter String production;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "DEVICE_ENERGY_READING",
            joinColumns = {
                    @JoinColumn(
                            name = "ENERGY_READING",
                            referencedColumnName = "ID_ENERGY_READING",
                            foreignKey = @ForeignKey(name = "FK_ENERGY_READING_DEVICE"))
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "DEVICE",
                            referencedColumnName = "ID_DEVICE",
                            foreignKey = @ForeignKey(name = "FK_DEVICE_ENERGY_READING"))
            }
    )
    private @Getter @Setter Set<Device> device = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnergyReading energyReading)) return false;
        return id == energyReading.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
