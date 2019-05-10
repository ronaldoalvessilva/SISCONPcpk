/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ConfereInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleLimparTabelaDao {

    ConexaoBancoLocal conectaLocal = new ConexaoBancoLocal();

    public ConfereInternos excluirRegistroTabelaConfere(ConfereInternos objConf) {

        conectaLocal.abrirConexao();
        try {
            PreparedStatement pst = conectaLocal.con.prepareStatement("DELETE FROM CONFERE_INTERNOS");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO:" + ex);
        }
        conectaLocal.desconecta();
        return objConf;
    }
}
