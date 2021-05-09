/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTable;

import com.istloja.modelo.Consulta;
import com.istloja.modelo.Paciente;
import com.istloja.vistas.GestionMedi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jorge Kng
 */
public class ModelTableConsultas extends AbstractTableModel {

    private String[] m_colNames = {"N°","FECHA CONSULTAS","MOTIVO DE CONSULTA"};
    private List<Consulta> listaConsultas;
    private GestionMedi gestionMedi;

    public ModelTableConsultas(List<Consulta> listaConsultas, GestionMedi listar) {
        this.listaConsultas = listaConsultas;
        this.gestionMedi = listar;
    }

    //Determina el número de filas que tengo en mi tabla.
    @Override
    public int getRowCount() {
        return listaConsultas.size();
    }

    //Determina el número de columnas que tengo en mi tabla.
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta b = listaConsultas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return b.getIdConsulta();
            case 1:
                return b.getFechaConsulta();
            case 2:
                return b.getMotivoConsulta();
            
            
        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gestionMedi.clickConsulta(listaConsultas.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(List<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }
    
}
