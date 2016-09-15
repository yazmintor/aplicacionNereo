package com.example.ricki.neroactualizado;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ricki.neroactualizado.adapters.ItemAdapterNoticia;
import com.example.ricki.neroactualizado.models.Noticias;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

/**
 * Created by ricki on 29/07/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class NoticiasFragment extends Fragment {
    ItemAdapterNoticia addaptern;
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.first_layout,container,false);

        RequestQueue queue = Volley.newRequestQueue(getActivity ());

        String url =getString(R.string.url3);
        descargar();
        StringRequest request1 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG2",response+"Response");

                ArrayList<Noticias> listanoti = new ArrayList<>();
                JsonArray jobjnoti = new JsonParser ().parse(response).getAsJsonArray();
                for (JsonElement sitem : jobjnoti) {

                    Noticias j = new Noticias();

                    try {
                        j.setNombrenoti(sitem.getAsJsonObject().get("nombre").getAsString());
                        j.setDescripcion(sitem.getAsJsonObject().get("descripcion").getAsString());
                        j.setEnlace(sitem.getAsJsonObject().get("enlace").getAsString());
                        j.setFecha_radica(sitem.getAsJsonObject().get("fecha_radicacion").getAsString());
                        j.setImagen(sitem.getAsJsonObject().get("imagen").getAsString());

                    }
                    catch (NullPointerException e){

                        System.out.println("Valores Nulos");
                    }
                    listanoti.add(j);
                }
                addaptern = new ItemAdapterNoticia(getActivity(), R.id.listanoticias, listanoti);
                final ListView objListView = (ListView) myView.findViewById(R.id.listanoticias);
                objListView.setAdapter(addaptern);

    }

}
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG2",error.getMessage()+"Response");
            }
        });
        queue.add(request1);
        return myView;
    }
    private void descargar() {

        final ProgressDialog alerta = new ProgressDialog(getActivity());
        alerta.setMessage("Cargando Datos...");
        alerta.show();

        AsyncHttpClient cliente = new AsyncHttpClient();
        cliente.get("http://jcgrafficdesigns.net/Nereo/ejemplo2.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                if(statusCode==200){
                    alerta.dismiss();
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

}
