package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomePage extends AppCompatActivity {
    public static Button pick_me;

    protected void init(){
        setContentView(R.layout.activity_welcome_page);
        final EditText edit_text = (EditText) findViewById(R.id.edit_text);//get the id for edit text
        pick_me = (Button) findViewById(R.id.button);//get the id for button
        pick_me.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (edit_text.getText().toString() != null)//check whether the entered text is not null
                {
                    Intent toy = new Intent(WelcomePage.this,QuizActivity.class);
                    startActivity(toy);
                    Toast.makeText(getApplicationContext(), edit_text.getText().toString(), Toast.LENGTH_LONG).show();//display the text that you entered in edit text
                }
            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        init();
    }
}
