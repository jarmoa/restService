package com.example.historialmedico.serviciosrest.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jorge
 */
public class VacunaDTO implements Serializable{

    private String nombre;
    private String aplicada;
    private String fecha;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
