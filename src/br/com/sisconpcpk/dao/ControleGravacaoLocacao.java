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

        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("INSERT INTO ITENSLOCACAOINTERNO (IdItem,IdLoca,IdInternoCrc,IdCela,QtdLanc) VALUES(?,?,?,?,?)");
            pst.setInt(1, objConf.getIdItem());
            pst.setInt(2, objConf.getIdLoca());
            pst.setInt(3, objConf.getIdInternoCrc());
            pst.setInt(4, objConf.getIdCela());
            pst.setInt(5, objConf.getQtdLanc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }

    public ConfereInternos alterarLocacao(ConfereInternos objConf) {

        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("UPDATE ITENSLOCACAOINTERNO SET IdLoca=?,IdInternoCrc=?,IdCela=?,QtdLanc=? WHERE IdItem='" + objConf.getIdItem() + "'");
            pst.setInt(1, objConf.getIdLoca());
            pst.setInt(2, objConf.getIdInternoCrc());
            pst.setInt(3, objConf.getIdCela());
            pst.setInt(4, objConf.getQtdLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }
}
