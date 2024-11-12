package br.com.fiap.GlobalSolution.service;

import br.com.fiap.GlobalSolution.datasource.TelephoneRepositoy;
import br.com.fiap.GlobalSolution.domainmodel.Telephone;
import br.com.fiap.GlobalSolution.dto.request.TelephoneRequest;
import br.com.fiap.GlobalSolution.dto.response.TelephoneResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TelephoneService implements ServiceDTO<Telephone, TelephoneRequest, TelephoneResponse> {

    @Autowired
    private TelephoneRepositoy repo;

    @Autowired
    private UsersService usersService;

    @Override
    public List<Telephone> findAll() {return this.repo.findAll();}

    @Override
    public Optional<Telephone> findById(final long id) {return this.repo.findById(id);}

    @Override
    public Telephone save(Telephone a) {
        return repo.save(a);
    }

    @Override
    public void delete(final Telephone e){this.repo.delete(e);}

    @Override
    public void deleteById(final long id){this.repo.deleteById(id);}

    public Telephone findByIdTelephone(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Telephone toEntity(TelephoneRequest dto) {

        var users = usersService.findByIdUsers(dto.users().id());

        return Telephone.builder()
                .ddi(dto.ddi())
                .ddd(dto.ddd())
                .number(dto.number())
                .users(users)
                .build();
    }

    @Override
    public TelephoneResponse toResponse(Telephone e) {

        var users = usersService.toResponse(e.getUsers());

        return TelephoneResponse.builder()
                .id(e.getId())
                .ddi(e.getDdi())
                .ddd(e.getDdd())
                .number(e.getNumber())
                .users(users)
                .build();
    }
}