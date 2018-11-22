/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ht3000877
 */
public class Cliente {

    /**
     * @return the idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the endCliente
     */
    public String getEndCliente() {
        return endCliente;
    }

    /**
     * @param endCliente the endCliente to set
     */
    public void setEndCliente(String endCliente) {
        this.endCliente = endCliente;
    }

    /**
     * @return the cidCliente
     */
    public String getCidCliente() {
        return cidCliente;
    }

    /**
     * @param cidCliente the cidCliente to set
     */
    public void setCidCliente(String cidCliente) {
        this.cidCliente = cidCliente;
    }

    /**
     * @return the estCliente
     */
    public String getEstCliente() {
        return estCliente;
    }

    /**
     * @param estCliente the estCliente to set
     */
    public void setEstCliente(String estCliente) {
        this.estCliente = estCliente;
    }

    /**
     * @return the telCliente
     */
    public String getTelCliente() {
        return telCliente;
    }

    /**
     * @param telCliente the telCliente to set
     */
    public void setTelCliente(String telCliente) {
        this.telCliente = telCliente;
    }
    private int idClient;
    private String nomeCliente;
    private String endCliente;
    private String cidCliente;
    private String estCliente;
    private String telCliente;
}
