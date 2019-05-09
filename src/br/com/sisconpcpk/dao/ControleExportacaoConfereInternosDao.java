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
public class ControleExportacaoConfereInternosDao {

    GravarInternos objGravaIntComp = new GravarInternos();
    ConfereInternos objConf = new ConfereInternos();
    ConexaoBancoLocal conectaLocal = new ConexaoBancoLocal();
    //  

    public List<GravarInternos> read() throws Exception {
        conectaLocal.abrirConexao();
        List<GravarInternos> listaInternosKitComp = new ArrayList<GravarInternos>();
        try {
            conectaLocal.executaSQL("SELECT * FROM CONFERE_INTERNOS "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON CONFERE_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            while (conectaLocal.rs.next()) {
                GravarInternos pDigi = new GravarInternos();
                pDigi.setIdInternoCrc(conectaLocal.rs.getInt("IdInternoCrc"));
                pDigi.setNomeInternoCrc(conectaLocal.rs.getString("NomeInternoCrc"));
                pDigi.setDataConfere(conectaLocal.rs.getDate("DataConfere"));
                pDigi.setDataRealizacao(conectaLocal.rs.getString("DataRealizacao"));
                pDigi.setHorarioConfere(conectaLocal.rs.getString("HorarioConfere"));
                pDigi.setIdPav(conectaLocal.rs.getInt("IdPav"));
                pDigi.setNomePavilhao(conectaLocal.rs.getString("DescricaoPav"));
                pDigi.setIdCela(conectaLocal.rs.getInt("IdCela"));
                pDigi.setNomeCela(conectaLocal.rs.getString("EndCelaPav"));
                pDigi.setUsuarioInsert(conectaLocal.rs.getString("UsuarioInsert"));
                pDigi.setDataInsert(conectaLocal.rs.getString("DataInsert"));
                pDigi.setHoraInsert(conectaLocal.rs.getString("HorarioInsert"));
                pDigi.setUsuarioUp(conectaLocal.rs.getString("UsuarioUp"));                
                pDigi.setDataUp(conectaLocal.rs.getString("DataUp"));                
                pDigi.setHoraUp(conectaLocal.rs.getString("HorarioUp"));
                pDigi.setAssinaturaBiometricaInterno(conectaLocal.rs.getBytes("AssinaturaBiometricaInterno"));
                listaInternosKitComp.add(pDigi);
                qtdInternos = qtdInternos + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(ControleExportacaoConfereInternosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectaLocal.desconecta();
        }
        return null;
    }
}
