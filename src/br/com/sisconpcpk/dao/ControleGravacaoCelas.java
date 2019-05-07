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
public class ControleGravacaoCelas {

    GravarInternos objGravaIntComp = new GravarInternos();
    ConexaoBancoLocal conectaLocal = new ConexaoBancoLocal();
    int codInterno;
    int codigoPav;
    int codigoCelaDao;

    public ConfereInternos incluirCelas(ConfereInternos objConf) {

        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("INSERT INTO CELAS (IdCela,StatusCela,IdPav,EndCelaPav,Motivo,Capacidade,NrCela,NivelCel) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objConf.getIdCela());
            pst.setString(2, objConf.getStatusCela());
            pst.setInt(3, objConf.getIdPav());
            pst.setString(4, objConf.getNomeCela());
            pst.setString(5, objConf.getMotivo());
            pst.setInt(6, objConf.getCapacidade());
            pst.setInt(7, objConf.getNrCela());
            pst.setString(8, objConf.getNivelCela());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }

    public ConfereInternos alterarCelas(ConfereInternos objConf) {

        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("UPDATE CELAS SET StatusCela=?,IdPav=?,EndCelaPav=?,Motivo=?,Capacidade=?,NrCela=?,NivelCel=? WHERE IdCela='" + objConf.getIdCela()+ "'");
            pst.setString(1, objConf.getStatusCela());
            pst.setInt(2, objConf.getIdPav());
            pst.setString(3, objConf.getNomeCela());
            pst.setString(4, objConf.getMotivo());
            pst.setInt(5, objConf.getCapacidade());
            pst.setInt(6, objConf.getNrCela());
            pst.setString(7, objConf.getNivelCela());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }
}
