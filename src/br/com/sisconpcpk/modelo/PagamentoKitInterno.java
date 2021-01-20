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
public class PagamentoKitInterno {

    private int idPagto;
    private String statusLanc;
    private Date dataLanc;
    private String responsavel;
    private String horaInicio;
    private String horaTermino;
    private String tipoKit;
    private int idPav;
    private String descricaoPavilhao;
    private String observacao;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;
    private int idRegistroComp;
    private int idKit;
    private String kitPersonalizado;
    private int iD_KIT_inicial;
    private int iD_KIT_decendial;
    private int iD_KIT_quinzenal;
    private int iD_KIT_mensal;
    private int iD_KIT_semestral;
    private int iD_KIT_anual;
    private Integer iD_REG_inicial;
    private Integer iD_REG_decendial;
    private Integer iD_REG_quinzenal;
    private Integer iD_REG_mensal;
    private Integer iD_REG_semestral;
    private Integer iD_REG_anual;

    public PagamentoKitInterno() {
    }

    public PagamentoKitInterno(int idPagto, String statusLanc, Date dataLanc, String responsavel, String horaInicio, String horaTermino, String tipoKit, int idPav, String descricaoPavilhao, String observacao, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp, int idRegistroComp, int idKit, String kitPersonalizado, int iD_KIT_inicial, int iD_KIT_decendial, int iD_KIT_quinzenal, int iD_KIT_mensal, int iD_KIT_semestral, int iD_KIT_anual, Integer iD_REG_inicial, Integer iD_REG_decendial, Integer iD_REG_quinzenal, Integer iD_REG_mensal, Integer iD_REG_semestral, Integer iD_REG_anual) {
        this.idPagto = idPagto;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.responsavel = responsavel;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.tipoKit = tipoKit;
        this.idPav = idPav;
        this.descricaoPavilhao = descricaoPavilhao;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
        this.idRegistroComp = idRegistroComp;
        this.idKit = idKit;
        this.kitPersonalizado = kitPersonalizado;
        this.iD_KIT_inicial = iD_KIT_inicial;
        this.iD_KIT_decendial = iD_KIT_decendial;
        this.iD_KIT_quinzenal = iD_KIT_quinzenal;
        this.iD_KIT_mensal = iD_KIT_mensal;
        this.iD_KIT_semestral = iD_KIT_semestral;
        this.iD_KIT_anual = iD_KIT_anual;
        this.iD_REG_inicial = iD_REG_inicial;
        this.iD_REG_decendial = iD_REG_decendial;
        this.iD_REG_quinzenal = iD_REG_quinzenal;
        this.iD_REG_mensal = iD_REG_mensal;
        this.iD_REG_semestral = iD_REG_semestral;
        this.iD_REG_anual = iD_REG_anual;
    }

    /**
     * @return the idPagto
     */
    public int getIdPagto() {
        return idPagto;
    }

    /**
     * @param idPagto the idPagto to set
     */
    public void setIdPagto(int idPagto) {
        this.idPagto = idPagto;
    }

    /**
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
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
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
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
     * @return the tipoKit
     */
    public String getTipoKit() {
        return tipoKit;
    }

    /**
     * @param tipoKit the tipoKit to set
     */
    public void setTipoKit(String tipoKit) {
        this.tipoKit = tipoKit;
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
     * @return the descricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return descricaoPavilhao;
    }

    /**
     * @param descricaoPavilhao the descricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String descricaoPavilhao) {
        this.descricaoPavilhao = descricaoPavilhao;
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
     * @return the idRegistroComp
     */
    public int getIdRegistroComp() {
        return idRegistroComp;
    }

    /**
     * @param idRegistroComp the idRegistroComp to set
     */
    public void setIdRegistroComp(int idRegistroComp) {
        this.idRegistroComp = idRegistroComp;
    }

    /**
     * @return the idKit
     */
    public int getIdKit() {
        return idKit;
    }

    /**
     * @param idKit the idKit to set
     */
    public void setIdKit(int idKit) {
        this.idKit = idKit;
    }

    /**
     * @return the kitPersonalizado
     */
    public String getKitPersonalizado() {
        return kitPersonalizado;
    }

    /**
     * @param kitPersonalizado the kitPersonalizado to set
     */
    public void setKitPersonalizado(String kitPersonalizado) {
        this.kitPersonalizado = kitPersonalizado;
    }

