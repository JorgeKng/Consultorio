/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.vistas;

import com.istloja.modelo.Consulta;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jorge Kng
 */
public class GestionConsultas {
    private JTextField txtIdConsulta;
    private JTextField txtMotivoConsulta;
    private JTextArea txtHistoriaEnfermedadActual;
    private JTextArea txtExamenFisico;
    private JTextArea txtEstudiosComplementarios;
    private JTextArea txtDiagnosticos;
    private JTextArea txtTratamientos;
    private JFrame frameGestionMedi;
    private JDateChooser dateConsulta = null;

    public GestionConsultas() {
    }

    public GestionConsultas(JTextField txtIdConsulta, JTextField txtMotivoConsulta, JTextArea txtHistoriaEnfermedadActual, JTextArea txtExamenFisico, JTextArea txtEstudiosComplementarios, JTextArea txtDiagnosticos, JTextArea txtTratamientos, JFrame frameGestionMedi, JDateChooser dateConsulta) {
        this.txtIdConsulta = txtIdConsulta;
        this.txtMotivoConsulta = txtMotivoConsulta;
        this.txtHistoriaEnfermedadActual = txtHistoriaEnfermedadActual;
        this.txtExamenFisico = txtExamenFisico;
        this.txtEstudiosComplementarios = txtEstudiosComplementarios;
        this.txtDiagnosticos = txtDiagnosticos;
        this.txtTratamientos = txtTratamientos;
        this.frameGestionMedi = frameGestionMedi;
        this.dateConsulta = dateConsulta;
    }

    

    public JTextField getTxtIdConsulta() {
        return txtIdConsulta;
    }

    public void setTxtIdConsulta(JTextField txtIdConsulta) {
        this.txtIdConsulta = txtIdConsulta;
    }

    public JTextField getTxtMotivoConsulta() {
        return txtMotivoConsulta;
    }

    public void setTxtMotivoConsulta(JTextField txtMotivoConsulta) {
        this.txtMotivoConsulta = txtMotivoConsulta;
    }

    public JTextArea getTxtHistoriaEnfermedadActual() {
        return txtHistoriaEnfermedadActual;
    }

    public void setTxtHistoriaEnfermedadActual(JTextArea txtHistoriaEnfermedadActual) {
        this.txtHistoriaEnfermedadActual = txtHistoriaEnfermedadActual;
    }

    public JTextArea getTxtExamenFisico() {
        return txtExamenFisico;
    }

    public void setTxtExamenFisico(JTextArea txtExamenFisico) {
        this.txtExamenFisico = txtExamenFisico;
    }

    public JTextArea getTxtEstudiosComplementarios() {
        return txtEstudiosComplementarios;
    }

    public void setTxtEstudiosComplementarios(JTextArea txtEstudiosComplementarios) {
        this.txtEstudiosComplementarios = txtEstudiosComplementarios;
    }

    public JTextArea getTxtDiagnosticos() {
        return txtDiagnosticos;
    }

    public void setTxtDiagnosticos(JTextArea txtDiagnosticos) {
        this.txtDiagnosticos = txtDiagnosticos;
    }

    public JTextArea getTxtTratamientos() {
        return txtTratamientos;
    }

    public void setTxtTratamientos(JTextArea txtTratamientos) {
        this.txtTratamientos = txtTratamientos;
    }

    public JFrame getFrameGestionMedi() {
        return frameGestionMedi;
    }

    public void setFrameGestionMedi(JFrame frameGestionMedi) {
        this.frameGestionMedi = frameGestionMedi;
    }

    public JDateChooser getDateConsulta() {
        return dateConsulta;
    }

    public void setDateConsulta(JDateChooser dateConsulta) {
        this.dateConsulta = dateConsulta;
    }
    
    public Consulta guardarEditarConsulta(){
         if (dateConsulta.getDate()== null) {
            JOptionPane.showMessageDialog(frameGestionMedi, "El campo Fecha de Consulta no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            dateConsulta.requestFocus();// Sirve para ubicar el cursor en un campo vacio.
            return null;
         }
        Consulta p = new Consulta();
        p.setIdConsulta(Integer.parseInt(txtIdConsulta.getText()));
        p.setFechaConsulta(new java.sql.Date(dateConsulta.getDate().getTime()));
        p.setMotivoConsulta(txtMotivoConsulta.getText());
        p.setHistoriaEnfermedad(txtHistoriaEnfermedadActual.getText());
        p.setExamenFisico(txtExamenFisico.getText());
        p.setEstudiosComplementarios(txtEstudiosComplementarios.getText());
        p.setDiagnostricos(txtDiagnosticos.getText());
        p.setTratamientos(txtTratamientos.getText());
        
        return p;
    }
    
    
}
