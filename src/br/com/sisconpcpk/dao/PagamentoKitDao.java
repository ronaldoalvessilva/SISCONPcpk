/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ItensPagamentoKitInterno;
import br.com.sisconpcpk.modelo.PagamentoKitInterno;
import br.com.sisconpcpk.modelo.ProdutoInternosKitLote;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.codItem;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.dataFinal;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.dataInicial;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.idItemPagto;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jComboBoxPesquisarTipoKit;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jIDPesqLanc;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jIdInterno;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jIdLanc;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.codLanc;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.codigoInterno;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.codigoKit;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jPesqNomeInternoVisitado;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.pTOTAL_registros;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.pCONFIRMARCAO_resposta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class PagamentoKitDao {

    ConectaBanco conecta = new ConectaBanco();
    PagamentoKitInterno objPag = new PagamentoKitInterno();

    int codPav;

    public PagamentoKitInterno incluirPagamentoKit(PagamentoKitInterno objPag) {
        BUSCAR_pavilhao(objPag.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PAGAMENTO_KIT_INTERNOS (StatusLanc,DataLanc,Responsavel,HoraInicio,HoraTermino,IdKit,TipoKit,IdRegistro,IdPav,Observacao,UsuarioInsert,DataInsert,HorarioInsert,KitPersonalizado,Id_REG_inicial,Id_REG_decendial,Id_REG_quinzenal,Id_REG_mensal,Id_REG_semestral,Id_REG_anual,ID_BT_Kit_inicial,ID_BT_Kit_decendial,ID_BT_Kit_quinzenal,ID_BT_Kit_mensal,ID_BT_Kit_semestral,ID_BT_Kit_anual,Id_KIT_inicial,ID_KIT_decendial,ID_KIT_quinzenal,ID_KIT_mensal,ID_KIT_semestral,ID_KIT_anual) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objPag.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objPag.getDataLanc().getTime()));
            pst.setString(3, objPag.getResponsavel());
            pst.setString(4, objPag.getHoraInicio());
            pst.setString(5, objPag.getHoraTermino());
            pst.setInt(6, objPag.getIdKit());
            pst.setString(7, objPag.getTipoKit());
            pst.setInt(8, objPag.getIdRegistroComp());
            pst.setInt(9, codPav);
            pst.setString(10, objPag.getObservacao());
            pst.setString(11, objPag.getUsuarioInsert());
            pst.setString(12, objPag.getDataInsert());
            pst.setString(13, objPag.getHorarioInsert());
            pst.setString(14, objPag.getKitPersonalizado());
            pst.setInt(15, objPag.getiD_REG_inicial());
            pst.setInt(16, objPag.getiD_REG_decendial());
            pst.setInt(17, objPag.getiD_REG_quinzenal());
            pst.setInt(18, objPag.getiD_REG_mensal());
            pst.setInt(19, objPag.getiD_REG_semestral());
            pst.setInt(20, objPag.getiD_REG_anual());
            pst.setInt(21, objPag.getiD_BT_Kit_inicial());
            pst.setInt(22, objPag.getiD_BT_Kit_decendial());
            pst.setInt(23, objPag.getiD_BT_Kit_quinzenal());
            pst.setInt(24, objPag.getiD_BT_Kit_mensal());
            pst.setInt(25, objPag.getiD_BT_Kit_semestral());
            pst.setInt(26, objPag.getiD_BT_Kit_anual());
            pst.setInt(27, objPag.getiD_KIT_inicial());
            pst.setInt(28, objPag.getiD_KIT_decendial());
            pst.setInt(29, objPag.getiD_KIT_quinzenal());
            pst.setInt(30, objPag.getiD_KIT_mensal());
            pst.setInt(31, objPag.getiD_KIT_semestral());
            pst.setInt(32, objPag.getiD_KIT_anual());
            pst.execute();
            pCONFIRMARCAO_resposta = "Sim";
        } catch (SQLException ex) {
            pCONFIRMARCAO_resposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoKitInterno alterarPagamentoKit(PagamentoKitInterno objPag) {
        BUSCAR_pavilhao(objPag.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAGAMENTO_KIT_INTERNOS SET StatusLanc=?,DataLanc=?,Responsavel=?,HoraInicio=?,HoraTermino=?,IdKit=?,TipoKit=?,IdRegistro=?,IdPav=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=?,KitPersonalizado=?,Id_REG_inicial=?,Id_REG_decendial=?,Id_REG_quinzenal=?,Id_REG_mensal=?,Id_REG_semestral=?,Id_REG_anual=?,ID_BT_Kit_inicial=?,ID_BT_Kit_decendial=?,ID_BT_Kit_quinzenal=?,ID_BT_Kit_mensal=?,ID_BT_Kit_semestral=?,ID_BT_Kit_anual=?,ID_KIT_inicial=?,ID_KIT_decendial=?,ID_KIT_quinzenal=?,ID_KIT_mensal=?,ID_KIT_semestral=?,ID_KIT_anual=? WHERE IdPagto='" + objPag.getIdPagto() + "'");
            pst.setString(1, objPag.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objPag.getDataLanc().getTime()));
            pst.setString(3, objPag.getResponsavel());
            pst.setString(4, objPag.getHoraInicio());
            pst.setString(5, objPag.getHoraTermino());
            pst.setInt(6, objPag.getIdKit());
            pst.setString(7, objPag.getTipoKit());
            pst.setInt(8, objPag.getIdRegistroComp());
            pst.setInt(9, codPav);
            pst.setString(10, objPag.getObservacao());
            pst.setString(11, objPag.getUsuarioUp());
            pst.setString(12, objPag.getDataUp());
            pst.setString(13, objPag.getHorarioUp());
            pst.setString(14, objPag.getKitPersonalizado());
            pst.setInt(15, objPag.getiD_REG_inicial());
            pst.setInt(16, objPag.getiD_REG_decendial());
            pst.setInt(17, objPag.getiD_REG_quinzenal());
            pst.setInt(18, objPag.getiD_REG_mensal());
            pst.setInt(19, objPag.getiD_REG_semestral());
            pst.setInt(20, objPag.getiD_REG_anual());
            pst.setInt(21, objPag.getiD_BT_Kit_inicial());
            pst.setInt(22, objPag.getiD_BT_Kit_decendial());
            pst.setInt(23, objPag.getiD_BT_Kit_quinzenal());
            pst.setInt(24, objPag.getiD_BT_Kit_mensal());
            pst.setInt(25, objPag.getiD_BT_Kit_semestral());
            pst.setInt(26, objPag.getiD_BT_Kit_anual());
            pst.setInt(27, objPag.getiD_KIT_inicial());
            pst.setInt(28, objPag.getiD_KIT_decendial());
            pst.setInt(29, objPag.getiD_KIT_quinzenal());
            pst.setInt(30, objPag.getiD_KIT_mensal());
            pst.setInt(31, objPag.getiD_KIT_semestral());
            pst.setInt(32, objPag.getiD_KIT_anual());
            pst.executeUpdate();
            pCONFIRMARCAO_resposta = "Sim";
        } catch (SQLException ex) {
            pCONFIRMARCAO_resposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoKitInterno excluirPagamentoKit(PagamentoKitInterno objPag) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE PAGAMENTO_KIT_INTERNOS WHERE IdPagto='" + objPag.getIdPagto() + "'");
            pst.executeUpdate();
            pCONFIRMARCAO_resposta = "Sim";
        } catch (SQLException ex) {
            pCONFIRMARCAO_resposta = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoKitInterno finalizarPagamentoKit(PagamentoKitInterno objPag) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAGAMENTO_KIT_INTERNOS SET StatusLanc=? WHERE IdPagto='" + objPag.getIdPagto() + "'");
            pst.setString(1, objPag.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public void BUSCAR_pavilhao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdPav,DescricaoPav "
                    + "FROM PAVILHAO "
                    + "WHERE DescricaoPav='" + desc + "'");
            conecta.rs.first();
            codPav = conecta.rs.getInt("IdPav");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (PAVILHÃO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public PagamentoKitInterno pBUSCAR_CODIGO_manutencao(PagamentoKitInterno objPag) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdPagto "
                    + "FROM PAGAMENTO_KIT_INTERNOS");
            conecta.rs.last();
            jIdLanc.setText(conecta.rs.getString("IdPagto"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter o código do registro.");
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoKitInterno pBUSCAR_CODIGO_item(PagamentoKitInterno objPag) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdItem "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS");
            conecta.rs.last();
            codItem = conecta.rs.getInt("IdItem");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoKitInterno pVERIFICAR_item(PagamentoKitInterno objPag) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdPagto "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "WHERE IdPagto='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codLanc = conecta.rs.getString("IdPagto");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoKitInterno pVERIFICAR_interno(PagamentoKitInterno objPag) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT "
                    + "IdPagto,IdInternoCrc "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "WHERE IdInternoCrc='" + jIdInterno.getText() + "' "
                    + "AND IdPagto='" + jIdLanc.getText() + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getString("IdInternoCrc");
            codigoKit = conecta.rs.getString("IdPagto");
        } catch (Exception e) {
        }
        conecta.desconecta();
        return objPag;
    }

    //------------------------------------------- PESQUISAS -------------------------------------------------
    public List<PagamentoKitInterno> pBUSCAR_TODOS_registros() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<PagamentoKitInterno> objListaInternos = new ArrayList<PagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PAGAMENTO_KIT_INTERNOS.IdPagto,DataLanc, "
                    + "StatusLanc,TipoKit,DescricaoPav, "
                    + "NomeInternoCrc,Observacao "
                    + "FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PAVILHAO "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "ORDER BY PAGAMENTO_KIT_INTERNOS.IdPagto");
            while (conecta.rs.next()) {
                PagamentoKitInterno pListarTodosRegistrosKit = new PagamentoKitInterno();
                pListarTodosRegistrosKit.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListarTodosRegistrosKit.setDataLanc(conecta.rs.getDate("DataLanc"));
                pListarTodosRegistrosKit.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pListarTodosRegistrosKit.setTipoKit(conecta.rs.getString("TipoKit"));
                pListarTodosRegistrosKit.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListarTodosRegistrosKit.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pListarTodosRegistrosKit.setObservacao(conecta.rs.getString("Observacao"));
                objListaInternos.add(pListarTodosRegistrosKit);
                pTOTAL_registros++;
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<PagamentoKitInterno> pBUSCAR_TODOS_data() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<PagamentoKitInterno> objListaInternos = new ArrayList<PagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PAGAMENTO_KIT_INTERNOS.IdPagto,DataLanc, "
                    + "StatusLanc,TipoKit,DescricaoPav, "
                    + "Observacao, NomeInternoCrc "
                    + "FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PAVILHAO "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc  "
                    + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                    + "AND'" + dataFinal + "'");
            while (conecta.rs.next()) {
                PagamentoKitInterno pListarTodosRegistrosKit = new PagamentoKitInterno();
                pListarTodosRegistrosKit.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListarTodosRegistrosKit.setDataLanc(conecta.rs.getDate("DataLanc"));
                pListarTodosRegistrosKit.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pListarTodosRegistrosKit.setTipoKit(conecta.rs.getString("TipoKit"));
                pListarTodosRegistrosKit.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListarTodosRegistrosKit.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pListarTodosRegistrosKit.setObservacao(conecta.rs.getString("Observacao"));
                objListaInternos.add(pListarTodosRegistrosKit);
                pTOTAL_registros++;
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<PagamentoKitInterno> pBUSCAR_TODOS_data0() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<PagamentoKitInterno> objListaInternos = new ArrayList<PagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PAGAMENTO_KIT_INTERNOS.IdPagto,DataLanc, "
                    + "StatusLanc,TipoKit,DescricaoPav, "
                    + "Observacao,NomeInternoCrc "
                    + "FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PAVILHAO "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc  "
                    + "WHERE DataLanc BETWEEN'" + dataInicial + "' "
                    + "AND'" + dataFinal + "' "
                    + "AND TipoKit ='" + jComboBoxPesquisarTipoKit.getSelectedItem() + "'  ");
            while (conecta.rs.next()) {
                PagamentoKitInterno pListarTodosRegistrosKit = new PagamentoKitInterno();
                pListarTodosRegistrosKit.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListarTodosRegistrosKit.setDataLanc(conecta.rs.getDate("DataLanc"));
                pListarTodosRegistrosKit.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pListarTodosRegistrosKit.setTipoKit(conecta.rs.getString("TipoKit"));
                pListarTodosRegistrosKit.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListarTodosRegistrosKit.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pListarTodosRegistrosKit.setObservacao(conecta.rs.getString("Observacao"));
                objListaInternos.add(pListarTodosRegistrosKit);
                ++pTOTAL_registros;
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<PagamentoKitInterno> pBUSCAR_TODOS_codigo() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<PagamentoKitInterno> objListaInternos = new ArrayList<PagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PAGAMENTO_KIT_INTERNOS.IdPagto,DataLanc, "
                    + "StatusLanc,TipoKit,DescricaoPav, "
                    + "NomeInternoCrc "
                    + "FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PAVILHAO "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc  "
                    + "WHERE WHERE PAGAMENTO_KIT_INTERNOS.IdPagto='" + jIDPesqLanc.getText() + "'");
            while (conecta.rs.next()) {
                PagamentoKitInterno pListarTodosRegistrosKit = new PagamentoKitInterno();
                pListarTodosRegistrosKit.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListarTodosRegistrosKit.setDataLanc(conecta.rs.getDate("DataLanc"));
                pListarTodosRegistrosKit.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pListarTodosRegistrosKit.setTipoKit(conecta.rs.getString("TipoKit"));
                pListarTodosRegistrosKit.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListarTodosRegistrosKit.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pListarTodosRegistrosKit.setObservacao(conecta.rs.getString("Observacao"));
                objListaInternos.add(pListarTodosRegistrosKit);
                ++pTOTAL_registros;
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<PagamentoKitInterno> pBUSCAR_TODOS_codigoOBS() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<PagamentoKitInterno> objListaInternos = new ArrayList<PagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PAGAMENTO_KIT_INTERNOS.IdPagto,DataLanc, "
                    + "StatusLanc,TipoKit,DescricaoPav,Observacao "
                    + "FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PAVILHAO "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAGAMENTO_KIT_INTERNOS.IdPagto='" + jIDPesqLanc.getText() + "'");
            while (conecta.rs.next()) {
                PagamentoKitInterno pListarTodosRegistrosKit = new PagamentoKitInterno();
                pListarTodosRegistrosKit.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListarTodosRegistrosKit.setDataLanc(conecta.rs.getDate("DataLanc"));
                pListarTodosRegistrosKit.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pListarTodosRegistrosKit.setTipoKit(conecta.rs.getString("TipoKit"));
                pListarTodosRegistrosKit.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListarTodosRegistrosKit.setObservacao(conecta.rs.getString("Observacao"));
                objListaInternos.add(pListarTodosRegistrosKit);
                ++pTOTAL_registros;
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<PagamentoKitInterno> pBUSCAR_REGISTRO_NOME_interno() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<PagamentoKitInterno> objListaInternos = new ArrayList<PagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PAGAMENTO_KIT_INTERNOS.IdPagto,DataLanc, "
                    + "StatusLanc,TipoKit,DescricaoPav, "
                    + "Observacao,NomeInternoCrc "
                    + "FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PAVILHAO "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInternoVisitado.getText() + "%'");
            while (conecta.rs.next()) {
                PagamentoKitInterno pListarTodosRegistrosKit = new PagamentoKitInterno();
                pListarTodosRegistrosKit.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListarTodosRegistrosKit.setDataLanc(conecta.rs.getDate("DataLanc"));
                pListarTodosRegistrosKit.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pListarTodosRegistrosKit.setTipoKit(conecta.rs.getString("TipoKit"));
                pListarTodosRegistrosKit.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListarTodosRegistrosKit.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pListarTodosRegistrosKit.setObservacao(conecta.rs.getString("Observacao"));
                objListaInternos.add(pListarTodosRegistrosKit);
                ++pTOTAL_registros;
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<PagamentoKitInterno> pBUSCAR_REGISTRO_NOME_INTERNO_tipoKit() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<PagamentoKitInterno> objListaInternos = new ArrayList<PagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PAGAMENTO_KIT_INTERNOS.IdPagto,DataLanc, "
                    + "StatusLanc,TipoKit,DescricaoPav, "
                    + "Observacao,NomeInternoCrc "
                    + "FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PAVILHAO "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInternoVisitado.getText() + "%' "
                    + "AND TipoKit='" + jComboBoxPesquisarTipoKit.getSelectedItem() + "'");
            while (conecta.rs.next()) {
                PagamentoKitInterno pListarTodosRegistrosKit = new PagamentoKitInterno();
                pListarTodosRegistrosKit.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListarTodosRegistrosKit.setDataLanc(conecta.rs.getDate("DataLanc"));
                pListarTodosRegistrosKit.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pListarTodosRegistrosKit.setTipoKit(conecta.rs.getString("TipoKit"));
                pListarTodosRegistrosKit.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListarTodosRegistrosKit.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pListarTodosRegistrosKit.setObservacao(conecta.rs.getString("Observacao"));
                objListaInternos.add(pListarTodosRegistrosKit);
                ++pTOTAL_registros;
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<PagamentoKitInterno> pBUSCAR_REGISTRO_NOME_INTERNO_tipoKitData() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<PagamentoKitInterno> objListaInternos = new ArrayList<PagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PAGAMENTO_KIT_INTERNOS.IdPagto,DataLanc, "
                    + "StatusLanc,TipoKit,DescricaoPav, "
                    + "Observacao,NomeInternoCrc "
                    + "FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PAVILHAO "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PAGAMENTO_KIT_INTERNOS.DataLanc BETWEEN'" + dataInicial + "' "
                    + "AND'" + dataFinal + "' "
                    + "AND NomeInternoCrc LIKE'%" + jPesqNomeInternoVisitado.getText() + "%' "
                    + "AND PAGAMENTO_KIT_INTERNOS.TipoKit='" + jComboBoxPesquisarTipoKit.getSelectedItem() + "'");
            while (conecta.rs.next()) {
                PagamentoKitInterno pListarTodosRegistrosKit = new PagamentoKitInterno();
                pListarTodosRegistrosKit.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListarTodosRegistrosKit.setDataLanc(conecta.rs.getDate("DataLanc"));
                pListarTodosRegistrosKit.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pListarTodosRegistrosKit.setTipoKit(conecta.rs.getString("TipoKit"));
                pListarTodosRegistrosKit.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListarTodosRegistrosKit.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pListarTodosRegistrosKit.setObservacao(conecta.rs.getString("Observacao"));
                objListaInternos.add(pListarTodosRegistrosKit);
                ++pTOTAL_registros;
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<PagamentoKitInterno> pBUSCAR_REGISTRO_NOME_INTERNO_CODIGO_nome() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<PagamentoKitInterno> objListaInternos = new ArrayList<PagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PAGAMENTO_KIT_INTERNOS.IdPagto,DataLanc, "
                    + "StatusLanc,TipoKit,DescricaoPav, "
                    + "Observacao,NomeInternoCrc "
                    + "FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PAVILHAO "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPagto=ITENS_PAGAMENTO_KIT_INTERNOS.IdPagto "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE PAGAMENTO_KIT_INTERNOS.IdPagto='" + jIDPesqLanc.getText() + "'");
            while (conecta.rs.next()) {
                PagamentoKitInterno pListarTodosRegistrosKit = new PagamentoKitInterno();
                pListarTodosRegistrosKit.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListarTodosRegistrosKit.setDataLanc(conecta.rs.getDate("DataLanc"));
                pListarTodosRegistrosKit.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pListarTodosRegistrosKit.setTipoKit(conecta.rs.getString("TipoKit"));
                pListarTodosRegistrosKit.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListarTodosRegistrosKit.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pListarTodosRegistrosKit.setObservacao(conecta.rs.getString("Observacao"));
                objListaInternos.add(pListarTodosRegistrosKit);
                ++pTOTAL_registros;
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<PagamentoKitInterno> pBUSCAR_REGISTRO_MOUSE_clicked() throws Exception {
        conecta.abrirConexao();
        List<PagamentoKitInterno> objListaInternos = new ArrayList<PagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT * "
                    + "FROM PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PAVILHAO "
                    + "ON PAGAMENTO_KIT_INTERNOS.IdPav=PAVILHAO.IdPav "
                    + "WHERE IdPagto='" + jIDPesqLanc.getText() + "'");
            while (conecta.rs.next()) {
                PagamentoKitInterno pListarTodosRegistrosKit = new PagamentoKitInterno();
                pListarTodosRegistrosKit.setIdPagto(conecta.rs.getInt("IdPagto"));
                pListarTodosRegistrosKit.setDataLanc(conecta.rs.getDate("DataLanc"));
                pListarTodosRegistrosKit.setStatusLanc(conecta.rs.getString("StatusLanc"));
                pListarTodosRegistrosKit.setResponsavel(conecta.rs.getString("Responsavel"));
                pListarTodosRegistrosKit.setTipoKit(conecta.rs.getString("TipoKit"));
                pListarTodosRegistrosKit.setIdKit(conecta.rs.getInt("IdKit"));
                pListarTodosRegistrosKit.setIdRegistroComp(conecta.rs.getInt("IdRegistro"));
                pListarTodosRegistrosKit.setHoraInicio(conecta.rs.getString("HoraInicio"));
                pListarTodosRegistrosKit.setHoraTermino(conecta.rs.getString("HoraTermino"));
                pListarTodosRegistrosKit.setKitPersonalizado(conecta.rs.getString("KitPersonalizado"));
                pListarTodosRegistrosKit.setDescricaoPavilhao(conecta.rs.getString("DescricaoPav"));
                pListarTodosRegistrosKit.setiD_BT_Kit_inicial(conecta.rs.getInt("ID_BT_Kit_inicial"));
                pListarTodosRegistrosKit.setiD_BT_Kit_decendial(conecta.rs.getInt("ID_BT_Kit_decendial"));
                pListarTodosRegistrosKit.setiD_BT_Kit_quinzenal(conecta.rs.getInt("ID_BT_Kit_quinzenal"));
                pListarTodosRegistrosKit.setiD_BT_Kit_mensal(conecta.rs.getInt("ID_BT_Kit_mensal"));
                pListarTodosRegistrosKit.setiD_BT_Kit_semestral(conecta.rs.getInt("ID_BT_Kit_semestral"));
                pListarTodosRegistrosKit.setiD_BT_Kit_anual(conecta.rs.getInt("ID_BT_Kit_anual"));                 
                pListarTodosRegistrosKit.setiD_REG_inicial(conecta.rs.getInt("ID_REG_inicial")); 
                pListarTodosRegistrosKit.setiD_REG_decendial(conecta.rs.getInt("ID_REG_decendial"));
                pListarTodosRegistrosKit.setiD_REG_quinzenal(conecta.rs.getInt("ID_REG_quinzenal"));
                pListarTodosRegistrosKit.setiD_REG_mensal(conecta.rs.getInt("ID_REG_mensal"));
                pListarTodosRegistrosKit.setiD_REG_semestral(conecta.rs.getInt("ID_REG_semestral"));
                pListarTodosRegistrosKit.setiD_REG_anual(conecta.rs.getInt("ID_REG_anual"));                
                pListarTodosRegistrosKit.setiD_KIT_inicial(conecta.rs.getInt("ID_KIT_inicial"));
                pListarTodosRegistrosKit.setiD_KIT_decendial(conecta.rs.getInt("ID_KIT_decendial"));
                pListarTodosRegistrosKit.setiD_KIT_quinzenal(conecta.rs.getInt("ID_KIT_quinzenal"));
                pListarTodosRegistrosKit.setiD_KIT_mensal(conecta.rs.getInt("ID_KIT_mensal"));
                pListarTodosRegistrosKit.setiD_KIT_semestral(conecta.rs.getInt("ID_KIT_semestral"));
                pListarTodosRegistrosKit.setiD_KIT_anual(conecta.rs.getInt("ID_KIT_anual"));
                pListarTodosRegistrosKit.setObservacao(conecta.rs.getString("Observacao"));
                objListaInternos.add(pListarTodosRegistrosKit);
            }
            return objListaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ProdutoInternosKitLote> pPESQUISAR_PRODUTOS_KITS_PAGO_interno() throws Exception {
        conecta.abrirConexao();
        List<ProdutoInternosKitLote> objListaProdutosInternos = new ArrayList<ProdutoInternosKitLote>();
        try {
            conecta.executaSQL("SELECT "
                    + "DISTINCT PRODUTOS_AC.IdProd, "
                    + "PRODUTOS_AC.DescricaoProd,PRODUTOS_AC.UnidadeProd, "
                    + "ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.QuantProd "
                    + "FROM ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS "
                    + "INNER JOIN PRODUTOS_AC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdProd=PRODUTOS_AC.IdProd "
                    + "WHERE ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS.IdPagto='" + jIdLanc.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInterno.getText() + "'");
            while (conecta.rs.next()) {
                ProdutoInternosKitLote pListarProdutosKitInternos = new ProdutoInternosKitLote();
                pListarProdutosKitInternos.setIdProd(conecta.rs.getInt("IdProd"));
                pListarProdutosKitInternos.setDescricaoProduto(conecta.rs.getString("DescricaoProd"));
                pListarProdutosKitInternos.setUnidadeProd(conecta.rs.getString("UnidadeProd"));
                pListarProdutosKitInternos.setQuantidadeProd(conecta.rs.getInt("QuantProd"));
                objListaProdutosInternos.add(pListarProdutosKitInternos);
            }
            return objListaProdutosInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }

    public List<ItensPagamentoKitInterno> pPESQUISAR_PRODUTOS_KITS_internoCliced() throws Exception {
        conecta.abrirConexao();
        List<ItensPagamentoKitInterno> objListaProdutosInternos = new ArrayList<ItensPagamentoKitInterno>();
        try {
            conecta.executaSQL("SELECT * FROM ITENS_PAGAMENTO_KIT_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PAGAMENTO_KIT_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdItem='" + idItemPagto + "'");
            while (conecta.rs.next()) {
                ItensPagamentoKitInterno pListarProdutosKitInternos = new ItensPagamentoKitInterno();
                pListarProdutosKitInternos.setIdItem(conecta.rs.getInt("IdItem"));
                pListarProdutosKitInternos.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pListarProdutosKitInternos.setNomeInternoCrcKit(conecta.rs.getString("NomeInternoCrc"));
                pListarProdutosKitInternos.setCaminhoFoto(conecta.rs.getString("FotoInternoCrc"));
                pListarProdutosKitInternos.setImagemFoto(conecta.rs.getBytes("ImagemFrente"));
                pListarProdutosKitInternos.setDataEntrega(conecta.rs.getDate("DataEntrega"));
                pListarProdutosKitInternos.setHoraEntrega(conecta.rs.getString("Horario"));
                objListaProdutosInternos.add(pListarProdutosKitInternos);
            }
            return objListaProdutosInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleProdutosKitLote.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
