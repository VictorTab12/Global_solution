package br.com.fiap.GlobalSolution.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_DEVICE")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DEVICE")
    @SequenceGenerator(name = "SQ_DEVICE", sequenceName = "SQ_DEVICE", allocationSize = 1)
    @Column(name = "ID_DEVICE")
    private @Getter @Setter Long id;

    @Column(name = "TYPE_DEVICE")
    private @Getter @Setter String type;

    @Column(name = "NAME_DEVICE")
    private @Getter @Setter String name;

    @Column(name = "STATUS_DEVICE")
    private @Getter @Setter String status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "USERS",
            referencedColumnName = "ID_USERS",
            foreignKey = @ForeignKey(
                    name = "FK_DEVICE_USERS"
            )
    )

    private @Getter @Setter Users users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device device)) return false;
        return id == device.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

