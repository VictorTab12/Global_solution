package br.com.fiap.GlobalSolution.service;

import br.com.fiap.GlobalSolution.datasource.DeviceRespository;
import br.com.fiap.GlobalSolution.domainmodel.Device;
import br.com.fiap.GlobalSolution.dto.request.DeviceRequest;
import br.com.fiap.GlobalSolution.dto.response.DeviceResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeviceService implements ServiceDTO<Device, DeviceRequest, DeviceResponse> {

    @Autowired
    private DeviceRespository repo;

    @Autowired
    private UsersService usersService;

    @Override
    public List<Device> findAll() {return this.repo.findAll();}

    @Override
    public Optional<Device> findById(final long id) {return this.repo.findById(id);}

    @Override
    public Device save(Device a) {
        return repo.save(a);
    }

    @Override
    public void delete(final Device e){this.repo.delete(e);}

    @Override
    public void deleteById(final long id){this.repo.deleteById(id);}

    @Override
    public Device toEntity(DeviceRequest dto) {

        var users = usersService.findByIdUsers(dto.users().id());

        return Device.builder()
                .type(dto.type())
                .name(dto.name())
                .status(dto.status())
                .users(users)
                .build();
    }

    @Override
    public DeviceResponse toResponse(Device e) {

        var users = usersService.toResponse(e.getUsers());

        return DeviceResponse.builder()
                .id(e.getId())
                .type(e.getType())
                .name(e.getName())
                .status(e.getStatus())
                .users(users)
                .build();
    }
}