    /**
     * @return the iD_KIT_inicial
     */
    public int getiD_KIT_inicial() {
        return iD_KIT_inicial;
    }

    /**
     * @param iD_KIT_inicial the iD_KIT_inicial to set
     */
    public void setiD_KIT_inicial(int iD_KIT_inicial) {
        this.iD_KIT_inicial = iD_KIT_inicial;
    }

    /**
     * @return the iD_KIT_decendial
     */
    public int getiD_KIT_decendial() {
        return iD_KIT_decendial;
    }

    /**
     * @param iD_KIT_decendial the iD_KIT_decendial to set
     */
    public void setiD_KIT_decendial(int iD_KIT_decendial) {
        this.iD_KIT_decendial = iD_KIT_decendial;
    }

    /**
     * @return the iD_KIT_quinzenal
     */
    public int getiD_KIT_quinzenal() {
        return iD_KIT_quinzenal;
    }

    /**
     * @param iD_KIT_quinzenal the iD_KIT_quinzenal to set
     */
    public void setiD_KIT_quinzenal(int iD_KIT_quinzenal) {
        this.iD_KIT_quinzenal = iD_KIT_quinzenal;
    }

    /**
     * @return the iD_KIT_mensal
     */
    public int getiD_KIT_mensal() {
        return iD_KIT_mensal;
    }

    /**
     * @param iD_KIT_mensal the iD_KIT_mensal to set
     */
    public void setiD_KIT_mensal(int iD_KIT_mensal) {
        this.iD_KIT_mensal = iD_KIT_mensal;
    }

    /**
     * @return the iD_KIT_semestral
     */
    public int getiD_KIT_semestral() {
        return iD_KIT_semestral;
    }

    /**
     * @param iD_KIT_semestral the iD_KIT_semestral to set
     */
    public void setiD_KIT_semestral(int iD_KIT_semestral) {
        this.iD_KIT_semestral = iD_KIT_semestral;
    }

    /**
     * @return the iD_KIT_anual
     */
    public int getiD_KIT_anual() {
        return iD_KIT_anual;
    }

    /**
     * @param iD_KIT_anual the iD_KIT_anual to set
     */
    public void setiD_KIT_anual(int iD_KIT_anual) {
        this.iD_KIT_anual = iD_KIT_anual;
    }

    /**
     * @return the iD_REG_inicial
     */
    public Integer getiD_REG_inicial() {
        return iD_REG_inicial;
    }

    /**
     * @param iD_REG_inicial the iD_REG_inicial to set
     */
    public void setiD_REG_inicial(Integer iD_REG_inicial) {
        this.iD_REG_inicial = iD_REG_inicial;
    }

    /**
     * @return the iD_REG_decendial
     */
    public Integer getiD_REG_decendial() {
        return iD_REG_decendial;
    }

    /**
     * @param iD_REG_decendial the iD_REG_decendial to set
     */
    public void setiD_REG_decendial(Integer iD_REG_decendial) {
        this.iD_REG_decendial = iD_REG_decendial;
    }

    /**
     * @return the iD_REG_quinzenal
     */
    public Integer getiD_REG_quinzenal() {
        return iD_REG_quinzenal;
    }

    /**
     * @param iD_REG_quinzenal the iD_REG_quinzenal to set
     */
    public void setiD_REG_quinzenal(Integer iD_REG_quinzenal) {
        this.iD_REG_quinzenal = iD_REG_quinzenal;
    }

    /**
     * @return the iD_REG_mensal
     */
    public Integer getiD_REG_mensal() {
        return iD_REG_mensal;
    }

    /**
     * @param iD_REG_mensal the iD_REG_mensal to set
     */
    public void setiD_REG_mensal(Integer iD_REG_mensal) {
        this.iD_REG_mensal = iD_REG_mensal;
    }

    /**
     * @return the iD_REG_semestral
     */
    public Integer getiD_REG_semestral() {
        return iD_REG_semestral;
    }

    /**
     * @param iD_REG_semestral the iD_REG_semestral to set
     */
    public void setiD_REG_semestral(Integer iD_REG_semestral) {
        this.iD_REG_semestral = iD_REG_semestral;
    }

    /**
     * @return the iD_REG_anual
     */
    public Integer getiD_REG_anual() {
        return iD_REG_anual;
    }

    /**
     * @param iD_REG_anual the iD_REG_anual to set
     */
    public void setiD_REG_anual(Integer iD_REG_anual) {
        this.iD_REG_anual = iD_REG_anual;
    }
}
