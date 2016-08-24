package com.example.ricki.neroactualizado.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ricki.neroactualizado.R;

import com.example.ricki.neroactualizado.ThirdFragment;
import com.example.ricki.neroactualizado.models.Dia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sammy on 26/07/2016.
 */
public class ItemAdapterDia extends ArrayAdapter<Dia> {

    public ItemAdapterDia(Context context, int resource, List<Dia> objects) {
        super(context, resource, objects);
        DiaAdapter di = new DiaAdapter(context, (ArrayList<Dia>) objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.itemlayout1, null);
        }
        Dia p = getItem(position);

        TextView dia = (TextView) v.findViewById(R.id.textViewNombredia);

        if (dia != null ) {
            dia.setText(p.getNombredia ());
        }

        TextView asignat = (TextView) v.findViewById(R.id.TextViewAsignatura);

        if (asignat != null  ) {
            asignat.setText(p.getNomasig());
        }
        TextView grupo = (TextView) v.findViewById(R.id.textViewGrupo);

        if (grupo != null  ) {
            grupo.setText(p.getGrupocod ());
        }

        TextView hora = (TextView) v.findViewById(R.id.textViewHora);

        if (hora != null  ) {
            hora.setText(p.getHora ());
        }

        TextView sede = (TextView) v.findViewById(R.id.textViewSede);

        if (sede != null  ) {
            sede.setText(p.getSedenombre ());
        }
        TextView edificio = (TextView) v.findViewById(R.id.textViewEdificio);

        if (edificio != null  ) {
            edificio.setText(p.getEdinombre ());
        }
        TextView salon = (TextView) v.findViewById(R.id.textViewSalon);

        if (salon != null  ) {
            salon.setText(p.getSalnombre ());
        }
        TextView docente = (TextView) v.findViewById(R.id.textViewDocente);

        if (docente != null  ) {
            docente.setText(p.getDocente ());
        }
        return v;
    }
}