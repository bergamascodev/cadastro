package com.bergamascodev.repository;

import com.bergamascodev.repository.entity.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepositoryBase<Cliente, Long> {
}
