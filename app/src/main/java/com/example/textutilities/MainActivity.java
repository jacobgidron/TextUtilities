package com.example.textutilities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    ListView mainListView;
    String[] functions;
    String[] descriptions;

    private static final int REVERSE_TEXT=0;
    private static final int HEBREW_ENGLISH_JIBRISH = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        mainListView = findViewById(R.id.MainListView);
        functions = res.getStringArray(R.array.functions);
        descriptions = res.getStringArray(R.array.descriptions);

        ItemsAdapter itemsAdapter = new ItemsAdapter(this , functions , descriptions);
        mainListView.setAdapter(itemsAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case REVERSE_TEXT:
                        Intent  showDetailActivity = new Intent(getApplicationContext(),ReverseText.class);
                        startActivity(showDetailActivity);
                        break;
                    case HEBREW_ENGLISH_JIBRISH:
                        Intent  showDetailActivity1 = new Intent(getApplicationContext(),HebrewEnglish.class);
                        startActivity(showDetailActivity1);
                        break;
                }


            }
        });
    }
}