package com.usjt.meuappaula12.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.usjt.meuappaula12.R;
import com.usjt.meuappaula12.model.Voo;
import com.usjt.meuappaula12.network.VooRequester;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String ORIGEM = "br.usjt.ORIGEM";
    final static String DESTINO = "br.usjt.DESTINO";

    final String servidor = "192.168.56.1:8080";

    String origem, destino;
    Spinner spinnerOrigem, spinnerDestino;
    Button btnConsultar;
    VooRequester requester;
    ProgressBar mProgress;
    Intent intent;
    ArrayList<Voo> voos;

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

/*    public void consulta(View view) {
        String pOrigem = this.origem.equals("Escolha seu país") ?  "" : origem;
        String pDestino = this.origem.equals("Escolha seu país") ?  "" : destino;

        Intent intent = new Intent(this, ListaVooActivity.class);
        intent.putExtra(ORIGEM, pOrigem);
        intent.putExtra(DESTINO, pDestino);
        startActivity(intent);
    }*/

    final static String VOOS = " br.usjt.VOOS ";
    public void consultar( View view )
    {
        final String pOrigem = this.origem.equals("Escolha seu país") ?  "" : origem;
        final String pDestino = this.destino.equals("Escolha seu país") ?  "" : destino;

        requester = new VooRequester();
        if ( requester.isConnected(this) )
        {
            intent = new Intent( this, ListaVooActivity.class );

//            mProgress.setVisibility( View.VISIBLE );
            new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try
                    {
                        voos = requester.get( "http://" + servidor + "/Air_Lines_Company/voos.json", origem, destino );
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent.putExtra( VOOS, voos );
//                                mProgress.setVisibility( View.INVISIBLE);
                                startActivity( intent );
                            }
                        });
                    }
                    catch ( Exception e )
                    {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Rede indisponível!", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
