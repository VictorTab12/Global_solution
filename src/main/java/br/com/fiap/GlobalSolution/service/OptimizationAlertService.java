package br.com.fiap.GlobalSolution.service;

import br.com.fiap.GlobalSolution.datasource.OptimizationAlertRepository;
import br.com.fiap.GlobalSolution.domainmodel.Address;
import br.com.fiap.GlobalSolution.domainmodel.OptimizationAlert;
import br.com.fiap.GlobalSolution.dto.request.OptimizationAlertRequest;
import br.com.fiap.GlobalSolution.dto.response.OptimizationAlertResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OptimizationAlertService implements ServiceDTO<OptimizationAlert, OptimizationAlertRequest, OptimizationAlertResponse>{

    @Autowired
    private OptimizationAlertRepository repo;

    @Autowired
    private TelephoneService telephoneService;

    @Override
    public List<OptimizationAlert> findAll() {return this.repo.findAll();}

    @Override
    public Optional<OptimizationAlert> findById(final long id) {return this.repo.findById(id);}

    @Override
    public OptimizationAlert save(OptimizationAlert a) {
        return repo.save(a);
    }

    @Override
    public void delete(final OptimizationAlert e){this.repo.delete(e);}

    @Override
    public void deleteById(final long id){this.repo.deleteById(id);}

    @Override
    public OptimizationAlert toEntity(OptimizationAlertRequest dto) {

        var telephone = telephoneService.findByIdTelephone(dto.telephone().id());

        return OptimizationAlert.builder()
                .type(dto.description())
                .date(dto.date())
                .description(dto.description())
                .telephone(telephone)
                .build();
    }

    @Override
    public OptimizationAlertResponse toResponse(OptimizationAlert e) {

        var telephone = telephoneService.toResponse(e.getTelephone());

        return OptimizationAlertResponse.builder()
                .id(e.getId())
                .type(e.getType())
                .date(e.getDate())
                .description(e.getDescription())
                .telephone(telephone)
                .build();
    }
}

