/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ProdutoInternosKitLote;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.jIdInternoKitBio1;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class ControlePesquisaKitInternoManual {

    ConectaBanco conecta = new ConectaBanco();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();

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
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "'");
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
