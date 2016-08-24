package com.example.ricki.neroactualizado;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.ricki.neroactualizado.models.Item;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.entity.mime.Header;

/**
 * Created by ricki on 29/07/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SecondFragment extends Fragment{
   // se declaran las variables a utilizar 
    ListView lista1;
    Button boton;

 View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.second_layout,container,false);
        lista1 = (ListView) myView.findViewById(R.id.lista);
        ObtDatos();
        return myView;

    }

    public  void ObtDatos(){
        
        AsyncHttpClient client= new AsyncHttpClient();
        // se declara la url y llama el json 
        final String url="http://www.jcgrafficdesigns.net/Nereo/consultanereo.php";
        client.post(url, new AsyncHttpResponseHandler () {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    Item i = new Item();
                    // carga la infromacion que trae le json 
                    CargaLista(ObtdatosJSON(new String(responseBody)));

                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void CargaLista(ArrayList<String> datos){
        // se crea un array adapter para llenar los datos del json y se adaptan al listview
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,datos);
        lista1.setAdapter(adapter);
    }

    public ArrayList<String> ObtdatosJSON(String response){
        // se crea el array list  para llenar la informacion de la url 
        ArrayList<String > listado=new ArrayList<String>();
        try {
            JSONArray jsonarray=new JSONArray(response);
            String texto;
            for(int i=0;i<jsonarray.length();i++){
                texto="Código: "+jsonarray.getJSONObject(i).getString("EST_COD")+"\n \n Identificación:  "+
                        jsonarray.getJSONObject(i).getString("EST_NRO_IDEN")+"\n \n Nombre del Estudiante: "+
                        jsonarray.getJSONObject(i).getString("EST_NOMBRE")+"\n \n Carrera: "+
                        jsonarray.getJSONObject(i).getString("CODIGOCRA")+"\t - "+
                        jsonarray.getJSONObject(i).getString("CRANOM")+ "\n \n Acuerdo: "+
                        jsonarray.getJSONObject(i).getString("EST_ACUERDO")+"\n \n Número Pénsum: "+
                        jsonarray.getJSONObject(i).getString("EST_PEN_NRO")+"\n \n Tipo de Plan: "+
                        jsonarray.getJSONObject(i).getString("TIPO_PLAN")+"\n \n Correo Institucional: "+
                        jsonarray.getJSONObject(i).getString("EOT_EMAIL_INS")+"\n \n Correo Personal: "+
                        jsonarray.getJSONObject(i).getString("EOT_EMAIL")+"\n \n Tipo de Sangre: "+
                        jsonarray.getJSONObject(i).getString("EOT_TIPOSANGRE")+"\n \n RH: "+
                        jsonarray.getJSONObject(i).getString("EOT_RH");
                listado.add(texto);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return  listado;
    }
}
