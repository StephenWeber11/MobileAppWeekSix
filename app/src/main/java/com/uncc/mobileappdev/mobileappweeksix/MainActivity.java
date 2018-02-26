package com.uncc.mobileappdev.mobileappweeksix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] colors = {"Red","Blue","Green","White","Black","Yellow"}; //Not Mutable - You cannot change the size of an array.
    Color[] colorObjects = {new Color("Red"),new Color("Blue"),new Color("Green"),new Color("Orange")};
    ArrayList<Color> myData = new ArrayList<>();

    ArrayList<Email> emails = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myData.add(new Color("Red"));
        myData.add(new Color("Blue"));
        myData.add(new Color("Green"));
        myData.add(new Color("Orange"));

        for(int i=0; i<5; i++) {
            emails.add(new Email("Hi", "This is a nice email", "Stephen Weber"));
            emails.add(new Email("Hi Again", "This is a nice email, again", "Emma Davis"));
            emails.add(new Email("Help!", "The floor is lava!", "Unknown Sender"));
        }

//        ListView listView = findViewById(R.id.listView);
//        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, colors);
//        final ArrayAdapter<Color> adapter = new ArrayAdapter<Color>(this, android.R.layout.simple_list_item_1, android.R.id.text1, myData);
//        adapter.setNotifyOnChange(true); //Used to update the ListView contents dynamically
//        //listView.setAdapter(adapter);
//
//        EmailAdapter emailAdapter = new EmailAdapter(this, R.layout.email_item, emails);
//        listView.setAdapter(emailAdapter);
//
//
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText editText = findViewById(R.id.editText);
//
//                adapter.add(new Color(editText.getText().toString()));
//                //adapter.notifyDataSetChanged(); //Alternative to setNotifyOnChange(true)
//            }
//        });
//
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Color color = adapter.getItem(position);
//                adapter.remove(color);
//                //adapter.notifyDataSetChanged();
//                return false;
//            }
//        });
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("Colors", "Clicked item: " + position + ", color: " + colors[position]);
//
//            }
//        });


        /* Recycler View */
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        //Use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new EmailRecyclerAdapter(emails);
        mRecyclerView.setAdapter(mAdapter);

    }


    static class Color{
        String name;
        int hex;

        public Color(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
    }
}
