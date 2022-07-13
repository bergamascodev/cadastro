package com.bergamascodev.resource;

import com.bergamascodev.repository.dto.ChangeStatusDto;
import com.bergamascodev.repository.dto.ClienteDto;
import com.bergamascodev.repository.dto.ServicoDto;
import com.bergamascodev.repository.entity.Servico;
import com.bergamascodev.service.facade.ServicoFacade;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/cadastro/servico")
public class ServicoResource {

    @Inject
    ServicoFacade servicoFacade;

    @GET
    @Path("/{servicoId}")
    public Response buscarServicoPorId(@PathParam("servicoId") Long id) {
        return Response.ok(servicoFacade.buscarPorId(id)).build();
    }

    @POST
    public Response novoServico(@Valid ServicoDto servicoDto) {
        return Response.ok(servicoFacade.criar(servicoDto)).build();
    }

    @POST
    @Path("/{servicoId}")
    public Response alterarServico(@PathParam("servicoId") Long id, @Valid ServicoDto servicoDto) {
        return Response.ok(servicoFacade.alterar(id, servicoDto)).build();
    }

}
