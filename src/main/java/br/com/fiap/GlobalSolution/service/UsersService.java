package br.com.fiap.GlobalSolution.service;

import br.com.fiap.GlobalSolution.datasource.UsersRepository;
import br.com.fiap.GlobalSolution.domainmodel.Address;
import br.com.fiap.GlobalSolution.domainmodel.Users;
import br.com.fiap.GlobalSolution.dto.request.UsersRequest;
import br.com.fiap.GlobalSolution.dto.response.UsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService implements ServiceDTO<Users, UsersRequest, UsersResponse> {

    @Autowired
    private UsersRepository repo;

    @Override
    public List<Users> findAll() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Users> findById(final long id) {
        return this.repo.findById(id);
    }

    @Override
    public Users save(Users a) {return repo.save(a);}

    @Override
    public void delete(final Users e) {
        this.repo.delete(e);
    }

    @Override
    public void deleteById(final long id) {
        this.repo.deleteById(id);
    }

    public Users findByIdUsers(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Users toEntity(UsersRequest dto) {
        return Users.builder()
                .username(dto.username())
                .email(dto.email())
                .password(dto.password())
                .build();
    }

    @Override
    public UsersResponse toResponse(Users e) {
        return UsersResponse.builder()
                .id(e.getId())
                .username(e.getUsername())
                .email(e.getEmail())
                .password(e.getPassword())
                .build();
    }
}