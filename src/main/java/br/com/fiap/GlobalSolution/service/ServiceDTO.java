package br.com.fiap.GlobalSolution.service;

import org.springframework.data.domain.Example;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ServiceDTO<Entity, Request, Response> {

    List<Entity> findAll();

    public Optional<Entity> findById(final long id);

    void delete(Entity e);

    void deleteById(long id);

    public Entity save(Entity e);

    public Entity toEntity(Request dto);

    public Response toResponse(Entity e);


}
