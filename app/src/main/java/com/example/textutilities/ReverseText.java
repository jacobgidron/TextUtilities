package com.example.textutilities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class ReverseText extends AppCompatActivity {
    EditText text;
    Button reverseButton;
    Button clearButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_text);

        text = (EditText) findViewById(R.id.editTextTextMultiLine);
        reverseButton =(Button) findViewById(R.id.reverseButton);
        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(reverse(text.getText().toString()));
            }
        });
        clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
            }
        });
    }
    private static String reverse (String string){
        StringBuilder reversed = new StringBuilder();

        for (int i = string.length()-1; i >=0 ; i--) {
            reversed.append(string.charAt(i));
        }
        return reversed.toString();
    }
}