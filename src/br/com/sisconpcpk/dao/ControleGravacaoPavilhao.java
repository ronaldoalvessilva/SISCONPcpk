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
public class ControleGravacaoPavilhao {

    GravarInternos objGravaIntComp = new GravarInternos();
    ConexaoBancoLocal conectaLocal = new ConexaoBancoLocal();
    int codInterno;
    int codigoPav;
    int codigoCelaDao;

    public ConfereInternos incluirPavilhao(ConfereInternos objConf) {

        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("INSERT INTO PAVILHAO (IdPav,StatusPav,DescricaoPav,Motivo,NivelPav) VALUES(?,?,?,?,?)");
            pst.setInt(1, objConf.getIdPav());
            pst.setString(2, objConf.getStatusPav());
            pst.setString(3, objConf.getNomePavilhao());
            pst.setString(4, objConf.getMotivo());
            pst.setString(5, objConf.getNivel());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }

    public ConfereInternos alterarPavilhao(ConfereInternos objConf) {

        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("UPDATE PAVILHAO SET StatusPav=?,DescricaoPav=?,Motivo=?,NivelPav=? WHERE IdInternoCrc='" + objConf.getIdPav() + "'");
            pst.setString(1, objConf.getStatusPav());
            pst.setString(4, objConf.getNomePavilhao());
            pst.setString(5, objConf.getMotivo());
            pst.setString(6, objConf.getNivel());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ATUALIZAR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }
}
