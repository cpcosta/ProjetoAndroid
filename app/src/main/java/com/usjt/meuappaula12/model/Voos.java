package com.usjt.meuappaula12.model;

public class Voos
{
    private int codigoVoo;
    private String origem;
    private String destino;
    private String tipoAeronave;
    private int escalas;
    private String data;
    private String hora;
    private String situacao;

    public Voos()
    {
        this(0, "", "", "", 0, "", "", "");
    }

    public Voos(int codigoVoo, String origem, String destino, String tipoAeronave, int escalas, String data, String hora, String situacao)
    {
        this.codigoVoo = codigoVoo;
        this.origem = origem;
        this.destino = destino;
        this.tipoAeronave = tipoAeronave;
        this.escalas = escalas;
        this.data = data;
        this.hora = hora;
        this.situacao = situacao;
    }

    public int getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(int codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoAeronave() {
        return tipoAeronave;
    }

    public void setTipoAeronave(String tipoAeronave) {
        this.tipoAeronave = tipoAeronave;
    }

    public int getEscalas() {
        return escalas;
    }

    public void setEscalas(int escalas) {
        this.escalas = escalas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}