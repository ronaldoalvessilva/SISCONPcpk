/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.modelo;

import java.util.Date;

/**
 *
 * @author ronaldo.silva7
 */
public class ConfereInternos {

    private Integer idConfere;
    private String cNc;
    private Integer idInternoCrc;
    private String nomeInternoCrc;
    private byte[] imagemFrente;
    private String regime;
    private String situacao;
    private Date dataConfere;
    private String horarioConfere;
    private byte[] assinaturaBiometricaInterno;
    private Integer idPav;
    private String statusPav;
    private String nomePavilhao;
    private String motivo;
    private String nivel;
    private Integer idCela;
    private String nomeCela;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;     
    private String dataRealizacao;   
    private int qtdLanc;    

    public ConfereInternos() {
    }

    public ConfereInternos(Integer idConfere, String cNc, Integer idInternoCrc, String nomeInternoCrc, byte[] imagemFrente, String regime, String situacao, Date dataConfere, String horarioConfere, byte[] assinaturaBiometricaInterno, Integer idPav, String statusPav, String nomePavilhao, String motivo, String nivel, Integer idCela, String nomeCela, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String dataRealizacao, int qtdLanc) {
        this.idConfere = idConfere;
        this.cNc = cNc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.imagemFrente = imagemFrente;
        this.regime = regime;
        this.situacao = situacao;
        this.dataConfere = dataConfere;
        this.horarioConfere = horarioConfere;
        this.assinaturaBiometricaInterno = assinaturaBiometricaInterno;
        this.idPav = idPav;
        this.statusPav = statusPav;
        this.nomePavilhao = nomePavilhao;
        this.motivo = motivo;
        this.nivel = nivel;
        this.idCela = idCela;
        this.nomeCela = nomeCela;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.dataRealizacao = dataRealizacao;
        this.qtdLanc = qtdLanc;
    }

    /**
     * @return the idConfere
     */
    public Integer getIdConfere() {
        return idConfere;
    }

    /**
     * @param idConfere the idConfere to set
     */
    public void setIdConfere(Integer idConfere) {
        this.idConfere = idConfere;
    }

    /**
     * @return the cNc
     */
    public String getcNc() {
        return cNc;
    }

    /**
     * @param cNc the cNc to set
     */
    public void setcNc(String cNc) {
        this.cNc = cNc;
    }

    /**
     * @return the idInternoCrc
     */
    public Integer getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(Integer idInternoCrc) {
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
     * @return the imagemFrente
     */
    public byte[] getImagemFrente() {
        return imagemFrente;
    }

    /**
     * @param imagemFrente the imagemFrente to set
     */
    public void setImagemFrente(byte[] imagemFrente) {
        this.imagemFrente = imagemFrente;
    }

    /**
     * @return the regime
     */
    public String getRegime() {
        return regime;
    }

    /**
     * @param regime the regime to set
     */
    public void setRegime(String regime) {
        this.regime = regime;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the dataConfere
     */
    public Date getDataConfere() {
        return dataConfere;
    }

    /**
     * @param dataConfere the dataConfere to set
     */
    public void setDataConfere(Date dataConfere) {
        this.dataConfere = dataConfere;
    }

    /**
     * @return the horarioConfere
     */
    public String getHorarioConfere() {
        return horarioConfere;
    }

    /**
     * @param horarioConfere the horarioConfere to set
     */
    public void setHorarioConfere(String horarioConfere) {
        this.horarioConfere = horarioConfere;
    }

    /**
     * @return the assinaturaBiometricaInterno
     */
    public byte[] getAssinaturaBiometricaInterno() {
        return assinaturaBiometricaInterno;
    }

    /**
     * @param assinaturaBiometricaInterno the assinaturaBiometricaInterno to set
     */
    public void setAssinaturaBiometricaInterno(byte[] assinaturaBiometricaInterno) {
        this.assinaturaBiometricaInterno = assinaturaBiometricaInterno;
    }

    /**
     * @return the idPav
     */
    public Integer getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(Integer idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the statusPav
     */
    public String getStatusPav() {
        return statusPav;
    }

    /**
     * @param statusPav the statusPav to set
     */
    public void setStatusPav(String statusPav) {
        this.statusPav = statusPav;
    }

    /**
     * @return the nomePavilhao
     */
    public String getNomePavilhao() {
        return nomePavilhao;
    }

    /**
     * @param nomePavilhao the nomePavilhao to set
     */
    public void setNomePavilhao(String nomePavilhao) {
        this.nomePavilhao = nomePavilhao;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the idCela
     */
    public Integer getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(Integer idCela) {
        this.idCela = idCela;
    }

    /**
     * @return the nomeCela
     */
    public String getNomeCela() {
        return nomeCela;
    }

    /**
     * @param nomeCela the nomeCela to set
     */
    public void setNomeCela(String nomeCela) {
        this.nomeCela = nomeCela;
    }

    /**
     * @return the usuarioInsert
     */
    public String getUsuarioInsert() {
        return usuarioInsert;
    }

    /**
     * @param usuarioInsert the usuarioInsert to set
     */
    public void setUsuarioInsert(String usuarioInsert) {
        this.usuarioInsert = usuarioInsert;
    }

    /**
     * @return the usuarioUp
     */
    public String getUsuarioUp() {
        return usuarioUp;
    }

    /**
     * @param usuarioUp the usuarioUp to set
     */
    public void setUsuarioUp(String usuarioUp) {
        this.usuarioUp = usuarioUp;
    }

    /**
     * @return the dataInsert
     */
    public String getDataInsert() {
        return dataInsert;
    }

    /**
     * @param dataInsert the dataInsert to set
     */
    public void setDataInsert(String dataInsert) {
        this.dataInsert = dataInsert;
    }

    /**
     * @return the dataUp
     */
    public String getDataUp() {
        return dataUp;
    }

    /**
     * @param dataUp the dataUp to set
     */
    public void setDataUp(String dataUp) {
        this.dataUp = dataUp;
    }

    /**
     * @return the horarioInsert
     */
    public String getHorarioInsert() {
        return horarioInsert;
    }

    /**
     * @param horarioInsert the horarioInsert to set
     */
    public void setHorarioInsert(String horarioInsert) {
        this.horarioInsert = horarioInsert;
    }

    /**
     * @return the horarioUp
     */
    public String getHorarioUp() {
        return horarioUp;
    }

    /**
     * @param horarioUp the horarioUp to set
     */
    public void setHorarioUp(String horarioUp) {
        this.horarioUp = horarioUp;
    }

    /**
     * @return the dataRealizacao
     */
    public String getDataRealizacao() {
        return dataRealizacao;
    }

    /**
     * @param dataRealizacao the dataRealizacao to set
     */
    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    /**
     * @return the qtdLanc
     */
    public int getQtdLanc() {
        return qtdLanc;
    }

    /**
     * @param qtdLanc the qtdLanc to set
     */
    public void setQtdLanc(int qtdLanc) {
        this.qtdLanc = qtdLanc;
    }
}
