/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ConfereInternos;
import static br.com.sisconpcpk.visao.TelaImportacaoLocalizacao.qtdInternos;
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
public class ControleImportacaoLocalcaoDao {

    GravarInternos objGravaIntComp = new GravarInternos();
    ConfereInternos objConf = new ConfereInternos();
    ConectaBanco conecta = new ConectaBanco();

    public List<GravarInternos> read() throws Exception {
        conecta.abrirConexao();
        List<GravarInternos> listaInternosKitComp = new ArrayList<GravarInternos>();
        try {
            conecta.executaSQL("SELECT * FROM ITENSLOCACAOINTERNO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSLOCACAOINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela ");
            while (conecta.rs.next()) {
                GravarInternos pDigi = new GravarInternos();
                pDigi.setIdItem(conecta.rs.getInt("IdItem"));
                pDigi.setIdLoca(conecta.rs.getInt("IdLoca"));
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigi.setIdCela(conecta.rs.getInt("IdCela"));    
                pDigi.setNomeCela(conecta.rs.getString("EndCelaPav"));
                listaInternosKitComp.add(pDigi);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(ControleImportacaoLocalcaoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
