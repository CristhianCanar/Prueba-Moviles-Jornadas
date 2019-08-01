package com.senasoft.jornadatres.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.senasoft.jornadatres.R;

import java.util.ArrayList;

public class AdapterItemSoap extends BaseAdapter {

    Context context;
    ArrayList<Vehicle> list;

    public AdapterItemSoap(Context context, ArrayList<Vehicle> list) {
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


        TextView txtMarca, txtPlaca, txtSoap;

        view = LayoutInflater.from(context).inflate(R.layout.item_main_1, viewGroup, false);

        txtMarca = view.findViewById(R.id.textMarcaItem);
        txtPlaca =  view.findViewById(R.id.textPlacaItem);
        txtSoap = view.findViewById(R.id.textRenovacionItem);


        txtMarca.setText(list.get(i).getMarcaVehicle());
        txtPlaca.setText(list.get(i).getPlacaVehicle());
        txtSoap.setText(list.get(i).getFechaSoatVehicle());

        return view;
    }
}
