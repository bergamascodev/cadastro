package com.bergamascodev.repository;

import com.bergamascodev.repository.entity.Servico;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicoRepository implements PanacheRepositoryBase<Servico, Long> {
}
