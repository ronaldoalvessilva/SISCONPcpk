/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.PagamentoRefeicao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class PagamentoRefeicaoInternoDao {

    ConectaBanco conecta = new ConectaBanco();
    PagamentoRefeicao objPagtoRef = new PagamentoRefeicao();

    int codPav;

    public PagamentoRefeicao incluirPagamentoKit(PagamentoRefeicao objPag) {
        buscarPavilhao(objPag.getDescricaoPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PAGAMENTO_REFEICAO (StatusRef,DataLanc,Responsavel,HoraInicio,HoraTermino,TipoRefeicao,IdPav,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objPag.getStatusRef());
            pst.setTimestamp(2, new java.sql.Timestamp(objPag.getDataLanc().getTime()));
            pst.setString(3, objPag.getResponsavel());
            pst.setString(4, objPag.getHorarioInicial());
            pst.setString(5, objPag.getHoraTermino());
            pst.setString(6, objPag.getTipoRefeicao());
            pst.setInt(7, codPav);
            pst.setString(8, objPag.getObservacao());
            pst.setString(9, objPag.getUsuarioInsert());
            pst.setString(10, objPag.getDataInsert());
            pst.setString(11, objPag.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoRefeicao alterarPagamentoKit(PagamentoRefeicao objPag) {
        buscarPavilhao(objPag.getDescricaoPav());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAGAMENTO_REFEICAO SET StatusRef=?,DataLanc=?,Responsavel=?,HoraInicio=?,HoraTermino=?,TipoRefeicao=?,IdPav=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRef='" + objPag.getIdRef() + "'");
            pst.setString(1, objPag.getStatusRef());
            pst.setTimestamp(2, new java.sql.Timestamp(objPag.getDataLanc().getTime()));
            pst.setString(3, objPag.getResponsavel());
            pst.setString(4, objPag.getHorarioInicial());
            pst.setString(5, objPag.getHoraTermino());
            pst.setString(6, objPag.getTipoRefeicao());
            pst.setInt(7, codPav);
            pst.setString(8, objPag.getObservacao());
            pst.setString(9, objPag.getUsuarioInsert());
            pst.setString(10, objPag.getDataInsert());
            pst.setString(11, objPag.getHorarioInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoRefeicao excluirPagamentoKit(PagamentoRefeicao objPag) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE PAGAMENTO_REFEICAO WHERE IdRef='" + objPag.getIdRef()+ "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public PagamentoRefeicao finalizarPagamentoKit(PagamentoRefeicao objPag) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAGAMENTO_REFEICAO SET StatusRef=? WHERE IdRef='" + objPag.getIdRef()+ "'");
            pst.setString(1, objPag.getStatusRef());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objPag;
    }

    public void buscarPavilhao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + desc + "'");
            conecta.rs.first();
            codPav = conecta.rs.getInt("IdPav");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (PAVILHÃO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
