package com.example.gmail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    List<ItemEmailModel> items;

    public ItemAdapter(List<ItemEmailModel> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);

        ImageView imgAvatar = view.findViewById(R.id.avatar);
        TextView textName = view.findViewById(R.id.name);
        TextView textContent = view.findViewById(R.id.content);
        TextView textTime = view.findViewById(R.id.time);

        ItemEmailModel item = items.get(i);

        imgAvatar.setImageResource(item.getAvtResource());
        textName.setText(item.getName());
        textContent.setText(item.getContent());
        textTime.setText(item.getTime());

        return view;
    }
}
