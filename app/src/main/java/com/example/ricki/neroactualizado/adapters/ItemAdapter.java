package com.example.ricki.neroactualizado.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.ricki.neroactualizado.R;
import com.example.ricki.neroactualizado.models.Item;

/**
 * Created by Sammy on 26/07/2016.
 */
public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.itemlayout, null);
        }
        Item p = getItem(position);
        TextView tt1 = (TextView) v.findViewById(R.id.textViewNombre);
        if (tt1 != null) {
            tt1.setText(p.getNombre());
        }
        TextView tt2 = (TextView) v.findViewById(R.id.textViewAcum);
        if (tt2 != null) {
            tt2.setText(p.getAcum());
        }
        TextView tt3 = (TextView) v.findViewById(R.id.textViewDefini);
        if (tt3 != null) {
            tt3.setText(p.getDefini());
        }

        TextView tvporce1 = (TextView) v.findViewById(R.id.Porcentaje);
        if (tvporce1 != null) {
            tvporce1.setText(p.getPorce1());
        }
        TextView tvnota1 = (TextView) v.findViewById(R.id.Nota);
        if (tvnota1 != null) {
            tvnota1.setText(p.getNota1());
        }
        TextView tvporce2 = (TextView) v.findViewById(R.id.Porcentaje1);
        if (tvporce2 != null) {
            tvporce2.setText(p.getPorce2());
        }
        TextView tvnota2 = (TextView) v.findViewById(R.id.Nota1);
        if (tvnota2 != null) {
            tvnota2.setText(p.getNota2());
        }
        TextView tvporce3 = (TextView) v.findViewById(R.id.Porcentaje2);
        if (tvporce3 != null) {
            tvporce3.setText(p.getPorce3());
        }
        TextView tvnota3 = (TextView) v.findViewById(R.id.Nota2);
        if (tvnota3 != null) {
            tvnota3.setText(p.getNota3());
        }
        TextView tvporce4 = (TextView) v.findViewById(R.id.Porcentaje3);
        if (tvporce4 != null) {
            tvporce4.setText(p.getPorce4());
        }
        TextView tvnota4 = (TextView) v.findViewById(R.id.Nota3);
        if (tvnota4 != null) {
            tvnota4.setText(p.getNota4());
        }
        TextView tvporce5 = (TextView) v.findViewById(R.id.Porcentaje4);
        if (tvporce5 != null) {
            tvporce5.setText(p.getPorce5());
        }
        TextView tvnota5 = (TextView) v.findViewById(R.id.Nota4);
        if (tvnota5 != null) {
            tvnota5.setText(p.getNota5());
        }
        TextView tvporce6 = (TextView) v.findViewById(R.id.Porcentaje5);
        if (tvporce6 != null) {
            tvporce6.setText(p.getPorce6());
        }
        TextView tvnota6 = (TextView) v.findViewById(R.id.Nota5);
        if (tvnota6 != null) {
            tvnota6.setText(p.getNota6());
        }
        TextView tvporcelab = (TextView) v.findViewById(R.id.Porcentaje6);
        if (tvporcelab != null) {
            tvporcelab.setText(p.getPorcelab());
        }
        TextView tvnotalab = (TextView) v.findViewById(R.id.Nota6);
        if (tvnotalab != null) {
            tvnotalab.setText(p.getNotalab());
        }
        TextView tvporceexa = (TextView) v.findViewById(R.id.Porcentaje7);
        if (tvporceexa != null) {
            tvporceexa.setText(p.getPorceexa());
        }
        TextView tvnotaexa = (TextView) v.findViewById(R.id.Nota7);
        if (tvnotaexa != null) {
            tvnotaexa.setText(p.getNotaexa());
        }
        return v;
    }
}
