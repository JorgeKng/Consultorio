/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTable;

import com.istloja.modelo.Paciente;
import com.istloja.vistas.GestionMedi;

import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Jorge Kng
 */
public class ModelTableInicio extends AbstractTableModel {

    private String[] m_colNames = {"CEDULA","NOMBRES Y APELLIDOS"};
    private List<Paciente> pacientes;
    private GestionMedi gestionMedi;

    public ModelTableInicio(List<Paciente> Vehiculosbusq, GestionMedi listar) {
        this.pacientes = Vehiculosbusq;
        this.gestionMedi = listar;
    }

    //Determina el número de filas que tengo en mi tabla.
    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    //Determina el número de columnas que tengo en mi tabla.
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paciente b = pacientes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return b.getCedula();
            case 1:
                return b.getNombres();
            
        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gestionMedi.clickPersona(pacientes.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

   

    

    
    

    
}
