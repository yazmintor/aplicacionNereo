package com.example.ricki.neroactualizado;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

/**
 * Created by Sammy Torres on 27/08/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class NoticiasFragment extends Fragment {
    ItemAdapterNoticia addaptern;
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.primeroa,container,false);
        RequestQueue queue = Volley.newRequestQueue(getActivity ());
        String url =getString(R.string.url3);

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
                addaptern = new ItemAdapterNoticia(getActivity(), R.id.gridView2, listanoti);
                final GridView objListView = (GridView) myView.findViewById(R.id.gridView);
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
}

