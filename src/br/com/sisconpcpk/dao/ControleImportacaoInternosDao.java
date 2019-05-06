/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ConfereInternos;
import static br.com.sisconpcpk.visao.TelaImportacaoInternosConfere.qtdInternos;
import br.com.sisconpcpk.modelo.GravarInternos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class ControleImportacaoInternosDao {

    GravarInternos objGravaIntComp = new GravarInternos();
    ConfereInternos objConf = new ConfereInternos();
    ConectaBanco conecta = new ConectaBanco();
    //
    String situacaoEnt = "ENTRADA NA UNIDADE";
    String situacaoRet = "RETORNO A UNIDADE";

    public List<GravarInternos> read() throws Exception {
        conecta.abrirConexao();
        List<GravarInternos> listaInternosKitComp = new ArrayList<GravarInternos>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE SituacaoCrc='" + situacaoEnt + "' "
                    + "OR SituacaoCrc='" + situacaoRet + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            while (conecta.rs.next()) {
                GravarInternos pDigi = new GravarInternos();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setcNcinterno(conecta.rs.getString("Cnc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigi.setImagemFrente(conecta.rs.getBytes("ImagemFrente"));
                pDigi.setSituacaoCrc(conecta.rs.getString("SituacaoCrc"));
                pDigi.setIdPav(conecta.rs.getInt("IdPav"));
                pDigi.setNomePavilhao(conecta.rs.getString("DescricaoPav"));
                pDigi.setIdCela(conecta.rs.getInt("IdCela"));
                pDigi.setNomeCela(conecta.rs.getString("EndCelaPav"));
                listaInternosKitComp.add(pDigi);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(ControleImportacaoInternosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
