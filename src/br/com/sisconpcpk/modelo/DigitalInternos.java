/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.modelo;

/**
 *
 * @author ronaldo.silva7
 */
public class DigitalInternos {

    private int idInternoCrc;
    private String nomeInternoCrc;
    private String caminhoFotoInterno;
    private String matriculaPenal;
    private String Regime;
    private int idPav;
    private String pavilhao;
    private int idCela;
    private String cela;
    private byte[] biometriaDedo1;
    private byte[] biometriaDedo2;
    private byte[] biometriaDedo3;
    private byte[] biometriaDedo4;
    private String idItemSaida;
    private int idItemCrcPort;
    private String cnc;    
    private byte[] fotoByte;

    public DigitalInternos() {
    }

    public DigitalInternos(int idInternoCrc, String nomeInternoCrc, String caminhoFotoInterno, String matriculaPenal, String Regime, int idPav, String pavilhao, int idCela, String cela, byte[] biometriaDedo1, byte[] biometriaDedo2, byte[] biometriaDedo3, byte[] biometriaDedo4, String idItemSaida, int idItemCrcPort, String cnc, byte[] fotoByte) {
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.caminhoFotoInterno = caminhoFotoInterno;
        this.matriculaPenal = matriculaPenal;
        this.Regime = Regime;
        this.idPav = idPav;
        this.pavilhao = pavilhao;
        this.idCela = idCela;
        this.cela = cela;
        this.biometriaDedo1 = biometriaDedo1;
        this.biometriaDedo2 = biometriaDedo2;
        this.biometriaDedo3 = biometriaDedo3;
        this.biometriaDedo4 = biometriaDedo4;
        this.idItemSaida = idItemSaida;
        this.idItemCrcPort = idItemCrcPort;
        this.cnc = cnc;
        this.fotoByte = fotoByte;
    }

    /**
     * @return the idInternoCrc
     */
    public int getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(int idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the nomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return nomeInternoCrc;
    }

    /**
     * @param nomeInternoCrc the nomeInternoCrc to set
     */
    public void setNomeInternoCrc(String nomeInternoCrc) {
        this.nomeInternoCrc = nomeInternoCrc;
    }

    /**
     * @return the caminhoFotoInterno
     */
    public String getCaminhoFotoInterno() {
        return caminhoFotoInterno;
    }

    /**
     * @param caminhoFotoInterno the caminhoFotoInterno to set
     */
    public void setCaminhoFotoInterno(String caminhoFotoInterno) {
        this.caminhoFotoInterno = caminhoFotoInterno;
    }

    /**
     * @return the matriculaPenal
     */
    public String getMatriculaPenal() {
        return matriculaPenal;
    }

    /**
     * @param matriculaPenal the matriculaPenal to set
     */
    public void setMatriculaPenal(String matriculaPenal) {
        this.matriculaPenal = matriculaPenal;
    }

    /**
     * @return the Regime
     */
    public String getRegime() {
        return Regime;
    }

    /**
     * @param Regime the Regime to set
     */
    public void setRegime(String Regime) {
        this.Regime = Regime;
    }

    /**
     * @return the idPav
     */
    public int getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(int idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the pavilhao
     */
    public String getPavilhao() {
        return pavilhao;
    }

    /**
     * @param pavilhao the pavilhao to set
     */
    public void setPavilhao(String pavilhao) {
        this.pavilhao = pavilhao;
    }

    /**
     * @return the idCela
     */
    public int getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(int idCela) {
        this.idCela = idCela;
    }

    /**
     * @return the cela
     */
    public String getCela() {
        return cela;
    }

    /**
     * @param cela the cela to set
     */
    public void setCela(String cela) {
        this.cela = cela;
    }

    /**
     * @return the biometriaDedo1
     */
    public byte[] getBiometriaDedo1() {
        return biometriaDedo1;
    }

    /**
     * @param biometriaDedo1 the biometriaDedo1 to set
     */
    public void setBiometriaDedo1(byte[] biometriaDedo1) {
        this.biometriaDedo1 = biometriaDedo1;
    }

    /**
     * @return the biometriaDedo2
     */
    public byte[] getBiometriaDedo2() {
        return biometriaDedo2;
    }

    /**
     * @param biometriaDedo2 the biometriaDedo2 to set
     */
    public void setBiometriaDedo2(byte[] biometriaDedo2) {
        this.biometriaDedo2 = biometriaDedo2;
    }

    /**
     * @return the biometriaDedo3
     */
    public byte[] getBiometriaDedo3() {
        return biometriaDedo3;
    }

    /**
     * @param biometriaDedo3 the biometriaDedo3 to set
     */
    public void setBiometriaDedo3(byte[] biometriaDedo3) {
        this.biometriaDedo3 = biometriaDedo3;
    }

    /**
     * @return the biometriaDedo4
     */
    public byte[] getBiometriaDedo4() {
        return biometriaDedo4;
    }

    /**
     * @param biometriaDedo4 the biometriaDedo4 to set
     */
    public void setBiometriaDedo4(byte[] biometriaDedo4) {
        this.biometriaDedo4 = biometriaDedo4;
    }

    /**
     * @return the idItemSaida
     */
    public String getIdItemSaida() {
        return idItemSaida;
    }

    /**
     * @param idItemSaida the idItemSaida to set
     */
    public void setIdItemSaida(String idItemSaida) {
        this.idItemSaida = idItemSaida;
    }

    /**
     * @return the idItemCrcPort
     */
    public int getIdItemCrcPort() {
        return idItemCrcPort;
    }

    /**
     * @param idItemCrcPort the idItemCrcPort to set
     */
    public void setIdItemCrcPort(int idItemCrcPort) {
        this.idItemCrcPort = idItemCrcPort;
    }

    /**
     * @return the cnc
     */
    public String getCnc() {
        return cnc;
    }

    /**
     * @param cnc the cnc to set
     */
    public void setCnc(String cnc) {
        this.cnc = cnc;
    }

    /**
     * @return the fotoByte
     */
    public byte[] getFotoByte() {
        return fotoByte;
    }

    /**
     * @param fotoByte the fotoByte to set
     */
    public void setFotoByte(byte[] fotoByte) {
        this.fotoByte = fotoByte;
    }
}
