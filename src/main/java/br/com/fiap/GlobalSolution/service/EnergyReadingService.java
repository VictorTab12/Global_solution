package br.com.fiap.GlobalSolution.service;

import br.com.fiap.GlobalSolution.datasource.EnergyReadingRespository;
import br.com.fiap.GlobalSolution.domainmodel.EnergyReading;
import br.com.fiap.GlobalSolution.dto.request.EnergyReadingRequest;
import br.com.fiap.GlobalSolution.dto.response.DeviceResponse;
import br.com.fiap.GlobalSolution.dto.response.EnergyReadingResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnergyReadingService implements ServiceDTO<EnergyReading, EnergyReadingRequest, EnergyReadingResponse> {

    @Autowired
    private EnergyReadingRespository repo;

    @Autowired
    private DeviceService deviceService;

    @Override
    public List<EnergyReading> findAll() {return this.repo.findAll();}

    @Override
    public Optional<EnergyReading> findById(final long id) {return this.repo.findById(id);}

    @Override
    public EnergyReading save(EnergyReading d) {
        return repo.save(d);
    }

    @Override
    public void delete(final EnergyReading e){this.repo.delete(e);}

    @Override
    public void deleteById(final long id){this.repo.deleteById(id);}

    @Override
    public EnergyReading toEntity(EnergyReadingRequest dto) {

        return EnergyReading.builder()
                .date(dto.date())
                .consumption(dto.consumption())
                .production(dto.production())
                .build();
    }

    @Override
    public EnergyReadingResponse toResponse(EnergyReading e) {

        Collection<DeviceResponse> device = null;

        if (Objects.nonNull(e.getDevice()) && !e.getDevice().isEmpty())
            device = e.getDevice().stream().map(deviceService::toResponse).toList();

        return EnergyReadingResponse.builder()
                .id(e.getId())
                .date(e.getDate())
                .consumption(e.getConsumption())
                .production(e.getProduction())
                .device(device)
                .build();
    }
}
