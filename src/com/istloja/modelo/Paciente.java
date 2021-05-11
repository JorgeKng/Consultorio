/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelo;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Paciente {

    private int Id;
    
    private String Cedula = "";
    private String Genero = "";
    private String Nombres = "";
    private String Estado = "";
    private Date FechaNacimiento ;
    private int Edad ;
    private String Correo;
    private String Direccion;
    private String AntecedentesFamiliares ;
    private String AntecedentesPersonales ;
    private String Corugias;
    private String Telefono;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getAntecedentesFamiliares() {
        return AntecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(String AntecedentesFamiliares) {
        this.AntecedentesFamiliares = AntecedentesFamiliares;
    }

    public String getAntecedentesPersonales() {
        return AntecedentesPersonales;
    }

    public void setAntecedentesPersonales(String AntecedentesPersonales) {
        this.AntecedentesPersonales = AntecedentesPersonales;
    }

    public String getCorugias() {
        return Corugias;
    }

    public void setCorugias(String Corugias) {
        this.Corugias = Corugias;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return "Paciente{" + "Id=" + Id + ", Cedula=" + Cedula + ", Genero=" + Genero + ", Nombres=" + Nombres + ", Estado=" + Estado + ", FechaNacimiento=" + FechaNacimiento + ", Edad=" + Edad + ", Correo=" + Correo + ", Direccion=" + Direccion + ", AntecedentesFamiliares=" + AntecedentesFamiliares + ", AntecedentesPersonales=" + AntecedentesPersonales + ", Corugias=" + Corugias + ", Telefono=" + Telefono + '}';
    }

    
    
    


}