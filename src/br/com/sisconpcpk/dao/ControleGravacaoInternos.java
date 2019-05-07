/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ConfereInternos;
import br.com.sisconpcpk.modelo.GravarInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleGravacaoInternos {

    GravarInternos objGravaIntComp = new GravarInternos();
    ConexaoBancoLocal conectaLocal = new ConexaoBancoLocal();
    int codInterno;
    int codigoPav;
    int codigoCelaDao;

    public ConfereInternos incluirConfereInternos(ConfereInternos objConf) {

        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("INSERT INTO PRONTUARIOSCRC (IdInternoCrc,Cnc,ImagemFrente,NomeInternoCrc,SituacaoCrc,BiometriaDedo1,BiometriaDedo2,BiometriaDedo3,BiometriaDedo4) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objConf.getIdInternoCrc());
            pst.setString(2, objConf.getcNc());
            pst.setBytes(3, objConf.getImagemFrente());
            pst.setString(4, objConf.getNomeInternoCrc());
            pst.setString(5, objConf.getSituacao());
            pst.setBytes(6, objConf.getDedo0());
            pst.setBytes(7, objConf.getDedo1());
            pst.setBytes(8, objConf.getDedo2());
            pst.setBytes(9, objConf.getDedo3());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }

    public ConfereInternos alterarConfereInternos(ConfereInternos objConf) {

        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("UPDATE PRONTUARIOSCRC SET Cnc=?,ImagemFrente=?,NomeInternoCrc=?,SituacaoCrc=?,BiometriaDedo1=?,BiometriaDedo2=?,BiometriaDedo3=?,BiometriaDedo4=? WHERE IdInternoCrc='" + objConf.getIdInternoCrc() + "'");
            pst.setString(1, objConf.getcNc());
            pst.setBytes(2, objConf.getImagemFrente());
            pst.setString(3, objConf.getNomeInternoCrc());
            pst.setString(4, objConf.getSituacao());
            pst.setBytes(5, objConf.getDedo0());
            pst.setBytes(6, objConf.getDedo1());
            pst.setBytes(7, objConf.getDedo2());
            pst.setBytes(8, objConf.getDedo3());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }

}
