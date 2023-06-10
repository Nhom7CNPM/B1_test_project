package com.example.project_b1_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CautrucAdapter extends BaseAdapter  {
    private Context context;
    private int layout;
    private List<Cautruc> cautrucList;

    public CautrucAdapter(Context context, int layout, List<Cautruc> cautrucList) {
        this.context = context;
        this.layout = layout;
        this.cautrucList = cautrucList;
    }


    @Override
    public int getCount() {
        return cautrucList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =inflater.inflate(layout, null);
        TextView txttenct=(TextView) view.findViewById(R.id.texttenmeo);
        TextView txtnoidungct=(TextView) view.findViewById(R.id.textnoidung);
        Cautruc Cautruc=cautrucList.get(i);
        txttenct.setText(Cautruc.getTenct());
        txtnoidungct.setText(Cautruc.getNoidungct());
        return view;
    }

}
