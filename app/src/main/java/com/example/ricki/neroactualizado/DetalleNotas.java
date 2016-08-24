package com.example.ricki.neroactualizado;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ricki.neroactualizado.models.Item;

/**
 * Created by ricki on 31/07/2016.
 */

public class DetalleNotas extends Activity {

    TextView tvasignatura, porce1, nota1, porce2, nota2, porce3, nota3, porce4, nota4, porce5,
            nota5, porce6, nota6, porcelab, notalab, porceexa, notaexa;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallenotas);

        inicializar();
        mostrarDetalle();
    }

    private void inicializar(){
        tvasignatura = (TextView) findViewById(R.id.textViewAsigna);
        porce1 = (TextView) findViewById(R.id.Porcentaje);
        nota1 = (TextView)findViewById(R.id.Nota);
        porce2 = (TextView)findViewById(R.id.Porcentaje1);
        nota2 = (TextView) findViewById(R.id.Nota1);
        porce3 = (TextView)findViewById(R.id.Porcentaje2);
        nota3 = (TextView) findViewById(R.id.Nota2);
        porce4 = (TextView)findViewById(R.id.Porcentaje3);
        nota4 = (TextView) findViewById(R.id.Nota3);
        porce5 = (TextView)findViewById(R.id.Porcentaje4);
        nota5 = (TextView) findViewById(R.id.Nota4);
        porce6 = (TextView)findViewById(R.id.Porcentaje5);
        nota6 = (TextView) findViewById(R.id.Nota5);
        porcelab = (TextView)findViewById(R.id.Porcentaje6);
        notalab = (TextView) findViewById(R.id.Nota6);
        porceexa = (TextView)findViewById(R.id.Porcentaje7);
        notaexa = (TextView) findViewById(R.id.Nota7);
    }

    private void mostrarDetalle(){
        tvasignatura.setText(recogerParametro());
        porce1.setText(recogerParametroPorce1());
        nota1.setText(recogerParametroNota1());
        porce2.setText(recogerParametroPorce2());
        nota2.setText(recogerParametroNota2());
        porce3.setText(recogerParametroPorce3());
        nota3.setText(recogerParametroNota3());
        porce4.setText(recogerParametroPorce4());
        nota4.setText(recogerParametroNota4());
        porce5.setText(recogerParametroPorce5());
        nota5.setText(recogerParametroNota5());
        porce6.setText(recogerParametroPorce6());
        nota6.setText(recogerParametroNota6());
        porcelab.setText(recogerParametroPorcelab());
        notalab.setText(recogerParametroNotalab());
        porceexa.setText(recogerParametroPorceexa());
        notaexa.setText(recogerParametroNotaexa());
    }

    private String recogerParametro(){

        Item detalleNotas;
        detalleNotas = (Item)getIntent().getExtras().getSerializable("parametro");
        return detalleNotas.getNombre();
    }
    private String recogerParametroPorce1(){

        Item detallePorce1;
        detallePorce1= (Item)getIntent().getExtras().getSerializable("porce1");
        return detallePorce1.getPorce1();
    }
    private String recogerParametroNota1(){

        Item detalleNota1;
        detalleNota1= (Item)getIntent().getExtras().getSerializable("nota1");
        return detalleNota1.getNota1();
    }
    private String recogerParametroPorce2(){

        Item detallePorce2;
        detallePorce2= (Item)getIntent().getExtras().getSerializable("porce2");
        return detallePorce2.getPorce2();
    }
    private String recogerParametroNota2(){

        Item detalleNota2;
        detalleNota2= (Item)getIntent().getExtras().getSerializable("nota2");
        return detalleNota2.getNota2();
    }
    private String recogerParametroPorce3(){

        Item detallePorce3;
        detallePorce3= (Item)getIntent().getExtras().getSerializable("porce3");
        return detallePorce3.getPorce3();
    }
    private String recogerParametroNota3(){

        Item detalleNota3;
        detalleNota3= (Item)getIntent().getExtras().getSerializable("nota3");
        return detalleNota3.getNota3();
    }
    private String recogerParametroPorce4(){

        Item detallePorce4;
        detallePorce4= (Item)getIntent().getExtras().getSerializable("porce4");
        return detallePorce4.getPorce4();
    }
    private String recogerParametroNota4(){

        Item detalleNota4;
        detalleNota4= (Item)getIntent().getExtras().getSerializable("nota4");
        return detalleNota4.getNota4();
    }
    private String recogerParametroPorce5(){

        Item detallePorce5;
        detallePorce5= (Item)getIntent().getExtras().getSerializable("porce5");
        return detallePorce5.getPorce5();
    }
    private String recogerParametroNota5(){

        Item detalleNota5;
        detalleNota5= (Item)getIntent().getExtras().getSerializable("nota5");
        return detalleNota5.getNota5();
    }
    private String recogerParametroPorce6(){

        Item detallePorce6;
        detallePorce6= (Item)getIntent().getExtras().getSerializable("porce6");
        return detallePorce6.getPorce6();
    }
    private String recogerParametroNota6(){

        Item detalleNota6;
        detalleNota6= (Item)getIntent().getExtras().getSerializable("nota6");
        return detalleNota6.getNota6();
    }
    private String recogerParametroPorcelab(){

        Item detallePorcelab;
        detallePorcelab= (Item)getIntent().getExtras().getSerializable("porcelab");
        return detallePorcelab.getPorcelab();
    }
    private String recogerParametroNotalab(){

        Item detalleNotalab;
        detalleNotalab= (Item)getIntent().getExtras().getSerializable("notalab");
        return detalleNotalab.getNotalab();
    }
    private String recogerParametroPorceexa(){

        Item detallePorceexa;
        detallePorceexa= (Item)getIntent().getExtras().getSerializable("porceexa");
        return detallePorceexa.getPorceexa();
    }
    private String recogerParametroNotaexa(){

        Item detalleNotaexa;
        detalleNotaexa= (Item)getIntent().getExtras().getSerializable("notaexa");
        return detalleNotaexa.getNotaexa();
    }
}