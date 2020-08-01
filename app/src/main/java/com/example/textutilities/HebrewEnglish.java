package com.example.textutilities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class HebrewEnglish extends AppCompatActivity {
    private Map<Character,Character> ewmap;
    private Map<Character,Character> wemap;
    private boolean hebrew;
    EditText text;
    Button swapButton;
    Button clearButton;
    Button engButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hebrew_english);

    Character[] eKeys = {'`','1','2','3','4','5','6','7','8','9','0','-','=','q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l',';',39,'z','x','c','v','b','n','m',',','.','/',};
    Character[] hwKeys = {';','1','2','3','4','5','6','7','8','9','0','-','=','/',39,'ק','ר','א','ט','ו','ן','ם','פ','ש','ד','ג','כ','ע','י','ח','ל','ך','ף',',','ז','ס','ב','ה','נ','מ','צ','ת','ץ','.'};
    ewmap = new HashMap<Character,Character>();
    wemap = new HashMap<Character,Character> ();
        for (int i = 0; i <eKeys.length ; i++) {
        ewmap.put(eKeys[i],hwKeys[i]);
        wemap.put(hwKeys[i],eKeys[i]);
    }
    text= (EditText) findViewById(R.id.editText);
    swapButton = (Button) findViewById(R.id.swapButton);
    clearButton=(Button) findViewById(R.id.clearButtonHE);
    engButton = (Button) findViewById(R.id.changeLanguageButton);


        clearButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            text.setText("");
        }
    });
        engButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            hebrew=!hebrew;
            engButton.setText(hebrew? "hebrew":"english");
        }
    });
        swapButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String string = text.getText().toString();
            String swopedText = hebrew? Swap(string,wemap):Swap(string,ewmap);
            text.setText(swopedText);
        }
    });
}
    private static String Swap (String string, Map<Character,Character> map){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <string.length() ; i++) {
            result.append(map.getOrDefault(string.charAt(i),string.charAt(i)));
        }
        return result.toString();
    }
}