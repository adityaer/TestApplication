package com.test.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.test.testapplication.adapter.ListAdapter;
import com.test.testapplication.model.Contact;
import com.test.testapplication.model.Seeder;

import java.util.ArrayList;

public class ListContactActivity extends AppCompatActivity {

    ListView lv_test;
    ArrayList<Contact> contacts;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_test = (ListView) findViewById(R.id.lv_test);
        Seeder seed = new Seeder();
        contacts =  new ArrayList<Contact>();
        contacts = seed.getContacts();
        adapter = new ListAdapter(this,contacts);
        lv_test.setAdapter(adapter);

        lv_test.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListContactActivity.this, DetailContactActivity.class);
                intent.putExtra("name",contacts.get(i).getName());
                intent.putExtra("email",contacts.get(i).getEmail());
                intent.putExtra("phone",contacts.get(i).getPhone());
                intent.putExtra("position",i);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
