package com.usjt.meuappaula12;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by ClebersonCosta on 09/09/15.
 */
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
        voo.add(new Voo("VooBrAf", "Brasil", "África do Sul"));
        voo.add(new Voo("VooBrAl", "Brasil", "Alemanha"));
        voo.add(new Voo("VooBrAr", "Brasil", "Argentina"));
        voo.add(new Voo("VooBrAu", "Brasil", "Austrália"));
        voo.add(new Voo("VooBrCa", "Brasil", "Canada"));
        voo.add(new Voo("VooBrIn", "Brasil", "Inglaterra"));
        voo.add(new Voo("VooBrJa", "Brasil", "Japão"));

        voo.add(new Voo("VooAfBr", "África do Sul", "Brasil"));
        voo.add(new Voo("VooAfAl", "África do Sul", "Alemanha"));
        voo.add(new Voo("VooAfAr", "África do Sul", "Argentina"));
        voo.add(new Voo("VooAfAu", "África do Sul", "Austrália"));
        voo.add(new Voo("VooAfCa", "África do Sul", "Canada"));
        voo.add(new Voo("VooAfIn", "África do Sul", "Inglaterra"));
        voo.add(new Voo("VooAfJa", "África do Sul", "Japão"));

        voo.add(new Voo("VooAlAf", "Alemanha", "África do Sul"));
        voo.add(new Voo("VooAlBr", "Alemanha", "Brasil"));
        voo.add(new Voo("VooAlAr", "Alemanha", "Argentina"));
        voo.add(new Voo("VooAlAu", "Alemanha", "Austrália"));
        voo.add(new Voo("VooAlCa", "Alemanha", "Canada"));
        voo.add(new Voo("VooAlIn", "Alemanha", "Inglaterra"));
        voo.add(new Voo("VooAlJa", "Alemanha", "Japão"));

        voo.add(new Voo("VooArAf", "Argentina", "África do Sul"));
        voo.add(new Voo("VooArBr", "Argentina", "Brasil"));
        voo.add(new Voo("VooArAr", "Argentina", "Alemanha"));
        voo.add(new Voo("VooArAu", "Argentina", "Austrália"));
        voo.add(new Voo("VooArCa", "Argentina", "Canada"));
        voo.add(new Voo("VooArIn", "Argentina", "Inglaterra"));
        voo.add(new Voo("VooArJa", "Argentina", "Japão"));

        voo.add(new Voo("VooAuAf", "Austrália", "África do Sul"));
        voo.add(new Voo("VooAuBr", "Austrália", "Brasil"));
        voo.add(new Voo("VooAuAl", "Austrália", "Alemanha"));
        voo.add(new Voo("VooAuAr", "Austrália", "Argentina"));
        voo.add(new Voo("VooAuCa", "Austrália", "Canada"));
        voo.add(new Voo("VooAuIn", "Austrália", "Inglaterra"));
        voo.add(new Voo("VooAuJa", "Austrália", "Japão"));

        voo.add(new Voo("VooCaAf", "Canada", "África do Sul"));
        voo.add(new Voo("VooCaBr", "Canada", "Brasil"));
        voo.add(new Voo("VooCaAl", "Canada", "Alemanha"));
        voo.add(new Voo("VooCaAr", "Canada", "Argentina"));
        voo.add(new Voo("VooCaAu", "Canada", "Austrália"));
        voo.add(new Voo("VooCaIn", "Canada", "Inglaterra"));
        voo.add(new Voo("VooCaJa", "Canada", "Japão"));

        voo.add(new Voo("VooInAf", "Inglaterra", "África do Sul"));
        voo.add(new Voo("VooInBr", "Inglaterra", "Brasil"));
        voo.add(new Voo("VooInAl", "Inglaterra", "Alemanha"));
        voo.add(new Voo("VooInAr", "Inglaterra", "Argentina"));
        voo.add(new Voo("VooInAu", "Inglaterra", "Austrália"));
        voo.add(new Voo("VooInCa", "Inglaterra", "Canadá"));
        voo.add(new Voo("VooInJa", "Inglaterra", "Japão"));

        voo.add(new Voo("VooJaAf", "Japão", "África do Sul"));
        voo.add(new Voo("VooJaBr", "Japão", "Brasil"));
        voo.add(new Voo("VooJaAl", "Japão", "Alemanha"));
        voo.add(new Voo("VooJaAr", "Japão", "Argentina"));
        voo.add(new Voo("VooJaAu", "Japão", "Austrália"));
        voo.add(new Voo("VooJaCa", "Japão", "Canadá"));
        voo.add(new Voo("VooJaIn", "Japão", "Inglaterra"));

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