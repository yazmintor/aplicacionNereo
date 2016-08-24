package com.example.ricki.neroactualizado.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ricki.neroactualizado.R;
import com.example.ricki.neroactualizado.models.Dia;

import java.util.ArrayList;



/**
 * Created by Sammy on 6/08/2016.
 */
public class DiaAdapter extends ArrayAdapter<Dia> {
// se inicializan las variables
    private final Context contexto;
    private final ArrayList<Dia> array_dias;
    Dia diaActual;
    public DiaAdapter(Context context, ArrayList<Dia> array_dias) {
        // se hace una adaptacion  de arralist
        super(context, -1, array_dias);
        this.contexto = context;
        this.array_dias = array_dias;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutDia = inflater.inflate(R.layout.itemlayout1, parent, false);
// se hace el array para cada dia q este actual  con la posicion 
        TextView diaTextView = (TextView) layoutDia.findViewById(R.id.textViewDia);

        diaActual = array_dias.get(position);
        diaTextView.setText(diaActual.getNombredia());
        return layoutDia;
    }
}

