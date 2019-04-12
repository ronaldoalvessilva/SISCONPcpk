/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ComposicaoKit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControlePagamentoKit {
    ConectaBanco conecta = new ConectaBanco();
    ComposicaoKit objComp = new ComposicaoKit();
    
    public ComposicaoKit confirmarPagamentoKit(ComposicaoKit objComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE SET KitPago=?,DataPagamento=? "
                    + "WHERE IdRegistroComp='" + objComp.getIdRegistroComp() + "'");
            pst.setString(1, objComp.getKitPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataPagamentoKit().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }
}