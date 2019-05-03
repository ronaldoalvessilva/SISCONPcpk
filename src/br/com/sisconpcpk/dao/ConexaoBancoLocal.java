/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ConexaoBancoLocal {

    public Statement stmt; // Responsavael para preparar e realizar pesquisas no banco de dados
    public ResultSet rs; // Responsavel por armazenar o resultado de uma pesquisa passado para o Statement         
    Properties prop = getProp();// Metodo que esta no final dessa classe
    String urlBanco = prop.getProperty("URL");// URL é o nome da proprienade no arquivo
    private final String url = urlBanco;
    private final String driver = "net.sourceforge.jtds.jdbc.Driver";
    private final String user = "sa"; // usuario do banco de dados     
    private final String password = "W@e3R4#14"; // Senha do banco de dados
    public Connection con; // Responsavel por conectar no banco de dados

    public void abrirConexao() { // Metodo resposavel por realizar conexão com o banco de dados

        try { // Bloco lógico de tratamento de erros
            System.setProperty("jdbc.Driveres", driver); // Seta propriedade do drive de conexão
            con = DriverManager.getConnection(url, user, password); //Realiza a conexão com o banco de dados                        
        } catch (SQLException ex) { // Excessão de erro na variável (ex)
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar com o banco de dados...\n  " + ex.getMessage());
        }
    }

    public void executaSQL(String SQL) {
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do executaSQL\n\n\n" + ex.getMessage());
        }
    }

    public void desconecta() { // Metódo para desconectar com o banco de dados

        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Desconectar conexão com o Banco de Dados" + e.getMessage());
        }
    }

    public static Properties getProp() {

        FileInputStream file = null;
        Properties props = null;
        try {
            props = new Properties();
            file = new FileInputStream("C:\\SISCONPcpk\\ConectaLocal.properties");////ALTERE AQUI DE ACORDO COM SUA NECESSIDADE
            props.load(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConexaoBancoLocal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConexaoBancoLocal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(ConexaoBancoLocal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return props;
    }
}
