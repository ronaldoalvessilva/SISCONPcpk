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
public class ControleGravacaoLocacao {

    GravarInternos objGravaIntComp = new GravarInternos();
    ConexaoBancoLocal conectaLocal = new ConexaoBancoLocal();
    int codInterno;
    int codigoPav;
    int codigoCelaDao;

    public ConfereInternos incluirLocacao(ConfereInternos objConf) {
        pesquisarInterno(objConf.getIdInternoCrc());
        pesquisarCela(objConf.getIdCela(), objConf.getNomeCela());
        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("INSERT INTO ITENSLOCACAOINTERNO (IdLoca,IdInternoCrc,IdCela,QtdLanc) VALUES(?,?,?,?)");
            pst.setInt(1, objConf.getIdLoca());
            pst.setInt(2, codInterno);
            pst.setInt(3, codigoCelaDao);
            pst.setInt(4, objConf.getQtdLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }

    public ConfereInternos alterarLocacao(ConfereInternos objConf) {
        pesquisarInterno(objConf.getIdInternoCrc());
        pesquisarCela(objConf.getIdCela(), objConf.getNomeCela());
        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("UPDATE ITENSLOCACAOINTERNO SET IdLoca=?,IdInternoCrc=?,IdCela=?,QtdLanc=? WHERE IdInternoCrc='" + objConf.getIdInternoCrc()+ "'");
            pst.setInt(1, objConf.getIdLoca());
            pst.setInt(2, codInterno);
            pst.setInt(3, codigoCelaDao);
            pst.setInt(4, objConf.getQtdLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }

    public void pesquisarInterno(int codigo) {
        conectaLocal.abrirConexao();
        try {
            conectaLocal.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE IdInternoCrc='" + codigo + "' ");
            conectaLocal.rs.first();
            codInterno = conectaLocal.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conectaLocal.desconecta();
    }

    public void pesquisarCela(int id, String desc) {
        conectaLocal.abrirConexao();
        try {
            conectaLocal.executaSQL("SELECT * FROM CELAS "
                    + "WHERE IdCela='" + id + "' "
                    + "AND EndCelaPav='" + desc + "'");
            conectaLocal.rs.first();
            codigoCelaDao = conectaLocal.rs.getInt("IdCela");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (CELA) a ser exibido !!!" + e);
        }
        conectaLocal.desconecta();
    }
}
