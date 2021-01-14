/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.controle;

import br.com.sisconpcpk.modelo.ControleVersao;
import br.com.sisconpcpk.dao.ConectaBanco;
import br.com.sisconpcpk.modelo.EmpresaUnidade;
import br.com.sisconpcpk.modelo.ParametrosCrc;
import br.com.sisconpcpk.modelo.UsuariosCpk;
import static br.com.sisconpcpk.visao.TelaLoginSenhaCPK.codigoEmpresa;
import static br.com.sisconpcpk.visao.TelaLoginSenhaCPK.jLogin;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo.silva7
 */
public class ControlePesquisarEmpresaLogon {

    ConectaBanco conecta = new ConectaBanco();
    EmpresaUnidade objEmpresa = new EmpresaUnidade();
    ParametrosCrc objParametros = new ParametrosCrc();
    ControleVersao versao = new ControleVersao();
    UsuariosCpk objUsuario = new UsuariosCpk();

    public ControleVersao alterarVersao(ControleVersao versao) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMPRESA SET VersaoAtual=?,DataVersao=? "
                    + "WHERE IdEmpresa='" + codigoEmpresa + "'");
            pst.setDouble(1, versao.getVersao());
            pst.setTimestamp(2, new java.sql.Timestamp(versao.getDataVersao().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return versao;
    }

    public EmpresaUnidade PESQUISAR_empresa(EmpresaUnidade objEmpresa) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMPRESA "
                    + "INNER JOIN UNIDADE_PENAL_EMPRESA "
                    + "ON EMPRESA.IdEmpresa=UNIDADE_PENAL_EMPRESA.IdEmpresa");
            conecta.rs.first();
            objEmpresa.setIdEmpresa(conecta.rs.getInt("IdEmpresa"));
            objEmpresa.setDescricaoEmpresa(conecta.rs.getString("RazaoSocial"));
            objEmpresa.setDescricaoUnidade(conecta.rs.getString("DescricaoUnidade"));
            objEmpresa.setVersaoAtual(conecta.rs.getDouble("VersaoAtual"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmpresa;
    }

    public EmpresaUnidade PESQUISAR_unidade(EmpresaUnidade objEmpresa) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE_PENAL_EMPRESA");
            conecta.rs.first();
            objEmpresa.setEndereco(conecta.rs.getString("Endereco"));
            objEmpresa.setCidade(conecta.rs.getString("Cidade"));
            objEmpresa.setEstado(conecta.rs.getString("Estado"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEmpresa;
    }

    public ParametrosCrc PESQUISAR_parametros(ParametrosCrc objParametros) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            objParametros.setCaminhoAtualizaSis(conecta.rs.getString("CaminhoExecutavel"));
            objParametros.setCaminhoExecAntigo(conecta.rs.getString("CaminhoExecutavelAntigo"));
            objParametros.setDataVersao(conecta.rs.getDate("DataVersao"));
            objParametros.setSistemaManutencao(conecta.rs.getString("SistemaManutencao"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objParametros;
    }

    public UsuariosCpk PESQUISAR_data(UsuariosCpk objUsuarios) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE LoginUsuario='" + jLogin.getText() + "'");
            conecta.rs.first();
            objUsuarios.setDataCadastro(conecta.rs.getDate("DataSenha"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível LOCALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objUsuarios;
    }
}