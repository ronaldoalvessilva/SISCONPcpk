/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.dao.ConectaBanco;
import br.com.sisconpcpk.dao.ConexaoBancoDadosBAR;
import br.com.sisconpcpk.dao.ConexaoBancoDadosITB;
import br.com.sisconpcpk.dao.ConexaoBancoDadosLF;
import br.com.sisconpcpk.dao.ConexaoBancoDadosSSA;
import br.com.sisconpcpk.dao.ConexaoBancoDadosVC;
import br.com.sisconpcpk.modelo.UsuariosCpk;
import br.com.sisconpcpk.util.Criptografia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleUsuarios {

    ConectaBanco conecta = new ConectaBanco();
    ConexaoBancoDadosLF conectaLF = new ConexaoBancoDadosLF();
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ConexaoBancoDadosITB conectaITB = new ConexaoBancoDadosITB();
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ConexaoBancoDadosBAR conectaBAR = new ConexaoBancoDadosBAR();
    //
    UsuariosCpk objUser = new UsuariosCpk();
    int codGrupo;

    public UsuariosCpk incluirUsuarios(UsuariosCpk objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public UsuariosCpk alterarUsuarios(UsuariosCpk objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public UsuariosCpk excluirUsuarios(UsuariosCpk objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    public UsuariosCpk trocarSenhaUsuario(UsuariosCpk objUser) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objUser;
    }

    //------------------------------------------ MANTER USUARIOS DO SISTEMA PARA OUTRAS UNIDADES ---------------------------------------
    
    //------------------------------------------    LAURO DE FREITAS ---------------------------------------------------------------
    public UsuariosCpk incluirUsuariosLF(UsuariosCpk objUser) {

        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados(LAURO DE FREITAS).\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }

    public UsuariosCpk alterarUsuariosLF(UsuariosCpk objUser) {

        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados(LAURO DE FREITAS).\n\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }

    public UsuariosCpk excluirUsuariosLF(UsuariosCpk objUser) {

        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados(LAURO DE FREITAS).\n\nERRO: " + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }

    public UsuariosCpk trocarSenhaUsuarioLF(UsuariosCpk objUser) {

        conectaLF.abrirConexao();
        try {
            PreparedStatement pst = conectaLF.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados(LAURO DE FREITAS).\nERRO:" + ex);
        }
        conectaLF.desconecta();
        return objUser;
    }
    //-------------------------------------------- VITÓRIA DA CONQUISTA -------------------------------------------------

    public UsuariosCpk incluirUsuariosVC(UsuariosCpk objUser) {

        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados(VITÓRIA DA CONQUISTA).\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    public UsuariosCpk alterarUsuariosVC(UsuariosCpk objUser) {

        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados(VITÓRIA DA CONQUISTA).\n\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    public UsuariosCpk excluirUsuariosVC(UsuariosCpk objUser) {

        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados(VITÓRIA DA CONQUISTA).\n\nERRO: " + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    public UsuariosCpk trocarSenhaUsuarioVC(UsuariosCpk objUser) {

        conectaVC.abrirConexao();
        try {
            PreparedStatement pst = conectaVC.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados(VITÓRIA DA CONQUISTA).\nERRO:" + ex);
        }
        conectaVC.desconecta();
        return objUser;
    }

    //----------------------------------------------------- ITABUNA --------------------------------------
    public UsuariosCpk incluirUsuariosITB(UsuariosCpk objUser) {

        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados(ITABUNA).\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    public UsuariosCpk alterarUsuariosITB(UsuariosCpk objUser) {

        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados(ITABUNA).\n\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    public UsuariosCpk excluirUsuariosITB(UsuariosCpk objUser) {

        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados(ITABUNA).\n\nERRO: " + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    public UsuariosCpk trocarSenhaUsuarioITB(UsuariosCpk objUser) {

        conectaITB.abrirConexao();
        try {
            PreparedStatement pst = conectaITB.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados(ITABUNA).\nERRO:" + ex);
        }
        conectaITB.desconecta();
        return objUser;
    }

    //------------------------------------------------- SALVADOR ----------------------------------------------------------------------------------
    public UsuariosCpk incluirUsuariosSSA(UsuariosCpk objUser) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados(SALVADOR).\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    public UsuariosCpk alterarUsuariosSSA(UsuariosCpk objUser) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados(SALVADOR).\n\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    public UsuariosCpk excluirUsuariosSSA(UsuariosCpk objUser) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados(SALVADOR).\n\nERRO: " + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    public UsuariosCpk trocarSenhaUsuarioSSA(UsuariosCpk objUser) {

        conectaSSA.abrirConexao();
        try {
            PreparedStatement pst = conectaSSA.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados(SALVADOR).\nERRO:" + ex);
        }
        conectaSSA.desconecta();
        return objUser;
    }

    //----------------------------------------------- BARREIRAS ------------------------------------------------------------------------
    public UsuariosCpk incluirUsuariosBAR(UsuariosCpk objUser) {

        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("INSERT INTO USUARIOS (StatusUsuario,DataCadastro,NomeUsuario,NomeDepartamento,NomeCargo,LoginUsuario,SenhaUsuario,ConfirmaSenhaUsuario,AcessoTodasUnidades,DataSenha)VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.execute(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados(BARREIRAS).\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }

    public UsuariosCpk alterarUsuariosBAR(UsuariosCpk objUser) {

        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("UPDATE USUARIOS SET StatusUsuario=?,DataCadastro=?,NomeUsuario=?,NomeDepartamento=?,NomeCargo=?,LoginUsuario=?,SenhaUsuario=?,ConfirmaSenhaUsuario=?,AcessoTodasUnidades=?,DataSenha=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setBoolean(1, objUser.getStatus());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objUser.getNomeUsuario());
            pst.setString(4, objUser.getNomeDepartamento());
            pst.setString(5, objUser.getNomeCargo());
            pst.setString(6, objUser.getLogin());
            pst.setString(7, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(8, Criptografia.criptografar(objUser.getSenha2()));
            pst.setString(9, objUser.getAcessoTodasUnidades());
            if (objUser.getDataCadastro() != null) {
                pst.setTimestamp(10, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            } else {
                pst.setDate(10, null);
            }
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados(BARREIRAS).\n\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }

    public UsuariosCpk excluirUsuariosBAR(UsuariosCpk objUser) {

        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("DELETE FROM USUARIOS WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados(BARREIRAS).\n\nERRO: " + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }

    public UsuariosCpk trocarSenhaUsuarioBAR(UsuariosCpk objUser) {

        conectaBAR.abrirConexao();
        try {
            PreparedStatement pst = conectaBAR.con.prepareStatement("UPDATE USUARIOS SET DataSenha=?,SenhaUsuario=?,ConfirmaSenhaUsuario=? WHERE IdUsuario='" + objUser.getIdUsuario() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objUser.getDataCadastro().getTime()));
            pst.setString(2, Criptografia.criptografar(objUser.getSenha1()));
            pst.setString(3, Criptografia.criptografar(objUser.getSenha2()));
            pst.executeUpdate(); // Executa a inserção
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados(BARREIRAS).\nERRO:" + ex);
        }
        conectaBAR.desconecta();
        return objUser;
    }
}
