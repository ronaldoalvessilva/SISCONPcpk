/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.dao;

import br.com.sisconpcpk.modelo.ConfereInternos;
import br.com.sisconpcpk.modelo.DigitalInternos;
import static br.com.sisconpcpk.visao.TelaConfereInternos.codigoCela;
import static br.com.sisconpcpk.visao.TelaConfereInternos.jRBtOFFline;
import static br.com.sisconpcpk.visao.TelaConfereInternos.jRBtONLine;
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
public class ConfereDao {

    ConectaBanco conecta = new ConectaBanco();
    ConexaoBancoLocal conectaLocal = new ConexaoBancoLocal();
    ConfereInternos objCI = new ConfereInternos();
    String pBio = null;
    public static int qtdInternos = 0;
    int codInterno;
    int codigoPav;
    int codigoCelaDao;

    public ConfereInternos incluirConfereInternos(ConfereInternos objCI) {
        if (jRBtOFFline.isSelected() == true) {
            buscarInterno(objCI.getNomeInternoCrc(), objCI.getIdInternoCrc());
            buscarPavilhao(objCI.getIdPav(), objCI.getNomePavilhao());
            buscarCela(objCI.getIdCela(), objCI.getNomeCela());
            conectaLocal.abrirConexao();
            try {
                PreparedStatement pst = conectaLocal.con.prepareStatement("INSERT INTO CONFERE_INTERNOS (IdInternoCrc,DataConfere,HorarioConfere,AssinaturaBiometricaInterno,IdPav,IdCela,UsuarioInsert,DataInsert,HorarioInsert,DataRealizacao) VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, codInterno);
                if (objCI.getDataConfere() != null) {
                    pst.setTimestamp(2, new java.sql.Timestamp(objCI.getDataConfere().getTime()));
                } else {
                    pst.setDate(2, null);
                }
                pst.setString(3, objCI.getHorarioConfere());
                pst.setBytes(4, objCI.getAssinaturaBiometricaInterno());
                pst.setInt(5, codigoPav);
                pst.setInt(6, codigoCelaDao);
                pst.setString(7, objCI.getUsuarioInsert());
                pst.setString(8, objCI.getDataInsert());
                pst.setString(9, objCI.getHorarioInsert());
                pst.setString(10, objCI.getDataRealizacao());
                pst.execute();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
            }
            conectaLocal.desconecta();
        } else if (jRBtONLine.isSelected() == true) {
            buscarInterno(objCI.getNomeInternoCrc(), objCI.getIdInternoCrc());
            buscarPavilhao(objCI.getIdPav(), objCI.getNomePavilhao());
            buscarCela(objCI.getIdCela(), objCI.getNomeCela());
            conecta.abrirConexao();
            try {
                PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CONFERE_INTERNOS (IdInternoCrc,DataConfere,HorarioConfere,AssinaturaBiometricaInterno,IdPav,IdCela,UsuarioInsert,DataInsert,HorarioInsert,DataRealizacao) VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, codInterno);
                if (objCI.getDataConfere() != null) {
                    pst.setTimestamp(2, new java.sql.Timestamp(objCI.getDataConfere().getTime()));
                } else {
                    pst.setDate(2, null);
                }
                pst.setString(3, objCI.getHorarioConfere());
                pst.setBytes(4, objCI.getAssinaturaBiometricaInterno());
                pst.setInt(5, codigoPav);
                pst.setInt(6, codigoCelaDao);
                pst.setString(7, objCI.getUsuarioInsert());
                pst.setString(8, objCI.getDataInsert());
                pst.setString(9, objCI.getHorarioInsert());
                pst.setString(10, objCI.getDataRealizacao());
                pst.execute();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
            }
            conecta.desconecta();
        }
        return objCI;
    }

