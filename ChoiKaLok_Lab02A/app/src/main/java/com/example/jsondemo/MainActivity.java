// Ref: http://www.androidhive.info/2012/01/android-json-parsing-tutorial/

package com.example.jsondemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textView1;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView1 = (TextView) findViewById(R.id.textView1);
		listView = (ListView) findViewById(R.id.listView);

//		String jsonStr = readAssetsFile("contacts.json");
//		ArrayList<Contact> arrayList = convert_Contacts_JsonToArrayList(jsonStr);

		String jsonStr = readAssetsFile("contacts.json");
		ArrayList<Contact> arrayList = convert_Contacts_JsonToArrayList(jsonStr);

		ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(
				this,
				R.layout.listview_item_row,
				R.id.txtTitle,
				arrayList
		);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Contact contact = (Contact) listView.getItemAtPosition(i);
				Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
				intent.putExtra("contactItem",contact);
				startActivity(intent);

//				textView1.setText(contact.toDetailString());
			}
		});

//		textView1.setText(arryList.get(0).toString());
	}

	private ArrayList<Contact> convert_Contacts_JsonToArrayList(String jsonStr) {
		JSONObject jsonObj;
		ArrayList<Contact> list = new ArrayList<Contact>();
		try {
			jsonObj = new JSONObject(jsonStr);
	        // Getting JSON Array node
	        JSONArray contacts = jsonObj.getJSONArray("contacts");

	        // looping through All Contacts
	        for (int i = 0; i < contacts.length(); i++) {
	            JSONObject obj = contacts.getJSONObject(i);

	            Contact contact = new Contact();
	            contact.id = obj.getString("id");
	            contact.name = obj.getString("name");
	            contact.email = obj.getString("email");
	            contact.address = obj.getString("address");
	            contact.gender = obj.getString("gender");
	            
	            JSONObject phone = obj.getJSONObject("phone");
	            contact.phoneMobile = phone.getString("mobile");
	            contact.phoneHome = phone.getString("home");
	            contact.phoneOffice = phone.getString("office");
	            
	            list.add(contact);
	        }
		} catch (JSONException e) {
		}
       
		return list;
	}
	private ArrayList<Comment> convert_Comments_JsonToArrayList(String jsonStr) {
		JSONObject jsonObj;
		ArrayList<Comment> list = new ArrayList<Comment>();
		try {
			jsonObj = new JSONObject(jsonStr);
			// Getting JSON Array node
			JSONArray comments = jsonObj.getJSONArray("comments");

			// looping through All Contacts
			for (int i = 0; i < comments.length(); i++) {
				JSONObject obj = comments.getJSONObject(i);
				Comment comment = new Comment();
				comment.id = obj.getString("id");
				comment.first_name = obj.getString("first_name");
				comment.last_name = obj.getString("last_name");
				comment.email = obj.getString("email");
				comment.comment = obj.getString("comment");
				comment.dtime = obj.getString("dtime");

				list.add(comment);
			}
		} catch (JSONException e) {
		}

		return list;
	}

	// Examples for pathAndName:
	// data/contacts.json <--- saved in "data" sub-folder
	// contacts <--- saved in assets folder
	// ref: http://android.okhelp.cz/get-assets-folder-path-and-read-txt-file-to-string-android-example-code/
	public String readAssetsFile(String pathAndName) {
		try {
			InputStream  input = getAssets().open(pathAndName);
	        int size = input.available();
	        byte[] buffer = new byte[size];
	        input.read(buffer);
	        input.close();
	        // Convert byte array to a string
	        String text = new String(buffer);
	        return text;
		} catch (IOException e) {
			return "";
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
