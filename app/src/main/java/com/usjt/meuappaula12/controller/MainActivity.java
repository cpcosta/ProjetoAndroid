package com.usjt.meuappaula12.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.usjt.meuappaula12.R;
import com.usjt.meuappaula12.controller.ListaVooActivity;

public class MainActivity extends AppCompatActivity {

    public final static String ORIGEM = "br.usjt.ORIGEM";
    public final static String DESTINO = "br.usjt.DESTINO";

    String origem, destino;
    Spinner spinnerOrigem, spinnerDestino;
    Button btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        origem = "";
        destino = "";

        btnConsultar = (Button) findViewById(R.id.botao_enviar);

        spinnerOrigem = (Spinner) findViewById(R.id.dropdown_origem);
        spinnerDestino = (Spinner) findViewById(R.id.dropdown_destino);

        spinnerOrigem.setOnItemSelectedListener(new OrigemSelecionada());
        spinnerDestino.setOnItemSelectedListener(new DestinoSelecionado());
    }

    private class OrigemSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            origem = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class DestinoSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            destino = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    public void consultar(View view) {
        String pOrigem = this.origem.equals("Escolha seu país") ?  "" : origem;
        String pDestino = this.origem.equals("Escolha seu país") ?  "" : destino;

        Intent intent = new Intent(this, ListaVooActivity.class);
        intent.putExtra(ORIGEM, pOrigem);
        intent.putExtra(DESTINO, pDestino);
        startActivity(intent);
    }
}
