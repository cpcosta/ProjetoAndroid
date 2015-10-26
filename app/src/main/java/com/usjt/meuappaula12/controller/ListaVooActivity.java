package com.usjt.meuappaula12.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.usjt.meuappaula12.adapter.VooAdapter;
import com.usjt.meuappaula12.network.Especialista;
import com.usjt.meuappaula12.R;
import com.usjt.meuappaula12.model.Voo;

import java.util.ArrayList;

public class ListaVooActivity extends ActionBarActivity {
    ListView listView;
    Activity atividade;
    public final static String VOO = "br.usjt.VOO";
    Voo[] voos;

//    BaseAdapter adapter;
//    String[] lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voo);
        atividade = this;

        // objeto especialista, responsavel por listar os voos
//        Especialista especialista = new Especialista();

        Intent intent = getIntent();
        voos = ((ArrayList<Voo>)intent.getSerializableExtra( MainActivity.VOOS )).toArray( new Voo[0] );

        // atribui os dados contidos na activity principal
//        String origem = intent.getStringExtra( MainActivity.ORIGEM );
//        String destino = intent.getStringExtra( MainActivity.DESTINO );

        // cria um array de voos
//        voos = especialista.listarVoo(origem, destino ).toArray(new Voo[0]);

        // cria uma lista de voos
        listView = (ListView) findViewById( R.id.view_lista_ );

        VooAdapter adapter = new VooAdapter( this, voos );

        // faz adaptacao no listview
        listView.setAdapter( adapter );

        // cria uma array de String
//        lista = new String[voos.length];

        // gera uma lista com nome dos voos
//        for (int i = 0; i < voos.length; i++)
//        {
//            lista[i] = voos[i].getVoo();
//        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent( atividade, DetalheVooActivity.class );
                intent.putExtra( VOO, voos[position] );

                startActivity(intent);
            }
        });

    }
}