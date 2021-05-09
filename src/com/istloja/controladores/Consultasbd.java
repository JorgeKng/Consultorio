/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controladores;

import com.istloja.conexionbd.Conexion;
import com.istloja.modelo.Consulta;
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
public class Consultasbd {
    public Utilidades utilidades;

    public Consultasbd() {
        utilidades = new Utilidades();
    }

    public boolean IngresarConsulta(Consulta p) {

        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;

        String sql = "INSERT INTO `consultorio`.`consultas` (`id_consulta`, `fecha_consulta`, `motivo_consulta`, `historia_enfermedad_actual`, `examen_fisico`, `estudios_complementarios`, `Diagnosticos`, `Tratamientos`, `id_paciente_consultar`) VALUES "
                + "('"+String.valueOf(p.getIdConsulta())+"', '"+utilidades.devolverFecha(p.getFechaConsulta())+"', '"+p.getMotivoConsulta()+"', '"+p.getHistoriaEnfermedad()+"', '"+p.getExamenFisico()+"', '"+p.getEstudiosComplementarios()+"', '"+p.getDiagnostricos()+"', '"+p.getTratamientos()+"', '"+String.valueOf(p.getIdPacienteConsultar())+"');";
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

    public boolean ActualizarConsulta(Consulta p) {

        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;

        String sql = "UPDATE `consultorio`.`consultas` SET "
                + "`fecha_consulta` = '"+utilidades.devolverFecha(p.getFechaConsulta())+"', "
                + "`motivo_consulta` = '"+p.getMotivoConsulta()+"', "
                + "`historia_enfermedad_actual` = '"+p.getHistoriaEnfermedad()+"', "
                + "`examen_fisico` = '"+p.getExamenFisico()+"', "
                + "`estudios_complementarios` = '"+p.getEstudiosComplementarios()+"',"
                + " `Diagnosticos` = '"+p.getDiagnostricos()+"', "
                + "`Tratamientos` = '"+p.getTratamientos()+"' WHERE (`id_consulta` = '"+p.getIdConsulta()+"');";
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

    public boolean EliminarConsulta(Consulta p) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;

        String sql = "DELETE FROM `consultorio`.`consultas` WHERE (`id_consulta` = '"+p.getIdConsulta()+"'););";
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
    public List<Consulta> ObeterHistorialClinico(Paciente p) {
        
        //Interfaz de acceso a la base de datos
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;

        String sql = "SELECT * FROM pacientes inner join consultas where id_paciente = "+String.valueOf(p.getId())+" and id_paciente_consultar = "+String.valueOf(p.getId())+";";
      
        List<Consulta> listaConsulta = new ArrayList<Consulta>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {

                Consulta g = new Consulta();
                g.setIdConsulta(rs.getInt(13));
                g.setFechaConsulta(rs.getDate(14));
                g.setMotivoConsulta(rs.getString(15));
                g.setHistoriaEnfermedad(rs.getString(16));
                g.setExamenFisico(rs.getString(17));
                g.setEstudiosComplementarios(rs.getString(18));
                g.setDiagnostricos(rs.getString(19));
                g.setTratamientos(rs.getString(20));
                g.setIdPacienteConsultar(rs.getInt(21));
                

                listaConsulta.add(g);

            }
           
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());

        }
        
        return listaConsulta;
    }
    

   
}
