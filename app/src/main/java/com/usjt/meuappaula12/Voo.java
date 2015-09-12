package com.usjt.meuappaula12;

/**
 * Created by ClebersonCosta on 09/09/15.
 */
public class Voo implements Comparable<Voo> {
    private String voo;
    private String origem;
    private String destino;

    public Voo(String voo, String origem, String destino){
        setVoo(voo);
        setOrigem(origem);
        setDestino(destino);
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

    @Override
    public String toString() {
        return "Voo{" +
                "voo='" + voo + '\'' +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }

    @Override
    public int compareTo(Voo voo) {
        if (voo.equals(voo.getVoo())
                && origem.equals(voo.getOrigem())
                && destino.equals(voo.getDestino())) {
                return 0;
        }
        return this.getVoo().compareTo(voo.getVoo());
    }
}
