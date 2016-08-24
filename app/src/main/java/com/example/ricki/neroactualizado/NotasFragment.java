package com.example.ricki.neroactualizado;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ricki.neroactualizado.adapters.ItemAdapter;
import com.example.ricki.neroactualizado.models.Item;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * Created by ricki on 29/07/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class NotasFragment extends Fragment{
    ItemAdapter addaptera;
    View myView;
    Button bt_generar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.notas_layout,container,false);
        bt_generar = (Button) myView.findViewById(R.id.generar);
        bt_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uriUrl = Uri.parse("http://10.20.4.149/Webservicesnereo/notaspdf.php");
                //Especificamos la accion a realizar con el ACTION_VIEW
                //para que elija lo mas razonable
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });
        RequestQueue queue = Volley.newRequestQueue(getActivity ());
        String url =getString(R.string.url);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG2",response+"Response");
                final ArrayList<Item> listaitems = new ArrayList<>();
                JsonArray jobj=new JsonParser ().parse(response).getAsJsonArray();
                for (JsonElement sitem : jobj) {
                    Item i = new Item();
                    i.setNombre(sitem.getAsJsonObject().get("NOMBRE_ESPACIO").getAsString());
                    i.setAcum(sitem.getAsJsonObject().get("NOTA_ACUM").getAsString());
                    i.setDefini(sitem.getAsJsonObject().get("NOTA_DEF").getAsString());
                    i.setPorce1(sitem.getAsJsonObject().get("PPAR").getAsString());
                    i.setNota1(sitem.getAsJsonObject().get("NOTA_PAR1").getAsString());
                    i.setPorce2(sitem.getAsJsonObject().get("PPAR2").getAsString());
                    i.setNota2(sitem.getAsJsonObject().get("NOTA_PAR2").getAsString());
                    i.setPorce3(sitem.getAsJsonObject().get("PPAR3").getAsString());
                    i.setNota3(sitem.getAsJsonObject().get("NOTA_PAR3").getAsString());
                    i.setPorce4(sitem.getAsJsonObject().get("PPAR4").getAsString());
                    i.setNota4(sitem.getAsJsonObject().get("NOTA_PAR4").getAsString());
                    i.setPorce5(sitem.getAsJsonObject().get("PPAR5").getAsString());
                    i.setNota5(sitem.getAsJsonObject().get("NOTA_PAR5").getAsString());
                    i.setPorce6(sitem.getAsJsonObject().get("PPAR6").getAsString());
                    i.setNota6(sitem.getAsJsonObject().get("NOTA_PAR6").getAsString());
                    i.setPorcelab(sitem.getAsJsonObject().get("PLAB").getAsString());
                    i.setNotalab(sitem.getAsJsonObject().get("NOTA_LAB").getAsString());
                    i.setPorceexa(sitem.getAsJsonObject().get("PEXA").getAsString());
                    i.setNotaexa(sitem.getAsJsonObject().get("NOTA_EXA").getAsString());
                    listaitems.add(i);

                }
                 addaptera = new ItemAdapter(getActivity (), R.id.gridView, listaitems);
               final GridView objListView = (GridView) myView.findViewById(R.id.gridView);
                objListView.setAdapter(addaptera);
                objListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(getActivity (), DetalleNotas.class);
                        intent.putExtra("parametro",listaitems.get(position));
                        intent.putExtra("porce1", listaitems.get(position));
                        intent.putExtra("nota1", listaitems.get(position));
                        intent.putExtra("porce2", listaitems.get(position));
                        intent.putExtra("nota2", listaitems.get(position));
                        intent.putExtra("porce3", listaitems.get(position));
                        intent.putExtra("nota3", listaitems.get(position));
                        intent.putExtra("porce4", listaitems.get(position));
                        intent.putExtra("nota4", listaitems.get(position));
                        intent.putExtra("porce5", listaitems.get(position));
                        intent.putExtra("nota5", listaitems.get(position));
                        intent.putExtra("porce6", listaitems.get(position));
                        intent.putExtra("nota6", listaitems.get(position));
                        intent.putExtra("porcelab", listaitems.get(position));
                        intent.putExtra("notalab", listaitems.get(position));
                        intent.putExtra("porceexa", listaitems.get(position));
                        intent.putExtra("notaexa", listaitems.get(position));

                        startActivity(intent);
                    }

                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG2",error.getMessage()+"Response");
            }
        });
        queue.add(request);
        return myView;
    }
}

