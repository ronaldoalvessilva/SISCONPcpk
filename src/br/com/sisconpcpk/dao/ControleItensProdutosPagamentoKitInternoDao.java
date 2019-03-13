/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ProdutosPagtoKitInterno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleItensProdutosPagamentoKitInternoDao {

    ConectaBanco conecta = new ConectaBanco();
    ProdutosPagtoKitInterno objItensPagtoProd = new ProdutosPagtoKitInterno();

    int codProd;
    String pBio = null;
    public static int qtdInternos = 0;

    public ProdutosPagtoKitInterno incluirPagamentoProdutoKitInterno(ProdutosPagtoKitInterno objItensPagtoProd) {
        buscarProduto(objItensPagtoProd.getDescricaoProduto(), objItensPagtoProd.getIdProd());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS (IdPagto,IdItem,IdProd,"
                    + "QuantProd,DataEntrega,Horario,AssinaturaDigitalInterno,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensPagtoProd.getIdPagto());
            pst.setInt(2, objItensPagtoProd.getIdItem());
            pst.setInt(3, codProd);
            pst.setFloat(4, objItensPagtoProd.getQuatProd());
            if (objItensPagtoProd.getDataEntrega() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objItensPagtoProd.getDataEntrega().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objItensPagtoProd.getHorario());
            pst.setBytes(7, objItensPagtoProd.getAssinaturaDigitalInterno());
            pst.setString(8, objItensPagtoProd.getUsuarioInsert());
            pst.setString(9, objItensPagtoProd.getDataInsert());
            pst.setString(10, objItensPagtoProd.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno alterarPagamentoProdutoKitInterno(ProdutosPagtoKitInterno objItensPagtoProd) {
        buscarProduto(objItensPagtoProd.getDescricaoProduto(), objItensPagtoProd.getIdProd());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO SET QuantProd=? "
                    + "WHERE IdProd='" + objItensPagtoProd.getIdProd() + "'");
            pst.setFloat(1, objItensPagtoProd.getQuatProd());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public void buscarProduto(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                    + "WHERE DescricaoProd='" + desc + "' "
                    + "AND IdProd='" + cod + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (PRODUTOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
