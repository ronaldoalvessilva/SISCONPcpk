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
public class PagamentoRefeicao {

    private int idRef;
    private String statusRef;
    private Date dataLanc;
    private String responsavel;
    private String horarioInicial;
    private String horaTermino;
    private String tipoRefeicao;
    private int idPav;
    private String descricaoPav;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public PagamentoRefeicao(int idRef, String statusRef, Date dataLanc, String responsavel, String horarioInicial, String horaTermino, String tipoRefeicao, int idPav, String descricaoPav, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idRef = idRef;
        this.statusRef = statusRef;
        this.dataLanc = dataLanc;
        this.responsavel = responsavel;
        this.horarioInicial = horarioInicial;
        this.horaTermino = horaTermino;
        this.tipoRefeicao = tipoRefeicao;
        this.idPav = idPav;
        this.descricaoPav = descricaoPav;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public PagamentoRefeicao() {
    }

    /**
     * @return the idRef
     */
    public int getIdRef() {
        return idRef;
    }

    /**
     * @param idRef the idRef to set
     */
    public void setIdRef(int idRef) {
        this.idRef = idRef;
    }

    /**
     * @return the statusRef
     */
    public String getStatusRef() {
        return statusRef;
    }

    /**
     * @param statusRef the statusRef to set
     */
    public void setStatusRef(String statusRef) {
        this.statusRef = statusRef;
    }

    /**
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
    }

    /**
     * @return the responsavel
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the horarioInicial
     */
    public String getHorarioInicial() {
        return horarioInicial;
    }

    /**
     * @param horarioInicial the horarioInicial to set
     */
    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    /**
     * @return the horaTermino
     */
    public String getHoraTermino() {
        return horaTermino;
    }

    /**
     * @param horaTermino the horaTermino to set
     */
    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    /**
     * @return the tipoRefeicao
     */
    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    /**
     * @param tipoRefeicao the tipoRefeicao to set
     */
    public void setTipoRefeicao(String tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
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
     * @return the descricaoPav
     */
    public String getDescricaoPav() {
        return descricaoPav;
    }

    /**
     * @param descricaoPav the descricaoPav to set
     */
    public void setDescricaoPav(String descricaoPav) {
        this.descricaoPav = descricaoPav;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
}
