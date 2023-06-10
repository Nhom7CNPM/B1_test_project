package com.example.project_b1_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MeoAdapter  extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Meo> meoList;

    public MeoAdapter(Context context, int layout, List<Meo> meoList) {
        this.context = context;
        this.layout = layout;
        this.meoList = meoList;
    }

    @Override
    public int getCount() {
        return meoList.size();
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
        TextView txttenmeo=(TextView) view.findViewById(R.id.texttenmeo);
        TextView txtnoidung=(TextView) view.findViewById(R.id.textnoidung);
        Meo Meo=meoList.get(i);
        txttenmeo.setText(Meo.getTenmeo());
        txtnoidung.setText(Meo.getNoidung());
        return view;
    }
}
