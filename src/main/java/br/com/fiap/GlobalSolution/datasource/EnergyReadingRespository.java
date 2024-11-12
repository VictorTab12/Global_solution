package br.com.fiap.GlobalSolution.datasource;

import br.com.fiap.GlobalSolution.domainmodel.EnergyReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyReadingRespository extends JpaRepository<EnergyReading, Long> {
}
