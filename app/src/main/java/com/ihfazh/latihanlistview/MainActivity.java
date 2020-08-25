package com.ihfazh.latihanlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;

    private PahlawanAdapter adapter;

    private ArrayList<Pahlawan> pahlawanArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new PahlawanAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, pahlawanArrayList.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        prepare();
        addItems();


    }

    private void addItems() {
        pahlawanArrayList = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            Pahlawan pahlawan = new Pahlawan();
            pahlawan.setDescription(dataDescription[i]);
            pahlawan.setName(dataName[i]);
            pahlawan.setPhoto(dataPhoto.getResourceId(i, -i));
            pahlawanArrayList.add(pahlawan);
        }

        adapter.setPahlawanArrayList(pahlawanArrayList);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
}