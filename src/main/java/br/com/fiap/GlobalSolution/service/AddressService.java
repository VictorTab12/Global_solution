package br.com.fiap.GlobalSolution.service;

import br.com.fiap.GlobalSolution.datasource.AddressRepository;
import br.com.fiap.GlobalSolution.domainmodel.Address;
import br.com.fiap.GlobalSolution.dto.request.AddressRequest;
import br.com.fiap.GlobalSolution.dto.response.AddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService implements ServiceDTO<Address, AddressRequest, AddressResponse> {

    @Autowired
    private AddressRepository repo;

    @Autowired
    private UsersService usersService;

    @Override
    public List<Address> findAll() {return this.repo.findAll();}

    @Override
    public Optional<Address> findById(final long id) {return this.repo.findById(id);}

    @Override
    public Address save(Address a) {return repo.save(a);}

    @Override
    public void delete(final Address e){this.repo.delete(e);}

    @Override
    public void deleteById(final long id){this.repo.deleteById(id);}

    @Override
    public Address toEntity(AddressRequest dto) {

        var users = usersService.findByIdUsers(dto.users().id());

        return Address.builder()
                .cep(dto.cep())
                .street(dto.street())
                .number(dto.number())
                .complement(dto.complement())
                .neighborhood(dto.neighborhood())
                .city(dto.city())
                .state(dto.state())
                .users(users)
                .build();
    }

    @Override
    public AddressResponse toResponse(Address e) {

        var users = usersService.toResponse(e.getUsers());

        return AddressResponse.builder()
                .id(e.getId())
                .cep(e.getCep())
                .street(e.getStreet())
                .number(e.getNumber())
                .complement(e.getComplement())
                .neighborhood(e.getNeighborhood())
                .city(e.getCity())
                .state(e.getState())
                .users(users)
                .build();
    }
}
