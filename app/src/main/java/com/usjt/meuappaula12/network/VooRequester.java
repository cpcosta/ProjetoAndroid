package com.usjt.meuappaula12.network;

import android.content.Context;
import android.net.ConnectivityManager;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

import com.squareup.okhttp.*;

import com.usjt.meuappaula12.model.Voo;

import org.json.*;

public class VooRequester
{
    OkHttpClient client = new OkHttpClient();

    public ArrayList<Voo> get(String url, String pOrigem, String pDestino) throws IOException
    {
        ArrayList<Voo> lista = new ArrayList<Voo>();

        RequestBody formBody = new FormEncodingBuilder()
            .add( "origem", pOrigem )
            .add( "destino", pDestino )
            .build();

        Request request = new Request.Builder()
            .url(url)
            .post(formBody)
            .build();

        Response response = client.newCall(request).execute();

        String jsonStr = response.body().string();

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        try
        {
            JSONArray root = new JSONArray( jsonStr );
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++ ) {
                int codigoVoo = item.getInt( "codigo" );
                String origem = item.getString( "origem" );
                String destino = item.getString( "destino" );
                String tipoAeronave = item.getString( "aeronave" );
                int escala = item.getInt( "escala" );
                String data = item.getString( "data" );
                String hora = item.getString( "hora" );
                String situacao = item.getString( "situacao" );

                lista.add( new Voo(  ) );
            }
        }
        catch ( JSONException e )
        {
            e.printStackTrace();
        }
        finally
        {
            if ( lista.size() == 0 )
            {
                System.out.println("Erro");
            }
        }

        return lista;
    }

    public boolean isConnected(Context context)
    {
        ConnectivityManager connectivityManager =  (ConnectivityManager) context.getSystemService( Context.CONNECTIVITY_SERVICE );
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
