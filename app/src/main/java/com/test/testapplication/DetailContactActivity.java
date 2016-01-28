package com.test.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.test.testapplication.model.Seeder;

public class DetailContactActivity extends AppCompatActivity {

    EditText et_contact;
    EditText et_email;
    EditText et_phone;
    Button btn_update;
    Button btn_delete;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();

        et_contact = (EditText)findViewById(R.id.et_contact);
        et_email = (EditText)findViewById(R.id.et_email);
        et_phone = (EditText)findViewById(R.id.et_phone);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_delete = (Button) findViewById(R.id.btn_delete);

        et_contact.setText(i.getExtras().getString("name"));
        et_email.setText(i.getExtras().getString("email"));
        et_phone.setText(i.getExtras().getString("phone"));

        position = i.getExtras().getInt("position");


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Seeder.arrayContacts.get(position).setName(et_contact.getText().toString());
                Seeder.arrayContacts.get(position).setEmail(et_email.getText().toString());
                Seeder.arrayContacts.get(position).setPhone(et_phone.getText().toString());

                finish();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Seeder.arrayContacts.remove(position);
                finish();
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
}
