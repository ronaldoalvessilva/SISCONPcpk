/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ItensPagamentoKitInterno;
import br.com.sisconpcpk.modelo.ProdutoInternosKitLote;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleAtualizarKitInternos {

    ConectaBanco conecta = new ConectaBanco();
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();

    public ItensPagamentoKitInterno alterarPagamentoKitInicial(ItensPagamentoKitInterno objItensPagto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_INICIAL_INTERNOS SET DataPago=?,KitPago=? WHERE IdKitInicial='" + objItensPagto.getKitInicial() + "' AND IdInternoCrc='" + objItensPagto.getIdInternoCrc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensPagto.getDataPagto().getTime()));
            pst.setString(2, objItensPagto.getKitPago());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR KIT INICIAL.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPagto;
    }

    public ItensPagamentoKitInterno alterarPagamentoKitDecendial(ItensPagamentoKitInterno objItensPagto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_DECENDIAL_INTERNOS SET DataPago=?,KitPago=? WHERE IdKitDecendial='" + objItensPagto.getKitDecimal() + "' AND IdInternoCrc='" + objItensPagto.getIdInternoCrc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensPagto.getDataPagto().getTime()));
            pst.setString(2, objItensPagto.getKitPago());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR KIT DECENDIAL.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPagto;
    }

    public ItensPagamentoKitInterno alterarPagamentoKitSemestral(ItensPagamentoKitInterno objItensPagto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_SEMESTRAL_INTERNOS SET DataPago=?,KitPago=? WHERE IdKitSemestral='" + objItensPagto.getKitSemestral() + "' AND IdInternoCrc='" + objItensPagto.getIdInternoCrc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensPagto.getDataPagto().getTime()));
            pst.setString(2, objItensPagto.getKitPago());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR KIT SEMESTRAL.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPagto;
    }

    public ProdutoInternosKitLote alterarQuantProduto(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO SET KitPago=? WHERE IdProd='" + objProdKit.getIdProd() + "' AND IdInternoCrc='" + objProdKit.getIdInternoCrc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.setString(2, objProdKit.getPago());
            pst.setFloat(3, objProdKit.getQuantidadeProd());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR KIT SEMESTRAL.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

}
