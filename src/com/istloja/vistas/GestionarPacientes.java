/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.vistas;

import com.istloja.modelo.Paciente;
import com.istloja.utilidades.Utilidades;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jorge Kng
 */
public class GestionarPacientes {
    private JTextField txtCedula ;
    private JTextField txtNombres ;
    private JTextField txtEdad ;
    private JTextField txtDireccion ;
    private JTextField txtCorreo ;
    private JTextField txtTelefono ;
    private JTextArea txtAnteFamiliares ;
    private JTextArea  txtAntePersonales ;
    private JTextArea  txtCirugias ;
    private Utilidades utilidades;
    private JFrame frameGestionMedi; 
    private JComboBox jbGenero;
    private JComboBox jbEstado;
    private JDateChooser dateNa ;

    public GestionarPacientes() {
    }

    public GestionarPacientes(JTextField txtCedula, JTextField txtNombres, JTextField txtEdad, JTextField txtDireccion, JTextField txtCorreo, JTextField txtTelefono, JTextArea txtAnteFamiliares, JTextArea txtAntePersonales, JTextArea txtCirugias, Utilidades utilidades, JFrame frameGestionMedi, JComboBox jbGenero, JComboBox jbEstado, JDateChooser dateNa) {
        this.txtCedula = txtCedula;
        this.txtNombres = txtNombres;
        this.txtEdad = txtEdad;
        this.txtDireccion = txtDireccion;
        this.txtCorreo = txtCorreo;
        this.txtTelefono = txtTelefono;
        this.txtAnteFamiliares = txtAnteFamiliares;
        this.txtAntePersonales = txtAntePersonales;
        this.txtCirugias = txtCirugias;
        this.utilidades = utilidades;
        this.frameGestionMedi = frameGestionMedi;
        this.jbGenero = jbGenero;
        this.jbEstado = jbEstado;
        this.dateNa = dateNa;
    }

    

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(JTextField txtNombres) {
        this.txtNombres = txtNombres;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(JTextField txtEdad) {
        this.txtEdad = txtEdad;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public JTextArea getTxtAnteFamiliares() {
        return txtAnteFamiliares;
    }

    public void setTxtAnteFamiliares(JTextArea txtAnteFamiliares) {
        this.txtAnteFamiliares = txtAnteFamiliares;
    }

    public JTextArea getTxtAntePersonales() {
        return txtAntePersonales;
    }

    public void setTxtAntePersonales(JTextArea txtAntePersonales) {
        this.txtAntePersonales = txtAntePersonales;
    }

    public JTextArea getTxtCirugias() {
        return txtCirugias;
    }

    public void setTxtCirugias(JTextArea txtCirugias) {
        this.txtCirugias = txtCirugias;
    }

    public Utilidades getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(Utilidades utilidades) {
        this.utilidades = utilidades;
    }

    public JFrame getFrameGestionMedi() {
        return frameGestionMedi;
    }

    public void setFrameGestionMedi(JFrame frameGestionMedi) {
        this.frameGestionMedi = frameGestionMedi;
    }

    public JComboBox getJbGenero() {
        return jbGenero;
    }

    public void setJbGenero(JComboBox jbGenero) {
        this.jbGenero = jbGenero;
    }

    public JComboBox getJbEstado() {
        return jbEstado;
    }

    public void setJbEstado(JComboBox jbEstado) {
        this.jbEstado = jbEstado;
    }

    public JDateChooser getDateNa() {
        return dateNa;
    }

    public void setDateNa(JDateChooser dateNa) {
        this.dateNa = dateNa;
    }

    @Override
    public String toString() {
        return "GestionarPacientes{" + "txtCedula=" + txtCedula + ", txtNombres=" + txtNombres + ", txtEdad=" + txtEdad + ", txtDireccion=" + txtDireccion + ", txtCorreo=" + txtCorreo + ", txtAnteFamiliares=" + txtAnteFamiliares + ", txtAntePersonales=" + txtAntePersonales + ", txtCirugias=" + txtCirugias + ", utilidades=" + utilidades + ", frameGestionMedi=" + frameGestionMedi + ", jbGenero=" + jbGenero + ", jbEstado=" + jbEstado + ", dateNa=" + dateNa + '}';
    }
    
    public Paciente guardarEditar() {
        
        
        if (txtCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionMedi, "El campo cedula no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtCedula.requestFocus();// Sirve para ubicar el cursor en un campo vacio.
            return null;
        }
        if (!utilidades.validadorDeCedula(txtCedula.getText())) {
            JOptionPane.showMessageDialog(frameGestionMedi, "la cedula ingresada no es valida", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (txtNombres.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionMedi, "El campo nombres no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombres.requestFocus();
            return null;
        }
        if (!utilidades.validarCorreo(txtCorreo.getText())) {
            JOptionPane.showMessageDialog(frameGestionMedi, "El correo ingresado no es valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtCorreo.requestFocus();
            return null;
        }
        Paciente p = new Paciente();
        p.setCedula(txtCedula.getText());
        p.setNombres(txtNombres.getText());
        switch (jbGenero.getSelectedIndex()) {
            case 0:
                p.setGenero("No defindo");
                break;
            case 1:
                p.setGenero("Masculino");
                break;
            case 2:
                p.setGenero("Femenino");
                break;

        }
        switch (jbEstado.getSelectedIndex()) {
            case 0:
                p.setEstado("Soltero");
                break;
            case 1:
                p.setEstado("Casado");
                break;
            case 2:
                p.setEstado("Viudo");
                break;
            case 3:
                p.setEstado("Divorciado");

        }
        p.setDireccion(txtDireccion.getText());
        p.setFechaNacimiento(new java.sql.Date(dateNa.getDate().getTime()));
        p.setEdad(Integer.parseInt(txtEdad.getText()));
        p.setCorreo(txtCorreo.getText());
        p.setAntecedentesFamiliares(txtAnteFamiliares.getText());
        p.setAntecedentesPersonales(txtAntePersonales.getText());
        p.setCorugias(txtCirugias.getText());
        p.setTelefono(txtTelefono.getText());
        
        return p;
        
    }
}
