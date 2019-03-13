/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ProdutoInternosKitLote;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.jIdInternoKitBio;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleProdutosKitLote {

    ConectaBanco conecta = new ConectaBanco();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    int codProd;

    public ProdutoInternosKitLote incluirProdutosKitInternos(ProdutoInternosKitLote objProdKit) {
        buscarProduto(objProdKit.getDescricaoProduto(), objProdKit.getIdProd());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE (IdRegistroComp,IdKit,IdProd,QuantProd,Utili,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objProdKit.getIdRegistroComp());
            pst.setInt(2, objProdKit.getIdKit());
            pst.setInt(3, codProd);
            pst.setFloat(4, objProdKit.getQuantidadeProd());
            pst.setString(5, objProdKit.getpUtili());
            pst.setString(6, objProdKit.getUsuarioInsert());
            pst.setString(7, objProdKit.getDataInsert());
            pst.setString(8, objProdKit.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarProdutosKitInternos(ProdutoInternosKitLote objProdKit) {
        buscarProduto(objProdKit.getDescricaoProduto(), objProdKit.getIdProd());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE SET IdProd=?,QuantProd=?,Utili=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdProd='" + objProdKit.getIdProd() + "' AND IdRegistroComp='" + objProdKit.getIdRegistroComp() + "'");
            pst.setInt(1, codProd);
            pst.setFloat(2, objProdKit.getQuantidadeProd());
            pst.setString(3, objProdKit.getpUtili());
            pst.setString(4, objProdKit.getUsuarioUp());
            pst.setString(5, objProdKit.getDataUp());
            pst.setString(6, objProdKit.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote excluirProdutosKitInternos(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE WHERE IdProd='" + objProdKit.getIdProd() + "' AND IdRegistroComp='" + objProdKit.getIdRegistroComp() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR itens da requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public void buscarProduto(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC WHERE DescricaoProd='" + nome + "'AND IdProd='" + codigo + "'");
            conecta.rs.first();
            codProd = conecta.rs.getInt("IdProd");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do PRODUTO a ser exibido !!!");
        }
        conecta.desconecta();
    }

    public List<ProdutoInternosKitLote> read() throws Exception {
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> listaInternosPavilhaoSelecionados = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT * FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE  "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON KITS_HIGIENE_INTERNO.IdKit=PRODUTOS_KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON PRODUTOS_KITS_HIGIENE_INTERNO.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio.getText() + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pDigiProd = new ProdutoInternosKitLote();
                pDigiProd.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiProd.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pDigiProd.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiProd.setQuantidadeProd(conecta.rs.getFloat("QuantItem"));
                listaInternosPavilhaoSelecionados.add(pDigiProd);
//                qtdProd = qtdProd + 1;
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}