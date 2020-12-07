/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.dao.ConectaBanco;
import br.com.sisconpcpk.modelo.UsuariosCpk;
import static br.com.sisconpcpk.visao.TelaLoginSenhaCPK.Codstatus;
import static br.com.sisconpcpk.visao.TelaLoginSenhaCPK.jLogin;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleVerificacaoAcessos {

    ConectaBanco conecta = new ConectaBanco();
    UsuariosCpk objUsusarios = new UsuariosCpk();

    public List<UsuariosCpk> read() throws Exception {

        conecta.abrirConexao();
        List<UsuariosCpk> listarUsuarios = new ArrayList<UsuariosCpk>();
        try {
            conecta.executaSQL("SELECT IdUsuario,LoginUsuario, "
                    + "SenhaUsuario,StatusUsuario,NomeUsuario "
                    + "FROM USUARIOS  "
                    + "WHERE LoginUsuario='" + jLogin.getText() + "'");
            while (conecta.rs.next()) {
                UsuariosCpk pUser = new UsuariosCpk();
                Codstatus = conecta.rs.getInt("StatusUsuario");
                pUser.setIdUsuario(conecta.rs.getInt("IdUsuario"));
                pUser.setLogin(conecta.rs.getString("LoginUsuario"));
                pUser.setNomeUsuario(conecta.rs.getString("NomeUsuario"));
                pUser.setSenha1(conecta.rs.getString("SenhaUsuario"));                
                listarUsuarios.add(pUser);
            }
            return listarUsuarios;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVerificacaoAcessos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
