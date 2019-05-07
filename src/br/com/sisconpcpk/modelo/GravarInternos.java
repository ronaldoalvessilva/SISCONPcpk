/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisconpcpk.modelo;

/**
 *
 * @author Socializa TI 02
 */
public class GravarInternos {

    private int IdInternoCrc;
    private String nomeInternoCrc;
    private String cNcinterno;    
    private Integer idPav;
    private String nomePavilhao;
    private String statusPav;
    private String motivo;
    private String nivelPav;
    private Integer idCela;
    private String StatusCela;
    private String nomeCela; 
    private String nivelCel;
    private Integer capacidade;
    private Integer nrCela;
    private String cNcInterno;
    private byte [] imagemFrente;
    private String situacaoCrc;
    private byte [] dedo0;
    private byte [] dedo1;
    private byte [] dedo2;
    private byte [] dedo3;
    private Integer idLoca;
    private Integer idItem;

    public GravarInternos() {
    }

    public GravarInternos(int IdInternoCrc, String nomeInternoCrc, String cNcinterno, Integer idPav, String nomePavilhao, String statusPav, String motivo, String nivelPav, Integer idCela, String StatusCela, String nomeCela, String nivelCel, Integer capacidade, Integer nrCela, String cNcInterno, byte[] imagemFrente, String situacaoCrc, byte[] dedo0, byte[] dedo1, byte[] dedo2, byte[] dedo3, Integer idLoca, Integer idItem) {
        this.IdInternoCrc = IdInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.cNcinterno = cNcinterno;
        this.idPav = idPav;
        this.nomePavilhao = nomePavilhao;
        this.statusPav = statusPav;
        this.motivo = motivo;
        this.nivelPav = nivelPav;
        this.idCela = idCela;
        this.StatusCela = StatusCela;
        this.nomeCela = nomeCela;
        this.nivelCel = nivelCel;
        this.capacidade = capacidade;
        this.nrCela = nrCela;
        this.cNcInterno = cNcInterno;
        this.imagemFrente = imagemFrente;
        this.situacaoCrc = situacaoCrc;
        this.dedo0 = dedo0;
        this.dedo1 = dedo1;
        this.dedo2 = dedo2;
        this.dedo3 = dedo3;
        this.idLoca = idLoca;
        this.idItem = idItem;
    }

    /**
     * @return the IdInternoCrc
     */
    public int getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(int IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
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
     * @return the cNcinterno
     */
    public String getcNcinterno() {
        return cNcinterno;
    }

    /**
     * @param cNcinterno the cNcinterno to set
     */
    public void setcNcinterno(String cNcinterno) {
        this.cNcinterno = cNcinterno;
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
     * @return the nivelPav
     */
    public String getNivelPav() {
        return nivelPav;
    }

    /**
     * @param nivelPav the nivelPav to set
     */
    public void setNivelPav(String nivelPav) {
        this.nivelPav = nivelPav;
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
     * @return the StatusCela
     */
    public String getStatusCela() {
        return StatusCela;
    }

    /**
     * @param StatusCela the StatusCela to set
     */
    public void setStatusCela(String StatusCela) {
        this.StatusCela = StatusCela;
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
     * @return the nivelCel
     */
    public String getNivelCel() {
        return nivelCel;
    }

    /**
     * @param nivelCel the nivelCel to set
     */
    public void setNivelCel(String nivelCel) {
        this.nivelCel = nivelCel;
    }

    /**
     * @return the capacidade
     */
    public Integer getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * @return the nrCela
     */
    public Integer getNrCela() {
        return nrCela;
    }

    /**
     * @param nrCela the nrCela to set
     */
    public void setNrCela(Integer nrCela) {
        this.nrCela = nrCela;
    }

    /**
     * @return the cNcInterno
     */
    public String getcNcInterno() {
        return cNcInterno;
    }

    /**
     * @param cNcInterno the cNcInterno to set
     */
    public void setcNcInterno(String cNcInterno) {
        this.cNcInterno = cNcInterno;
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
     * @return the situacaoCrc
     */
    public String getSituacaoCrc() {
        return situacaoCrc;
    }

    /**
     * @param situacaoCrc the situacaoCrc to set
     */
    public void setSituacaoCrc(String situacaoCrc) {
        this.situacaoCrc = situacaoCrc;
    }

    /**
     * @return the dedo0
     */
    public byte[] getDedo0() {
        return dedo0;
    }

    /**
     * @param dedo0 the dedo0 to set
     */
    public void setDedo0(byte[] dedo0) {
        this.dedo0 = dedo0;
    }

    /**
     * @return the dedo1
     */
    public byte[] getDedo1() {
        return dedo1;
    }

    /**
     * @param dedo1 the dedo1 to set
     */
    public void setDedo1(byte[] dedo1) {
        this.dedo1 = dedo1;
    }

    /**
     * @return the dedo2
     */
    public byte[] getDedo2() {
        return dedo2;
    }

    /**
     * @param dedo2 the dedo2 to set
     */
    public void setDedo2(byte[] dedo2) {
        this.dedo2 = dedo2;
    }

    /**
     * @return the dedo3
     */
    public byte[] getDedo3() {
        return dedo3;
    }

    /**
     * @param dedo3 the dedo3 to set
     */
    public void setDedo3(byte[] dedo3) {
        this.dedo3 = dedo3;
    }

    /**
     * @return the idLoca
     */
    public Integer getIdLoca() {
        return idLoca;
    }

    /**
     * @param idLoca the idLoca to set
     */
    public void setIdLoca(Integer idLoca) {
        this.idLoca = idLoca;
    }

    /**
     * @return the idItem
     */
    public Integer getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }
}
