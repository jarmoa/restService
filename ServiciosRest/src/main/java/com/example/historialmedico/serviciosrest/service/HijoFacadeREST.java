package com.example.historialmedico.serviciosrest.service;

import com.example.historialmedico.serviciosrest.Hijo;
import com.example.historialmedico.serviciosrest.dto.HijoDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jorge
 */
@Stateless
@Path("hijo")
public class HijoFacadeREST extends AbstractFacade<Hijo> {

    @PersistenceContext(unitName = "com.example.historialmedico_ServiciosRest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public HijoFacadeREST() {
        super(Hijo.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Hijo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Hijo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Hijo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Hijo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Hijo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("obtener/{idPadre}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<HijoDTO> obtenerHijos(@PathParam("idPadre") String idPadre) {
        return super.obtenerHijos(idPadre);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
