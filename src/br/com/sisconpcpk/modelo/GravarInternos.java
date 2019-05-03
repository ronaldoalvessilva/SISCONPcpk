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

    public GravarInternos() {
    }

    public GravarInternos(int IdInternoCrc, String nomeInternoCrc, String cNcinterno) {
        this.IdInternoCrc = IdInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.cNcinterno = cNcinterno;
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
}
