package com.example.ricki.neroactualizado.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ricki.neroactualizado.R;
import com.example.ricki.neroactualizado.models.Noticias;

import java.util.List;

/**
 * Created by Sammy on 27/08/2016.
 */
public class ItemAdapterNoticia extends ArrayAdapter<Noticias> {

    public ItemAdapterNoticia(Context context, int resource, List<Noticias> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View noti = convertView;

        if (noti == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            noti = vi.inflate(R.layout.first_layout, null);
        }
        Noticias n = getItem(position);

        TextView tv1 = (TextView) noti.findViewById(R.id.NombreNoti);
        if (tv1 != null) {
            tv1.setText(n.getNombrenoti());
        }

        TextView tv2 = (TextView) noti.findViewById(R.id.descripcion);
        if (tv2 != null) {
            tv2.setText(n.getDescripcion());
        }
       TextView tv3 = (TextView) noti.findViewById(R.id.enlace);
        if (tv3 != null) {
            tv3.setText(n.getEnlace());
        }

        TextView tv4 = (TextView) noti.findViewById(R.id.fecha_publica);
        if (tv4 != null) {
            tv4.setText(n.getFecha_radica());
        }
        ImageView img = (ImageView) noti.findViewById(R.id.imagen);
        if (img != null) {
            img.setImageResource(convertirRutaEnId(n.getImagen()));
        }
        return noti;
    }

    private int convertirRutaEnId(String imagen) {
        Context context = getContext();
        return context.getResources()
                .getIdentifier(imagen, "drawable", context.getPackageName());
    }

}

