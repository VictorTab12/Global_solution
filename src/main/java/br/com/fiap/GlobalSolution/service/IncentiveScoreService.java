package br.com.fiap.GlobalSolution.service;

import br.com.fiap.GlobalSolution.datasource.IncentiveScoreRespository;
import br.com.fiap.GlobalSolution.domainmodel.Address;
import br.com.fiap.GlobalSolution.domainmodel.IncentiveScore;
import br.com.fiap.GlobalSolution.dto.request.IncentiveScoreRequest;
import br.com.fiap.GlobalSolution.dto.response.IncentiveScoreResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IncentiveScoreService implements ServiceDTO<IncentiveScore, IncentiveScoreRequest, IncentiveScoreResponse>{

    @Autowired
    private IncentiveScoreRespository repo;

    @Autowired
    private UsersService usersService;

    @Override
    public List<IncentiveScore> findAll() {return this.repo.findAll();}

    @Override
    public Optional<IncentiveScore> findById(final long id) {return this.repo.findById(id);}

    @Override
    public IncentiveScore save(IncentiveScore a) {
        return repo.save(a);
    }

    @Override
    public void delete(final IncentiveScore e){this.repo.delete(e);}

    @Override
    public void deleteById(final long id){this.repo.deleteById(id);}

    @Override
    public IncentiveScore toEntity(IncentiveScoreRequest dto) {

        var users = usersService.findByIdUsers(dto.users().id());

        return IncentiveScore.builder()
                .point(dto.point())
                .target(dto.target())
                .date(dto.date())
                .users(users)
                .build();
    }

    @Override
    public IncentiveScoreResponse toResponse(IncentiveScore e) {

        var users = usersService.toResponse(e.getUsers());

        return IncentiveScoreResponse.builder()
                .id(e.getId())
                .point(e.getPoint())
                .target(e.getTarget())
                .date(e.getDate())
                .users(users)
                .build();
    }
}
