/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.UsuariosCpk;
import br.com.sisconpcpk.util.Criptografia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class UsuariosDao {

    ConectaBanco conecta = new ConectaBanco();
    UsuariosCpk objUserCPK = new UsuariosCpk();
   

    public UsuariosCpk incluirUsuariosCpk(UsuariosCpk objUserCPK) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario)VALUES(?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUserCPK.getStatus());
            if (objUserCPK.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUserCPK.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUserCPK.getNomeUsuario());
            pst.setString(4, objUserCPK.getNomeDepartamento());
            pst.setString(5, objUserCPK.getNomeCargo());
            pst.setString(6, objUserCPK.getLogin());
            pst.setString(7, Criptografia.criptografar(objUserCPK.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUserCPK.getSenha2()));
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUserCPK;
    }

    public UsuariosCpk alterarUsuariosCpk(UsuariosCpk objUserCPK) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUserCPK.getIdUsuario() + "'");
            pst.setBoolean(1, objUserCPK.getStatus());
            if (objUserCPK.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUserCPK.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUserCPK.getNomeUsuario());
            pst.setString(4, objUserCPK.getNomeDepartamento());
            pst.setString(5, objUserCPK.getNomeCargo());
            pst.setString(6, objUserCPK.getLogin());
            pst.setString(7, Criptografia.criptografar(objUserCPK.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUserCPK.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objUserCPK;
    }

    public UsuariosCpk excluirUsuariosCpk(UsuariosCpk objUserCPK) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUserCPK.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objUserCPK;
    }

    public UsuariosCpk trocarSenhaUsuarioCpk(UsuariosCpk objUserCPK) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS SET SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUserCPK.getIdUsuario() + "'");
            pst.setString(1, Criptografia.criptografar(objUserCPK.getSenha1()));
            pst.setString(2, Criptografia.criptografar(objUserCPK.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objUserCPK;
    }
}
