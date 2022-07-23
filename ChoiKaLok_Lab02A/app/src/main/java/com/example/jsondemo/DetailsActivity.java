package com.example.jsondemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Button backBtn = (Button) findViewById(R.id.btnBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView id = (TextView) findViewById(R.id.tvId);
        TextView name = (TextView) findViewById(R.id.tvName);
        TextView email = (TextView) findViewById(R.id.tvEmail);
        TextView address = (TextView) findViewById(R.id.tvAddress);
        TextView gender = (TextView) findViewById(R.id.tvGender);
        TextView phoneMobile = (TextView) findViewById(R.id.tvPhoneMobile);
        TextView phoneHome = (TextView) findViewById(R.id.tvPhoneHome);
        TextView phoneOffice = (TextView) findViewById(R.id.tvPhoneOffice);
        Contact contact = (Contact) getIntent().getSerializableExtra("contactItem");

        if(contact != null){
            id.setText(contact.id);
            name.setText(contact.name);
            email.setText(contact.email);
            address.setText(contact.address);
            gender.setText(contact.gender);
            phoneMobile.setText(contact.phoneMobile);
            phoneHome.setText(contact.phoneHome);
            phoneOffice.setText(contact.phoneOffice);
        }
    }
}