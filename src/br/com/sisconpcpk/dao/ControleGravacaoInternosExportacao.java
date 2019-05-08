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
public class ControleGravacaoInternosExportacao {

    GravarInternos objGravaIntComp = new GravarInternos();
    ConectaBanco conecta = new ConectaBanco();
    int codInterno;
    int codigoPav;
    int codigoCelaDao;

    public ConfereInternos incluirConfereInternos(ConfereInternos objConf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CONFERE_INTERNOS (IdInternoCrc,DataConfere,DataRealizacao,HorarioConfere,AssinaturaBiometricaInterno,IdPav,IdCela,UsuarioInsert,UsuarioUp,DataInsert,DataUp,HorarioInsert,HorarioUp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objConf.getIdInternoCrc());
            if (objConf.getDataConfere() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objConf.getDataConfere().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objConf.getDataRealizacao());
            pst.setString(4, objConf.getHorarioConfere());
            pst.setBytes(5, objConf.getAssinaturaBiometricaInterno());
            pst.setInt(6, objConf.getIdPav());
            pst.setInt(7, objConf.getIdCela());
            pst.setString(8, objConf.getUsuarioInsert());
            pst.setString(9, objConf.getUsuarioUp());
            pst.setString(10, objConf.getDataInsert());
            pst.setString(11, objConf.getDataUp());
            pst.setString(12, objConf.getHorarioInsert());
            pst.setString(13, objConf.getHorarioUp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objConf;
    }

    public ConfereInternos alterarConfereInternos(ConfereInternos objConf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRONTUARIOSCRC SET IdInternoCrc=?,DataConfere=?,DataRealizacao=?,HorarioConfere=?,AssinaturaBiometricaInterno=?,IdPav=?,IdCela=?,UsuarioInsert=?,UsuarioUp=?,DataInsert=?,DataUp=?,HorarioInsert=?,HorarioUp=? WHERE IdInternoCrc='" + objConf.getIdInternoCrc() + "'");
            pst.setInt(1, objConf.getIdInternoCrc());
            if (objConf.getDataConfere() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objConf.getDataConfere().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objConf.getDataRealizacao());
            pst.setString(4, objConf.getHorarioConfere());
            pst.setBytes(5, objConf.getAssinaturaBiometricaInterno());
            pst.setInt(6, objConf.getIdPav());
            pst.setInt(7, objConf.getIdCela());
            pst.setString(8, objConf.getUsuarioInsert());
            pst.setString(9, objConf.getUsuarioUp());
            pst.setString(10, objConf.getDataInsert());
            pst.setString(11, objConf.getDataUp());
            pst.setString(12, objConf.getHorarioInsert());
            pst.setString(13, objConf.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objConf;
    }

}
