package com.usjt.meuappaula12.model;

import java.io.Serializable;

public class Voo implements Comparable<Voo> , Serializable {
    private String voo;
    private String origem;
    private String destino;
    private String imagem;
    private double preco;

    public Voo() {
        this("","","","",0.0);
    }

    public Voo(String voo, String origem, String destino, String imagem, double preco) {
        this.voo = voo;
        this.origem = origem;
        this.destino = destino;
        this.imagem = imagem;
        this.preco = preco;
    }

    public String getVoo() {
        return voo;
    }

    public void setVoo(String voo) {
        this.voo = voo;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Voos {" +
                "voo='" + voo + '\'' +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", imagem='" + imagem + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public int compareTo(Voo voo) {
        if (this.voo.equals(voo.getVoo())
                && this.origem.equals(voo.getOrigem())
                && this.destino.equals(voo.getDestino())
                && this.preco == (voo.getPreco())) {
                return 0;
        }
        return this.getVoo().compareTo(voo.getVoo());
    }
}