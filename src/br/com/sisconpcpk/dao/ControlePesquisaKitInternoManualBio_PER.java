/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ProdutoInternosKitLote;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.jIdInternoKitBio;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.jIdInternoKitBio1;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.pTOTAL_ITENS_pesquisado;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_anual;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_decendial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_inicial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_mensal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_quinzenal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_semestral;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jIdKit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class ControlePesquisaKitInternoManualBio_PER {

    ConectaBanco conecta = new ConectaBanco();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    //
    int codInt;
    String utilizado = "Sim";
    int quant = 0;
    int pZERO = 0;

    public List<ProdutoInternosKitLote> PRODUTOS_MANUAL_read() throws Exception {
        pTOTAL_ITENS_pesquisado = 0;
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> listaInternosPavilhaoSelecionados = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdKit, "
                    + "PRODUTOS_AC.DescricaoProd, "
                    + "PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                    + "FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                    + "WHERE IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_inicial.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' "
                    + "OR IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_decendial.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' "
                    + "OR IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_quinzenal.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' "
                    + "OR IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_mensal.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' "
                    + "OR IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_semestral.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' "
                    + "OR IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_anual.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' ");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pDigiProd = new ProdutoInternosKitLote();
                pDigiProd.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiProd.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pDigiProd.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiProd.setQuantidadeProd(conecta.rs.getFloat("QuantItem"));
                listaInternosPavilhaoSelecionados.add(pDigiProd);
                pTOTAL_ITENS_pesquisado++;
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaKitInternoManualBio_PER.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ProdutoInternosKitLote> PRODUTOS_BIO_read() throws Exception {
        pTOTAL_ITENS_pesquisado = 0;
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> listaInternosPavilhaoSelecionados = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT DISTINCT "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdKit, "
                    + "PRODUTOS_AC.DescricaoProd,PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
                    + "FROM ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd=PRODUTOS_AC.IdProd "
                    + "INNER JOIN ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "INNER JOIN KITS_HIGIENE_INTERNO "
                    + "ON COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdKit=KITS_HIGIENE_INTERNO.IdKit "
                    + "INNER JOIN PRODUTOS_KITS_HIGIENE_INTERNO "
                    + "ON PRODUTOS_AC.IdProd=PRODUTOS_KITS_HIGIENE_INTERNO.IdProd "
                    + "WHERE IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_inicial.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' "
                    + "OR IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_decendial.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' "
                    + "OR IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_quinzenal.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' "
                    + "OR IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_mensal.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' "
                    + "OR IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_semestral.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' "
                    + "OR IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp='" + jID_REG_anual.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp!='" + pZERO + "' ");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pDigiProd = new ProdutoInternosKitLote();
                pDigiProd.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiProd.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pDigiProd.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiProd.setQuantidadeProd(conecta.rs.getFloat("QuantItem"));
                listaInternosPavilhaoSelecionados.add(pDigiProd);
                pTOTAL_ITENS_pesquisado++;
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePesquisaKitInternoManualBio_PER.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}


//   + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp IN('" + jID_REG_decendial.getText() + "','"  + jID_REG_quinzenal.getText() + "')");
