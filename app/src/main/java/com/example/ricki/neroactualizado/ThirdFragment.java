package com.example.ricki.neroactualizado;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ricki.neroactualizado.adapters.ItemAdapterDia;
import com.example.ricki.neroactualizado.models.Dia;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * Created by ricki on 29/07/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ThirdFragment extends Fragment{
    // se declarn las variables a utilizar
    View myView;
    Button bt_generar;
    ItemAdapterDia addapterhor;
    private ListView lista_dias;
    Dia diaseleccionado;
    public ArrayList<Dia> arrayDias;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.main_thirdf,container,false);
// se declara la informacion que va traer cada uno 
        bt_generar = (Button) myView.findViewById(R.id.btn_generarpdf);

        bt_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// se llama  la url que va traer el json con la informacion
                Uri uriUrl = Uri.parse("http://10.20.4.149/Webservicesnereo/horariopdf.php");
                //Especificamos la accion a realizar con el ACTION_VIEW
                //para que elija lo mas razonable
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });
//se hace la adaptacion al listview  con la informacion 
        lista_dias = (ListView) myView.findViewById(R.id.listView);
// se adapta un arralist de dia 
        arrayDias = new ArrayList<Dia>();

        RequestQueue queuehor = Volley.newRequestQueue(getActivity());
        String url = getString(R.string.url1);
        // se verifican los metodos 
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG2",response+"Response");

                JsonArray jobjhor=new JsonParser().parse(response).getAsJsonArray();
                for (JsonElement sitem : jobjhor) {
                    System.out.println("item");
                    Dia i = new Dia();

                    //i.setDianombre(sitem.getAsJsonObject().get("DIA_NOMBRE").getAsString());
                    boolean f = true;
                    for(Dia d : arrayDias){
                        if(d.getNombredia().equals(sitem.getAsJsonObject().get("DIA_NOMBRE").getAsString())){
                            f = false;
                            break;
                        }
                    }
                    if(f){
                        arrayDias.add(new Dia(sitem.getAsJsonObject().get("DIA_NOMBRE").getAsString()));
                    }
                }
                //  se hace un item adapter de dia y se adapta la informacion
                addapterhor = new ItemAdapterDia(getActivity(), R.id.listView, arrayDias);
                ListView objListView = (ListView) ThirdFragment.this.myView.findViewById(R.id.listView);
                objListView.setAdapter(addapterhor);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG2",error.getMessage()+"Response");
            }
        });
        queuehor.add(request);

        lista_dias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
// se declara el metodo para darle click en la informacion y envie a otra venta o activity
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                diaseleccionado = arrayDias.get(position);
                Log.i("Dia seleccionado", "Dia: " + diaseleccionado);
                //Toast.makeText(MainActivity.this, arrayDias.get(position).getNombredia(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), DetalleHorario.class);
                intent.putExtra("dia", arrayDias.get(position));
                // se inicia la actividad se envia la informacion 
                startActivity(intent);
            }
        });
        return myView;
    }
}
