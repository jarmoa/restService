package com.example.historialmedico.serviciosrest.dto;

import java.util.Date;

/**
 *
 * @author jorge
 */
public class VacunaDTO {

    private String nombre;
    private String aplicada;
    private Date fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAplicada() {
        return aplicada;
    }

    public void setAplicada(String aplicada) {
        this.aplicada = aplicada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
