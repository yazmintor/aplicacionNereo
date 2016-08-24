package com.example.ricki.neroactualizado;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ricki.neroactualizado.adapters.MateriaDiaAdapter;
import com.example.ricki.neroactualizado.models.Dia;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * Created by Sammy on 6/08/2016.
 */
public class DetalleHorario extends Activity {

    View myView;
    MateriaDiaAdapter addapterhor;
    TextView dia;
    MainActivity ma = new MainActivity();

    @Override
    protected void onCreate(final Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horario);

        final String diaselecionado = ((Dia)getIntent().getExtras().get("dia")).getNombredia();

        dia = (TextView) findViewById(R.id.textViewDia);
        ((TextView) findViewById(R.id.textViewDiaTitulo)).setText(diaselecionado);//mostrarDetalle de las materias asociadas al dia();


        RequestQueue queuehor = Volley.newRequestQueue(this); //Almacena las peticiones http desde la aplicacióon hacie servidores externos
        String url = getString(R.string.url1); //Servicio web
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG2",response+"Response");
                final ArrayList<Dia> listadia = new ArrayList<>();
                    // Array que almacena los datos del detalle de las clases
                JsonArray jobjhor=new JsonParser().parse(response).getAsJsonArray();
                for (JsonElement sitem : jobjhor) {
                    if(diaselecionado.equals(sitem.getAsJsonObject().get("DIA_NOMBRE").getAsString())){
                        Dia i = new Dia();

                        i.setDianombre(sitem.getAsJsonObject().get("DIA_NOMBRE").getAsString());
                        i.setNombredia(sitem.getAsJsonObject().get("DIA_NOMBRE").getAsString());
                        i.setNomasig(sitem.getAsJsonObject().get("ASI_NOMBRE").getAsString());
                        i.setCodigocra(sitem.getAsJsonObject().get("CODIGOCRA").getAsString());
                        i.setGrupocod(sitem.getAsJsonObject().get("GRUPO").getAsString());
                        i.setHora(sitem.getAsJsonObject().get("HOR_HORA").getAsString());
                        i.setHoras(sitem.getAsJsonObject().get("HOR_SAL_ID_ESPACIO").getAsString());
                        i.setSedenombre(sitem.getAsJsonObject().get("SED_NOM").getAsString());
                        i.setEdinombre(sitem.getAsJsonObject().get("EDI_NOMBRE").getAsString());
                        i.setSalnombre(sitem.getAsJsonObject().get("SAL_NOMBRE").getAsString());
                        i.setDocente(sitem.getAsJsonObject().get("DOCENTE").getAsString());
                        i.setApellido(sitem.getAsJsonObject().get("APELLIDO").getAsString());

                        listadia.add(i);
                    }
                }
                // Adaptador que crea la interfaz con los datos
                addapterhor = new MateriaDiaAdapter(DetalleHorario.this, R.id.listPrueba, listadia);
                GridView objListView = (GridView) DetalleHorario.this.findViewById(R.id.listPrueba);
                objListView.setAdapter(addapterhor);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG2",error.getMessage()+"Response");
            }
        });
        queuehor.add(request); 
    }

}
