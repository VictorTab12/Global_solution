package br.com.fiap.GlobalSolution.datasource;

import br.com.fiap.GlobalSolution.domainmodel.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRespository extends JpaRepository<Device, Long> {
}
