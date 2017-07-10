package com.example.historialmedico.serviciosrest.service;

import com.example.historialmedico.serviciosrest.Hijo;
import com.example.historialmedico.serviciosrest.Usuario;
import com.example.historialmedico.serviciosrest.Vacuna;
import com.example.historialmedico.serviciosrest.dto.HijoDto;
import com.example.historialmedico.serviciosrest.dto.UsuarioDTO;
import com.example.historialmedico.serviciosrest.dto.VacunaDTO;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

/**
 *
 * @author jorge
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public Response validarUsuario(String correo) {

        Usuario usuario = (Usuario) getEntityManager().createNamedQuery("Usuario.findByCorreo")
                .setParameter("correo", correo)
                .getSingleResult();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setCorreo(correo);
        if (usuario != null) {
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNombre(usuario.getNombre());
            usuarioDTO.setValido(Boolean.TRUE);
        } else {
            usuarioDTO.setId(0);
            usuarioDTO.setNombre("");
            usuarioDTO.setValido(Boolean.FALSE);
        }

        return Response.ok(usuarioDTO).build();
    }

    public List<HijoDto> obtenerHijos(String idPadre) {

        String query = "SELECT c.* FROM hijo c WHERE c.id_padre = " + idPadre;

        List<Hijo> hijosList = (List<Hijo>) getEntityManager().createNativeQuery(query, Hijo.class).getResultList();

        List<HijoDto> hijoDtoList = null;
        if (hijosList != null) {
            hijoDtoList = new ArrayList<>();
            for (Hijo hijo : hijosList) {
                HijoDto hijoDto = new HijoDto();
                hijoDto.setId(hijo.getId());
                hijoDto.setIdPadre(hijo.getIdPadre().getId());
                hijoDto.setNombre(hijo.getNombre());
                hijoDto.setSexo(hijo.getSexo());
                hijoDto.setEdad(hijo.getEdad());
                hijoDtoList.add(hijoDto);
            }
        }

        return hijoDtoList;
    }

    public List<VacunaDTO> obtenerVacunas(String idHijo, String order) {
        String query = "SELECT c.* FROM vacuna c WHERE c.id_hijo = " + idHijo + "ORDER BY "+order+" asc";

        List<Vacuna> vacunaList = (List<Vacuna>) getEntityManager().createNativeQuery(query, Vacuna.class).getResultList();

        List<VacunaDTO> vacunaDTOList = null;
        if (vacunaList != null) {
            vacunaDTOList = new ArrayList<>();
            for (Vacuna vacuna : vacunaList) {
                VacunaDTO vacunaDTO = new VacunaDTO();
                vacunaDTO.setNombre(vacuna.getNombre());
                vacunaDTO.setAplicada(vacuna.getAplicada());
                vacunaDTO.setFecha(vacuna.getFecha());
                vacunaDTOList.add(vacunaDTO);
            }
        }

        return vacunaDTOList;
    }

}
