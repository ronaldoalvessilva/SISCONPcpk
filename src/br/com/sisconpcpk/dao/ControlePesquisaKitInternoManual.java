/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ProdutoInternosKitLote;
import br.com.sisconpcpk.modelo.ProdutosPagtoKitInterno;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.jIdInternoKitBio1;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.codItem;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.codigoInterno;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.codigoInternoKit;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.codigoKit;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.estoque;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.jComboBoxPesquisarInterno;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.jIdInternoKitBio;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.pCodigoInterno;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.pKitPago;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.statusFinal;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.pRegistroComp;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.pCodigoProd;
import static br.com.sisconpcpk.visao.TelaBiometriaKitInternoCPK.pQuantidade;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jComboBoxPavilhao;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_Kit_anual;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_Kit_decendial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_Kit_inicial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_Kit_mensal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_Kit_quinzenal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_Kit_semestral;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_decendial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_inicial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jID_REG_quinzenal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jIdKit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jIdLanc;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitAnual;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitDecendial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitInicial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitMensal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitQuinzenal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jRBtKitSemestral;

/**
 *
 * @author Socializa TI 02
 */
public class ControlePesquisaKitInternoManual {

    ConectaBanco conecta = new ConectaBanco();
    ProdutoInternosKitLote objProdKit = new ProdutoInternosKitLote();
    ProdutosPagtoKitInterno objItensPagtoProd = new ProdutosPagtoKitInterno();
    //
    int codInt;
    String utilizado = "Sim";
    int quant = 0;
    int pZERO = 0;

