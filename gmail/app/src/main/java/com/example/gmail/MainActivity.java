package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemEmailModel> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        items = new ArrayList<>();
        items.add(new ItemEmailModel(R.drawable.obito, "Hoang Anh Nguyen", "assignment for Android", "5:39 PM"));
        items.add(new ItemEmailModel(R.drawable.obito, "Hoang Anh Nguyen", "assignment for Android", "5:38 PM"));
        items.add(new ItemEmailModel(R.drawable.obito, "Hoang Anh Nguyen", "assignment for Android", "5:37 PM"));
        items.add(new ItemEmailModel(R.drawable.obito, "Hoang Anh Nguyen", "assignment for Android", "5:36 PM"));
        items.add(new ItemEmailModel(R.drawable.obito, "Hoang Anh Nguyen", "assignment for Android", "5:35 PM"));
        items.add(new ItemEmailModel(R.drawable.obito, "Hoang Anh Nguyen", "assignment for Android", "5:34 PM"));
        items.add(new ItemEmailModel(R.drawable.obito, "Hoang Anh Nguyen", "assignment for Android", "5:33 PM"));
        items.add(new ItemEmailModel(R.drawable.obito, "Hoang Anh Nguyen", "assignment for Android", "5:32 PM"));
        items.add(new ItemEmailModel(R.drawable.obito, "Hoang Anh Nguyen", "assignment for Android", "5:31 PM"));
        items.add(new ItemEmailModel(R.drawable.obito, "Hoang Anh Nguyen", "assignment for Android", "5:30 PM"));
        ItemAdapter adapter = new ItemAdapter(items);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

}