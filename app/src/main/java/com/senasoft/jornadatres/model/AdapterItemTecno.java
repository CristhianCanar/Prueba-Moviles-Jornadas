package com.senasoft.jornadatres.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.senasoft.jornadatres.R;

import java.util.ArrayList;

public class AdapterItemTecno extends BaseAdapter {

    Context context;
    ArrayList<Vehicle> list;

    public AdapterItemTecno(Context context, ArrayList<Vehicle> list) {
        this.context = context;
        this.list = new ArrayList<>(list);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView txtMarca, txtPlaca, txtTecno;

        view = LayoutInflater.from(context).inflate(R.layout.item_main_2, viewGroup, false);


        txtMarca = view.findViewById(R.id.textMarcaItem2);
        txtPlaca = view.findViewById(R.id.textPlacaItem2);
        txtTecno = view.findViewById(R.id.textTecno);

        txtMarca.setText(list.get(i).getMarcaVehicle());
        txtPlaca.setText(list.get(i).getPlacaVehicle());
        txtTecno.setText(list.get(i).getFechaSoatVehicle()); // Aqui hay que hacer el calculo de la fecha

        return view;
    }
}