    public void buscarInterno(String desc, int cod) {
        if (jRBtOFFline.isSelected() == true) {
            conectaLocal.abrirConexao();
            try {
                conectaLocal.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "WHERE NomeInternoCrc='" + desc + "' "
                        + "AND IdInternoCrc='" + cod + "'");
                conectaLocal.rs.first();
                codInterno = conectaLocal.rs.getInt("IdInternoCrc");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
            }
            conectaLocal.desconecta();
        } else if (jRBtONLine.isSelected() == true) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "WHERE NomeInternoCrc='" + desc + "' "
                        + "AND IdInternoCrc='" + cod + "'");
                conecta.rs.first();
                codInterno = conecta.rs.getInt("IdInternoCrc");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não existe dados (INTERNO) a ser exibido !!!" + e);
            }
            conecta.desconecta();
        }
    }

    public void buscarPavilhao(int codigo, String descricao) {
        if (jRBtOFFline.isSelected() == true) {
            conectaLocal.abrirConexao();
            try {
                conectaLocal.executaSQL("SELECT * FROM PAVILHAO "
                        + "WHERE DescricaoPav='" + descricao + "' "
                        + "AND IdPav='" + codigo + "'");
                conectaLocal.rs.first();
                codigoPav = conectaLocal.rs.getInt("IdPav");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não existe dados (PAVILHÃO) a ser exibido !!!" + e);
            }
            conectaLocal.desconecta();
        } else if (jRBtONLine.isSelected() == true) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PAVILHAO "
                        + "WHERE DescricaoPav='" + descricao + "' "
                        + "AND IdPav='" + codigo + "'");
                conecta.rs.first();
                codigoPav = conecta.rs.getInt("IdPav");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não existe dados (PAVILHÃO) a ser exibido !!!" + e);
            }
            conecta.desconecta();
        }
    }

    public void buscarCela(int idCela, String nome) {
        if (jRBtOFFline.isSelected() == true) {
            conectaLocal.abrirConexao();
            try {
                conectaLocal.executaSQL("SELECT * FROM CELAS WHERE EndCelaPav='" + nome + "' "
                        + "AND IdCela='" + idCela + "'");
                conectaLocal.rs.first();
                codigoCelaDao = conectaLocal.rs.getInt("IdCela");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não existe dados (CELAS) a ser exibido !!!" + e);
            }
            conectaLocal.desconecta();
        } else if (jRBtONLine.isSelected() == true) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM CELAS WHERE EndCelaPav='" + nome + "' "
                        + "AND IdCela='" + idCela + "'");
                conecta.rs.first();
                codigoCelaDao = conecta.rs.getInt("IdCela");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não existe dados (CELAS) a ser exibido !!!" + e);
            }
            conecta.desconecta();
        }
    }

    public java.util.List<DigitalInternos> read() throws Exception {
        if (jRBtOFFline.isSelected() == true) {
            conectaLocal.abrirConexao();
            java.util.List<DigitalInternos> listaInternos = new ArrayList<DigitalInternos>();
            try {
                conectaLocal.executaSQL("SELECT * FROM  PRONTUARIOSCRC "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS "
                        + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO "
                        + "ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE CELAS.NrCela='" + codigoCela + "' "
                        + "AND PRONTUARIOSCRC.BiometriaDedo1!='" + pBio + "'");
                while (conectaLocal.rs.next()) {
                    DigitalInternos pDigital = new DigitalInternos();
                    pDigital.setIdInternoCrc(conectaLocal.rs.getInt("IdInternoCrc"));
                    pDigital.setNomeInternoCrc(conectaLocal.rs.getString("NomeInternoCrc"));
                    pDigital.setFotoByte(conectaLocal.rs.getBytes("ImagemFrente"));
                    pDigital.setCaminhoFotoInterno(conectaLocal.rs.getString("FotoInternoCrc"));
                    pDigital.setRegime(conectaLocal.rs.getString("Regime"));
                    pDigital.setCnc(conectaLocal.rs.getString("Cnc"));
                    pDigital.setIdPav(conectaLocal.rs.getInt("IdPav"));
                    pDigital.setPavilhao(conectaLocal.rs.getString("DescricaoPav"));
                    pDigital.setIdCela(conectaLocal.rs.getInt("IdCela"));
                    pDigital.setCela(conectaLocal.rs.getString("EndCelaPav"));
                    pDigital.setBiometriaDedo1(conectaLocal.rs.getBytes("BiometriaDedo1"));
                    pDigital.setBiometriaDedo2(conectaLocal.rs.getBytes("BiometriaDedo2"));
                    pDigital.setBiometriaDedo3(conectaLocal.rs.getBytes("BiometriaDedo3"));
                    pDigital.setBiometriaDedo4(conectaLocal.rs.getBytes("BiometriaDedo4"));
                    listaInternos.add(pDigital);
                    qtdInternos++;
                }
                return listaInternos;
            } catch (SQLException ex) {
                Logger.getLogger(PagamentoKitInternosDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conectaLocal.desconecta();
            }
        } else if (jRBtONLine.isSelected() == true) {
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
                        + "WHERE CELAS.NrCela='" + codigoCela + "' "
                        + "AND BIOMETRIA_INTERNOS.BiometriaDedo1!='" + pBio + "'");
                while (conecta.rs.next()) {
                    DigitalInternos pDigital = new DigitalInternos();
                    pDigital.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                    pDigital.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
                    pDigital.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                    pDigital.setCaminhoFotoInterno(conecta.rs.getString("FotoInternoCrc"));
                    pDigital.setRegime(conecta.rs.getString("Regime"));
                    pDigital.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
                    pDigital.setCnc(conecta.rs.getString("Cnc"));
                    pDigital.setIdPav(conecta.rs.getInt("IdPav"));
                    pDigital.setPavilhao(conecta.rs.getString("DescricaoPav"));
                    pDigital.setIdCela(conecta.rs.getInt("IdCela"));
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
        }
        return null;
    }
}