    public ProdutoInternosKitLote alterarKitInicial(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_INICIAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarKitDecendial(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_DECENDIAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarKitQuinzenal(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_QUINZENAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarKitMensal(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_MENSAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarKitSemestral(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_SEMESTRAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote alterarKitAnual(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE KITS_ANUAL_INTERNOS SET KitPago=?,DataPagto=? "
                    + "WHERE IdInternoCrc='" + objProdKit.getIdInternoCrc() + "' "
                    + "AND Utilizado='" + utilizado + "'");
            pst.setString(1, objProdKit.getPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objProdKit.getDataPagto().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do INTERNO.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objProdKit;
    }

    public List<ProdutoInternosKitLote> read() throws Exception {
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> listaInternosPavilhaoSelecionados = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.IdKit, "
                    + "PRODUTOS_AC.DescricaoProd,PRODUTOS_AC.UnidadeProd, "
                    + "PRODUTOS_KITS_HIGIENE_INTERNO.QuantItem "
//                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
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
                    + "AND PRODUTOS_KITS_HIGIENE_INTERNO.IdKit='" + jIdKit.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + quant + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pDigiProd = new ProdutoInternosKitLote();
                pDigiProd.setIdProd(conecta.rs.getInt("IdProd"));
                pDigiProd.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pDigiProd.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pDigiProd.setQuantidadeProd(conecta.rs.getFloat("QuantItem"));
//                pDigiProd.setQtdEstoque(conecta.rs.getFloat("QuantProd"));
                listaInternosPavilhaoSelecionados.add(pDigiProd);
            }
            return listaInternosPavilhaoSelecionados;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public ProdutoInternosKitLote pPESQUISAR_CODIGO_kitPago(ProdutoInternosKitLote objProdKit) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS.IdItem "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS");
            conecta.rs.last();
            codItem = conecta.rs.getInt("IdItem");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote pPESQUISAR_LIBERACAO_BIOMETRIA_internos(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto, "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND IdPagto='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoKit = conecta.rs.getString("IdPagto");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote pPESQUISAR_VERIFICAR_LIBERACAO_MANUAL_internos(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc, "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND IdPagto='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoKit = conecta.rs.getString("IdPagto");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote pPESQUISAR_PRODUTOS_LIBERACAO_BIOMETRIA_internos(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
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
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + estoque + "'");
            conecta.rs.first();
            codigoInternoKit = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote pPESQUISAR_PRODUTOS_LIBERACAO_MANUAL_internos(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "KITS_HIGIENE_INTERNO.IdKit, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
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
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + estoque + "'");
            conecta.rs.first();
            codigoInternoKit = conecta.rs.getString("IdInternoCrc");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    //---------------------------------------- PESQUISA DE KITS DE HIGIENE DE INTERNOS -------------------------------------
    public ProdutoInternosKitLote pPESQUISAR_PRODUTOS_KIT_inicial(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc, "
                    + "COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp, "
                    + "PAVILHAO.DescricaoPav,KITS_INICIAL_INTERNOS.KitPago,KITS_INICIAL_INTERNOS.Utilizado "
                    + "FROM  PRONTUARIOSCRC "
                    + "INNER JOIN BIOMETRIA_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "INNER JOIN KITS_INICIAL_INTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=KITS_INICIAL_INTERNOS.IdInternoCrc "
                    + "WHERE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp='" + statusFinal + "' "
                    + "AND PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_INICIAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_INICIAL_INTERNOS.Utilizado='" + utilizado + "'"
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote pPESQUISAR_PRODUTOS_KIT_decendial(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PAVILHAO.DescricaoPav, "
                    + "KITS_DECENDIAL_INTERNOS.KitPago, "
                    + "KITS_DECENDIAL_INTERNOS.Utilizado "
                    + "FROM KITS_DECENDIAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_DECENDIAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_DECENDIAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote pPESQUISAR_PRODUTOS_KIT_quinzenal(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PAVILHAO.DescricaoPav, "
                    + "KITS_QUINZENAL_INTERNOS.KitPago, "
                    + "KITS_QUINZENAL_INTERNOS.Utilizado "
                    + "FROM KITS_QUINZENAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_QUINZENAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_QUINZENAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_QUINZENAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote pPESQUISAR_PRODUTOS_KIT_mensal(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PAVILHAO.DescricaoPav, "
                    + "KITS_MENSAL_INTERNOS.KitPago,KITS_MENSAL_INTERNOS.Utilizado "
                    + "FROM KITS_MENSAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_MENSAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_MENSAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_MENSAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote pPESQUISAR_PRODUTOS_KIT_semestral(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PAVILHAO.DescricaoPav, "
                    + "KITS_SEMESTRAL_INTERNOS.KitPago,KITS_SEMESTRAL_INTERNOS.Utilizado "
                    + "FROM KITS_SEMESTRAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_SEMESTRAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_SEMESTRAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_SEMESTRAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public ProdutoInternosKitLote pPESQUISAR_PRODUTOS_KIT_anual(ProdutoInternosKitLote objProdKit) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PAVILHAO.DescricaoPav, "
                    + "KITS_ANUAL_INTERNOS.KitPago,KITS_ANUAL_INTERNOS.Utilizado "
                    + "FROM KITS_ANUAL_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON KITS_ANUAL_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND KITS_ANUAL_INTERNOS.KitPago='" + pKitPago + "' "
                    + "AND KITS_ANUAL_INTERNOS.Utilizado='" + utilizado + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            conecta.rs.first();
            do {
                jComboBoxPesquisarInterno.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objProdKit;
    }

    public List<ProdutosPagtoKitInterno> pPESQUISAR_PRODUTO_interno() throws Exception {
        conecta.abrirConexao();
        List<ProdutosPagtoKitInterno> listaInternosKitPago = new ArrayList<ProdutosPagtoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS.IdItem, "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto, "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc,"
                    + "PRONTUARIOSCRC.NomeInternoCrc "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto='" + jIdLanc.getText() + "' "
                    + "ORDER BY IdItem");
            while (conecta.rs.next()) {
                ProdutosPagtoKitInterno pListaInternos = new ProdutosPagtoKitInterno();
                pListaInternos.setIdItem(conecta.rs.getInt("IdItem"));
                pListaInternos.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListaInternos.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pListaInternos.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                listaInternosKitPago.add(pListaInternos);
            }
            return listaInternosKitPago;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_biometria(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jIdKit.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_manual(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jIdKit.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    //PESQUISA PARA KIT PERSONALIZADO POR BIOMETRIA
    public ProdutosPagtoKitInterno pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Binicial(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_inicial.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Bdecendial(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_decendial.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Bquinzenal(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_quinzenal.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Bmensal(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_mensal.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Bsemestral(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_semestral.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANTIDADE_PRODUTOS_INTERNOS_PERSONALIZADO_Banual(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_anual.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objItensPagtoProd;
    }

    //PESQUISAS PARA KIT MANUAL PERSONALIZADO
    public ProdutosPagtoKitInterno pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Minicial(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_inicial.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Mdecendial(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_decendial.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Mquinzenal(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_quinzenal.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Mmensal(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_mensal.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Msemestral(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_semestral.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        return objItensPagtoProd;
    }

    public ProdutosPagtoKitInterno pPESQUISAR_QUANT_PRODUTOS_INTERNOS_PERSONALIZADO_Manual(ProdutosPagtoKitInterno objItensPagtoProd) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit, "
                    + "ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd, "
                    + "ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd "
                    + "FROM ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "INNER JOIN ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO "
                    + "ON ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp=ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdRegistroComp "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdInternoCrc='" + jIdInternoKitBio1.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.Idkit='" + jID_Kit_anual.getText() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.IdProd='" + objItensPagtoProd.getIdProd() + "' "
                    + "AND ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO.QuantProd>'" + pZERO + "'");
            conecta.rs.first();
            pRegistroComp = conecta.rs.getInt("IdRegistroComp");
            pCodigoInterno = conecta.rs.getInt("IdInternoCrc");
            pCodigoProd = conecta.rs.getInt("IdProd");
            pQuantidade = conecta.rs.getInt("QuantProd");
        } catch (Exception e) {
        }
        return objItensPagtoProd;
    }

    public List<ProdutosPagtoKitInterno> pBUSCAR_DADOS_interno() throws Exception {
        conecta.abrirConexao();
        List<ProdutosPagtoKitInterno> objListaInternos = new ArrayList<ProdutosPagtoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PRONTUARIOSCRC.IdInternoCrc, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,PRONTUARIOSCRC.FotoInternoCrc, "
                    + "PRONTUARIOSCRC.ImagemFrente,DADOSPENAISINTERNOS.Regime, "
                    + "PAVILHAO.DescricaoPav,CELAS.EndCelaPav FROM PRONTUARIOSCRC "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN INTERNOS_PAVILHAO_KIT_LOTE "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=INTERNOS_PAVILHAO_KIT_LOTE.IdInternoCrc "
                    + "INNER JOIN COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE "
                    + "ON INTERNOS_PAVILHAO_KIT_LOTE.IdRegistroComp=COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.IdRegistroComp "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND PRONTUARIOSCRC.NomeInternoCrc='" + jComboBoxPesquisarInterno.getSelectedItem() + "' "
                    + "AND COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE.StatusComp='" + statusFinal + "'");
            while (conecta.rs.next()) {
                ProdutosPagtoKitInterno pListaInternos = new ProdutosPagtoKitInterno();
                pListaInternos.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pListaInternos.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pListaInternos.setRegime(conecta.rs.getString("Regime"));
                pListaInternos.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListaInternos.setEnderecoCela(conecta.rs.getString("EndCelaPav"));
                pListaInternos.setCaminhoFoto(conecta.rs.getString("FotoInternoCrc"));
                pListaInternos.setImagemFrente(conecta.rs.getBytes("ImagemFrente"));
                objListaInternos.add(pListaInternos);
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

}
