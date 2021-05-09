/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelo;

import java.sql.Date;

/**
 *
 * @author Jorge Kng
 */
public class Consulta {
    private int idConsulta;
    private Date fechaConsulta;
    private String motivoConsulta;
    private String historiaEnfermedad;
    private String examenFisico;
    private String estudiosComplementarios;
    private String Diagnostricos;
    private String Tratamientos;
    private int idPacienteConsultar;

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getHistoriaEnfermedad() {
        return historiaEnfermedad;
    }

    public void setHistoriaEnfermedad(String historiaEnfermedad) {
        this.historiaEnfermedad = historiaEnfermedad;
    }

    public String getExamenFisico() {
        return examenFisico;
    }

    public void setExamenFisico(String examenFisico) {
        this.examenFisico = examenFisico;
    }

    public String getEstudiosComplementarios() {
        return estudiosComplementarios;
    }

    public void setEstudiosComplementarios(String estudiosComplementarios) {
        this.estudiosComplementarios = estudiosComplementarios;
    }

    public String getDiagnostricos() {
        return Diagnostricos;
    }

    public void setDiagnostricos(String Diagnostricos) {
        this.Diagnostricos = Diagnostricos;
    }

    public String getTratamientos() {
        return Tratamientos;
    }

    public void setTratamientos(String Tratamientos) {
        this.Tratamientos = Tratamientos;
    }

    public int getIdPacienteConsultar() {
        return idPacienteConsultar;
    }

    public void setIdPacienteConsultar(int idPacienteConsultar) {
        this.idPacienteConsultar = idPacienteConsultar;
    }

    @Override
    public String toString() {
        return "Consulta{" + "idConsulta=" + idConsulta + ", fechaConsulta=" + fechaConsulta + ", motivoConsulta=" + motivoConsulta + ", historiaEnfermedad=" + historiaEnfermedad + ", examenFisico=" + examenFisico + ", estudiosComplementarios=" + estudiosComplementarios + ", Diagnostricos=" + Diagnostricos + ", Tratamientos=" + Tratamientos + ", idPacienteConsultar=" + idPacienteConsultar + '}';
    }
    
    
    
}
