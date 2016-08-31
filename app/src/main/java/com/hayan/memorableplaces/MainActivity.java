package com.hayan.memorableplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.memorablePlacesList);

        final ArrayList<String> addressList = new ArrayList<>();
        addressList.add("Add a new place...");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, addressList);
        listView.setAdapter(adapter);

        for (int i = 0 ; i < MapsActivity.getAddressArray().size() ; i++){
            addressList.add(MapsActivity.getAddressArray().get(i));
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    i = new Intent(getApplicationContext(),MapsActivity.class);
                    i.putExtra("position", position);
                    startActivity(i);
            }
        });
    }
}