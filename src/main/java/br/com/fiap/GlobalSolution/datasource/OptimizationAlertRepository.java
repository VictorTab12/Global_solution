package br.com.fiap.GlobalSolution.datasource;

import br.com.fiap.GlobalSolution.domainmodel.OptimizationAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptimizationAlertRepository extends JpaRepository<OptimizationAlert, Long> {
}
