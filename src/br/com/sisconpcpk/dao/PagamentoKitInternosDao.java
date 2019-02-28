/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.DigitalInternos;
import br.com.sisconpcpk.modelo.ItensPagamentoKitInterno;
import static br.com.sisconpcpk.visao.TelaPagamentoKitInternoCPK.jComboBoxPavilhao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class PagamentoKitInternosDao {

    ConectaBanco conecta = new ConectaBanco();
    ItensPagamentoKitInterno objItensPagto = new ItensPagamentoKitInterno();

    int codInterno;
    String pBio = null;
    public static int qtdInternos = 0;

    public ItensPagamentoKitInterno incluirPagamentoKitInterno(ItensPagamentoKitInterno objItensPagto) {
        buscarInterno(objItensPagto.getNomeInternoCrcKit(), objItensPagto.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_PAGAMENTO_KIT_INTERNOS (IdPagto,IdInternoCrc,"
                    + "DataEntrega,Horario,AssinaturaDigital,UsuarioInsert,DataInsert,"
                    + "HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensPagto.getIdPagto());
            pst.setInt(2, codInterno);
            
            if (objItensPagto.getDataEntrega() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objItensPagto.getDataEntrega().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objItensPagto.getHoraEntrega());
            pst.setBytes(5, objItensPagto.getAssinaturaDigital());
            pst.setString(6, objItensPagto.getUsuarioInsert());
            pst.setString(7, objItensPagto.getDataInsert());
            pst.setString(8, objItensPagto.getHorarioInsert());           
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensPagto;
    }

    public ItensPagamentoKitInterno alterarPagamentoKitInterno(ItensPagamentoKitInterno objItensPagto) {
        buscarInterno(objItensPagto.getNomeInternoCrcKit(), objItensPagto.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PAGAMENTO_KIT_INTERNOS SET IdPagto=?,IdInternoCrc=?,"
                    + "DataEntrega=?,Horario=?,UsuarioUp=?,DataUp=?,HorarioUp=?,AssinaturaDigital=? WHERE IdItem='" + objItensPagto.getIdItem() + "'");
            pst.setInt(1, objItensPagto.getIdPagto());
            pst.setInt(2, codInterno);            
            if (objItensPagto.getDataEntrega() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objItensPagto.getDataEntrega().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objItensPagto.getHoraEntrega());
            pst.setBytes(5, objItensPagto.getAssinaturaDigital());
            pst.setString(6, objItensPagto.getUsuarioUp());
            pst.setString(7, objItensPagto.getDataUp());
            pst.setString(8, objItensPagto.getHorarioUp());     
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPagto;
    }

    public ItensPagamentoKitInterno excluirPagamentoKitInterno(ItensPagamentoKitInterno objItensPagto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PAGAMENTO_KIT_INTERNOS WHERE IdItem='" + objItensPagto.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensPagto;
    }

    public void buscarInterno(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public java.util.List<DigitalInternos> read() throws Exception {
        conecta.abrirConexao();
        java.util.List<DigitalInternos> listaInternos = new ArrayList<DigitalInternos>();
        try {
            conecta.executaSQL("SELECT * FROM  PRONTUARIOSCRC "
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
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhao.getSelectedItem() + "' "
                    + "AND BiometriaDedo1!='" + pBio + "'");
            while (conecta.rs.next()) {
                DigitalInternos pDigital = new DigitalInternos();
                pDigital.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigital.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
                pDigital.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigital.setCaminhoFotoInterno(conecta.rs.getString("FotoInternoCrc"));
                pDigital.setRegime(conecta.rs.getString("Regime"));
                pDigital.setPavilhao(conecta.rs.getString("DescricaoPav"));
                pDigital.setCela(conecta.rs.getString("EndCelaPav"));
                pDigital.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigital.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigital.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigital.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
                listaInternos.add(pDigital);
                qtdInternos++;
            }
            return listaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoKitInternosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
