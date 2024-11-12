package br.com.fiap.GlobalSolution.datasource;

import br.com.fiap.GlobalSolution.domainmodel.IncentiveScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncentiveScoreRespository extends JpaRepository<IncentiveScore, Long> {
}
