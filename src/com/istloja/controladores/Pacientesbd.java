/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controladores;

import com.istloja.conexionbd.Conexion;
import com.istloja.modelo.Paciente;
import com.istloja.utilidades.Utilidades;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Kng
 */
public class Pacientesbd {
    public Utilidades utilidades;

    public Pacientesbd() {
        utilidades = new Utilidades();
    }

    public boolean IngresarPaciente(Paciente p) {

        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;

        String sql = "INSERT INTO `consultorio`.`pacientes` ( `cedula`, `genero`, `nombres`, `estado`, `f_nacimiento`, `edad`, `correo`, `direccion`, `antecedentes_familiares`, `antecedentes_personales`, `cirugias`, `telefono`) VALUES "
                + "('"+p.getCedula()+"', '"+p.getGenero()+"', '"+p.getNombres()+"', '"+p.getEstado()+"', '"+utilidades.devolverFecha(p.getFechaNacimiento())+"', '"+String.valueOf(p.getEdad())+"', '"+p.getCorreo()+"', '"+p.getDireccion()+"', '"+p.getAntecedentesFamiliares()+"', '"+p.getAntecedentesPersonales()+"', '"+p.getCorugias()+"','"+p.getTelefono()+"');";
        try {
            //Es una instancia de la conexion previamente creada.

            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);

            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return registrar;
    }

    public boolean ActualizarPaciente(Paciente p) {

        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;

        String sql = "UPDATE `consultorio`.`pacientes` SET "
                + "`cedula` = '"+p.getCedula()+"',"
                + " `genero` = '"+p.getGenero()+"', "
                + "`nombres` = '"+p.getNombres()+"', "
                + "`estado` = '"+p.getEstado()+"', "
                + "`f_nacimiento` = '"+utilidades.devolverFecha(p.getFechaNacimiento())+"', "
                + "`edad` = '"+String.valueOf(p.getEdad())+"', "
                + "`correo` = '"+p.getCorreo()+"', "
                + "`direccion` = '"+p.getDireccion()+"', "
                + "`antecedentes_familiares` = '"+p.getAntecedentesFamiliares()+"',"
                + " `antecedentes_personales` = '"+p.getAntecedentesPersonales()+"',"
                + " `cirugias` = '"+p.getCorugias()+"',"
                + ", `telefono` = '"+p.getTelefono()+"' WHERE (`id_paciente` = '"+p.getId()+"');";
        System.out.println(p);
        
        try {
            //Es una instancia de la conexion previamente creada.

            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);
            
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return registrar;
    }

    public boolean EliminarPaciente(Paciente p) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;

        String sql = "DELETE FROM `consultorio`.`pacientes` WHERE (`id_paciente` = '"+p.getId()+"');";
        try {
            //Es una instancia de la conexion previamente creada.

            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);

            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return registrar;
    }

    public List<Paciente> ObeterPacientes() {
        
        //Interfaz de acceso a la base de datos
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;

        String sql = "SELECT * FROM consultorio.pacientes;";

        List<Paciente> listaPacientes = new ArrayList<Paciente>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {

                Paciente v = new Paciente();
                v.setId(rs.getInt(1));
                v.setCedula(rs.getString(2));
                v.setGenero(rs.getString(3));
                v.setNombres(rs.getString(4));
                v.setEstado(rs.getString(5));
                v.setFechaNacimiento(new java.sql.Date(rs.getDate(6).getTime()));
                v.setEdad(rs.getInt(7));
                v.setCorreo(rs.getString(8));
                v.setDireccion(rs.getString(9));
                v.setAntecedentesFamiliares(rs.getString(10));
                v.setAntecedentesPersonales(rs.getString(11));
                v.setCorugias(rs.getString(12));
                v.setTelefono(rs.getString(13));

                listaPacientes.add(v);

            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());

        }
        
        return listaPacientes;
    }

   
}
