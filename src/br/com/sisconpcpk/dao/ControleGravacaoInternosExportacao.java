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
    int codigoInterno;
    int codigoPav;
    int codigoCelaDao;
    
    public ConfereInternos incluirConfereInternos(ConfereInternos objConf) {
        buscarInternoConfere(objConf.getIdInternoCrc());
        buscarPavilhaoConfere(objConf.getIdPav());
        buscarCelaConfere(objConf.getIdCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CONFERE_INTERNOS (IdInternoCrc,DataConfere,DataRealizacao,HorarioConfere,IdPav,IdCela,DataInsert,UsuarioInsert,HorarioInsert,UsuarioUp,DataUp,HorarioUp,AssinaturaBiometricaInterno) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codigoInterno);
            if (objConf.getDataConfere() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objConf.getDataConfere().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objConf.getDataRealizacao());
            pst.setString(4, objConf.getHorarioConfere());
            pst.setInt(5, codigoPav);
            pst.setInt(6, codigoCelaDao);
            pst.setString(7, objConf.getDataInsert());
            pst.setString(8, objConf.getUsuarioInsert());
            pst.setString(9, objConf.getHorarioInsert());
            pst.setString(10, objConf.getUsuarioUp());
            pst.setString(11, objConf.getDataUp());
            pst.setString(12, objConf.getHorarioUp());
            if (objConf.getAssinaturaBiometricaInterno() != null) {
                pst.setBytes(13, objConf.getAssinaturaBiometricaInterno());
            } else {
                pst.setBytes(13, null);
            }            
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objConf;
    }
    
    public void buscarInternoConfere(int codInt) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE IdInternoCrc='" + codInt + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
    
    public void buscarPavilhaoConfere(int codPav) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO "
                    + "WHERE IdPav='" + codPav + "'");
            conecta.rs.first();
            codigoPav = conecta.rs.getInt("IdPav");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
    
    public void buscarCelaConfere(int codCela) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS "
                    + "WHERE IdCela='" + codCela + "'");
            conecta.rs.first();
            codigoCelaDao = conecta.rs.getInt("IdCela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
