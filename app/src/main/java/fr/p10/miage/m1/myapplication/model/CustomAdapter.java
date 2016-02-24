package fr.p10.miage.m1.myapplication.model;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


import java.util.List;

import fr.p10.miage.m1.myapplication.R;


public class CustomAdapter extends ArrayAdapter {
    List <ToDo> modelItems = null;
    Context context;

    public CustomAdapter(Context context, List<ToDo> resource) {
        super(context, R.layout.list, resource);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.modelItems = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.list, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.to_do_txt);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox);
        TextView date =(TextView) convertView.findViewById(R.id.date);
        name.setText(modelItems.get(position).getName());
        date.setText(modelItems.get(position).getDate());

        if (modelItems.get(position).getValue() == 1)
        {
            cb.setChecked(true);
        }
        else
        {
            cb.setChecked(false);

        }
        return convertView;
    }
}


