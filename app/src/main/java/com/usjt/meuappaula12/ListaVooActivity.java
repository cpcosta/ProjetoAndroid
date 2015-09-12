package com.usjt.meuappaula12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.TreeSet;

public class ListaVooActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voo);

        Especialista especialista = new Especialista();

        Intent intent = getIntent();
        String origem = intent.getStringExtra(MainActivity.ORIGEM);
        String destino = intent.getStringExtra(MainActivity.DESTINO);

        TreeSet<Voo> lista = especialista.listarVoo(origem, destino);

        TextView textView = (TextView) findViewById(R.id.txt_lista_voo);
        String mensagem = "";

        for (Voo voo : lista){
            mensagem += voo.getVoo() + "\n";
        }
        if(mensagem.length() == 0) {
            mensagem = "Nenhuma voo encontrada para o critério escolhido.";
            textView.setLines(3);
        } else {
            textView.setLines(lista.size());
        }
        textView.setText(mensagem);
    }

}
