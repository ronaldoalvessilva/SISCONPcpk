/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ConfereInternos;
import static br.com.sisconpcpk.visao.TelaImportacaoCelas.qtdInternos;
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
public class ControleImportacaoCelasDao {

    GravarInternos objGravaIntComp = new GravarInternos();
    ConfereInternos objConf = new ConfereInternos();
    ConectaBanco conecta = new ConectaBanco();

    public List<GravarInternos> read() throws Exception {
        conecta.abrirConexao();
        List<GravarInternos> listaInternosKitComp = new ArrayList<GravarInternos>();
        try {
            conecta.executaSQL("SELECT * FROM CELAS "
                    + "ORDER BY EndCelaPav");
            while (conecta.rs.next()) {
                GravarInternos pDigi = new GravarInternos();
                pDigi.setIdCela(conecta.rs.getInt("IdCela"));
                pDigi.setStatusCela(conecta.rs.getString("StatusCela"));
                pDigi.setIdPav(conecta.rs.getInt("IdPav"));
                pDigi.setNomeCela(conecta.rs.getString("EndCelaPav"));
                pDigi.setMotivo(conecta.rs.getString("Motivo"));
                pDigi.setNivelCel(conecta.rs.getString("NivelCel"));
                pDigi.setCapacidade(conecta.rs.getInt("Capacidade"));
                pDigi.setNrCela(conecta.rs.getInt("NrCela"));
                listaInternosKitComp.add(pDigi);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(ControleImportacaoCelasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
