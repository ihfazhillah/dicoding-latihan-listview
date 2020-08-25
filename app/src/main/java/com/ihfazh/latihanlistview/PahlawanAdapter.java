package com.ihfazh.latihanlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PahlawanAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pahlawan> pahlawanArrayList = new ArrayList<>();

    public PahlawanAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return pahlawanArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return pahlawanArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        Pahlawan pahlawan = (Pahlawan) getItem(i);
        viewHolder.bind(pahlawan);

        return itemView;
    }

    public void setPahlawanArrayList(ArrayList<Pahlawan> pahlawanArrayList) {
        this.pahlawanArrayList = pahlawanArrayList;
    }

    private class ViewHolder {
        private CircleImageView photo;
        private TextView name, description;

        public ViewHolder(View itemView) {
            photo = itemView.findViewById(R.id.img_hero);
            name = itemView.findViewById(R.id.txt_name);
            description = itemView.findViewById(R.id.txt_description);
        }

        public void bind(Pahlawan pahlawan) {
            photo.setImageResource(pahlawan.getPhoto());
            name.setText(pahlawan.getName());
            description.setText(pahlawan.getDescription());
        }
    }
}
