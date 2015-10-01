package com.usjt.meuappaula12.network;

import com.usjt.meuappaula12.model.Voo;

import java.util.ArrayList;
import java.util.TreeSet;

public class Especialista {

    public static final ArrayList<Voo> cadastros = cadastroVoo();

    public TreeSet<Voo> listarVoo(String origem, String destino) {
        TreeSet<Voo> lista = new TreeSet<>();

        if (origem.length() > 0 && destino.length() > 0) {
            lista = buscarOrigemDestino(origem, destino);
        } else if (origem.length() > 0) {
            lista = buscarOrigem(origem);
        } else if (destino.length() >0) {
            lista = buscarDestino(destino);
        } else {
            lista = buscarTodos();
        }

        return lista;
    }

    private static ArrayList<Voo> cadastroVoo() {
        ArrayList<Voo> voo = new ArrayList<>();
        voo.add(new Voo("Brasil -> África do Sul", "Brasil", "África do Sul", "", 1));
        voo.add(new Voo("Brasil -> Alemanha", "Brasil", "Alemanha", "", 1));
        voo.add(new Voo("Brasil -> Argentina", "Brasil", "Argentina", "", 1));
        voo.add(new Voo("Brasil -> Autrália", "Brasil", "Austrália", "", 1));
        voo.add(new Voo("Brasil -> Canada", "Brasil", "Canada", "", 1));
        voo.add(new Voo("Brasil -> Inglaterra", "Brasil", "Inglaterra", "", 1));
        voo.add(new Voo("Brasil -> Japão", "Brasil", "Japão", "", 1));

        voo.add(new Voo("África do Sul -> Brasil", "África do Sul", "Brasil", "", 1));
        voo.add(new Voo("África do Sul -> Alemanha", "África do Sul", "Alemanha", "", 1));
        voo.add(new Voo("África do Sul -> Argentina", "África do Sul", "Argentina", "", 1));
        voo.add(new Voo("África do Sul -> Austrália", "África do Sul", "Austrália", "", 1));
        voo.add(new Voo("África do Sul -> Canada", "África do Sul", "Canada", "", 1));
        voo.add(new Voo("África do Sul -> Inglaterra", "África do Sul", "Inglaterra", "", 1));
        voo.add(new Voo("África do Sul -> Japão", "África do Sul", "Japão", "", 1));

        voo.add(new Voo("Alemanha -> África do Sul", "Alemanha", "África do Sul", "", 1));
        voo.add(new Voo("Alemanha -> Brasil", "Alemanha", "Brasil", "", 1));
        voo.add(new Voo("Alemanha -> Argentina", "Alemanha", "Argentina", "", 1));
        voo.add(new Voo("Alemanha -> Austrália", "Alemanha", "Austrália", "", 1));
        voo.add(new Voo("Alemanha -> Canada", "Alemanha", "Canada", "", 1));
        voo.add(new Voo("Alemanha -> Inglaterra", "Alemanha", "Inglaterra", "", 1));
        voo.add(new Voo("Alemanha -> Japão", "Alemanha", "Japão", "", 1));

        voo.add(new Voo("Argentina -> África do Sul", "Argentina", "África do Sul", "", 1));
        voo.add(new Voo("Argentina -> Brasil", "Argentina", "Brasil", "", 1));
        voo.add(new Voo("Argentina -> Alemanha", "Argentina", "Alemanha", "", 1));
        voo.add(new Voo("Argentina -> Austrália", "Argentina", "Austrália", "", 1));
        voo.add(new Voo("Argentina -> Canada", "Argentina", "Canada", "", 1));
        voo.add(new Voo("Argentina -> Inglaterra", "Argentina", "Inglaterra", "", 1));
        voo.add(new Voo("Argentina -> Japão", "Argentina", "Japão", "", 1));

        voo.add(new Voo("Austrália -> África do Sul", "Austrália", "África do Sul", "", 1));
        voo.add(new Voo("Austrália -> Brasil", "Austrália", "Brasil", "", 1));
        voo.add(new Voo("Austrália -> Alemanha", "Austrália", "Alemanha", "", 1));
        voo.add(new Voo("Austrália -> Argentina", "Austrália", "Argentina", "", 1));
        voo.add(new Voo("Austrália -> Canada", "Austrália", "Canada", "", 1));
        voo.add(new Voo("Austrália -> Inglaterra", "Austrália", "Inglaterra", "", 1));
        voo.add(new Voo("Austrália -> Japão", "Austrália", "Japão", "", 1));

        voo.add(new Voo("Canada -> África do Sul", "Canada", "África do Sul", "", 1));
        voo.add(new Voo("Canada -> Brasil", "Canada", "Brasil", "", 1));
        voo.add(new Voo("Canada -> Alemanha", "Canada", "Alemanha", "", 1));
        voo.add(new Voo("Canada -> Argentina", "Canada", "Argentina", "", 1));
        voo.add(new Voo("Canada -> Austrália", "Canada", "Austrália", "", 1));
        voo.add(new Voo("Canada -> Inglaterra", "Canada", "Inglaterra", "", 1));
        voo.add(new Voo("Canada -> Japão", "Canada", "Japão", "", 1));

        voo.add(new Voo("Inglaterra -> África do Sul", "Inglaterra", "África do Sul", "", 1));
        voo.add(new Voo("Inglaterra -> Brasil", "Inglaterra", "Brasil", "", 1));
        voo.add(new Voo("Inglaterra -> Alemanha", "Inglaterra", "Alemanha", "", 1));
        voo.add(new Voo("Inglaterra -> Argentina", "Inglaterra", "Argentina", "", 1));
        voo.add(new Voo("Inglaterra -> Austrália", "Inglaterra", "Austrália", "", 1));
        voo.add(new Voo("Inglaterra -> Canada", "Inglaterra", "Canadá", "", 1));
        voo.add(new Voo("Inglaterra -> Japão", "Inglaterra", "Japão", "", 1));

        voo.add(new Voo("Japão -> África do Sul", "Japão", "África do Sul", "", 1));
        voo.add(new Voo("Japão -> Brasil", "Japão", "Brasil", "", 1));
        voo.add(new Voo("Japão -> Alemanha", "Japão", "Alemanha", "", 1));
        voo.add(new Voo("Japão -> Argentina", "Japão", "Argentina", "", 1));
        voo.add(new Voo("Japão -> Austrália", "Japão", "Austrália", "", 1));
        voo.add(new Voo("Japão -> Canada", "Japão", "Canadá", "", 1));
        voo.add(new Voo("Japão -> Inglaterra", "Japão", "Inglaterra", "", 1));

        return voo;
    }

    private TreeSet<Voo> buscarOrigem(String origem) {
        TreeSet<Voo> lista = new TreeSet<>();
        for (Voo voo : cadastroVoo()) {
            if (origem.equals(voo.getOrigem())) lista.add(voo);
        }
        return lista;
    }

    private TreeSet<Voo> buscarDestino(String destino) {
        TreeSet<Voo> lista = new TreeSet<>();
        for (Voo voo : cadastroVoo()) {
            if (destino.equals(voo.getDestino())) lista.add(voo);
        }
        return lista;
    }

    private TreeSet<Voo> buscarOrigemDestino(String origem, String destino) {
        TreeSet<Voo> lista = new TreeSet<>();
        for (Voo voo : cadastroVoo()) {
            if (origem.equals(voo.getOrigem())
                    && destino.equals(voo.getDestino())) {
                lista.add(voo);
            }
        }
        return lista;
    }

    private TreeSet<Voo> buscarTodos() {
        TreeSet<Voo> lista = new TreeSet<>();
        for (Voo voo : cadastroVoo()) {
            lista.add((voo));
        }
        return lista;
    }
}