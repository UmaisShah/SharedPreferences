package com.sam.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String MESSAGE_ID = "msg_prefs";
    TextView display;
    EditText message;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save=findViewById(R.id.button_message);
        message=findViewById(R.id.message);
        display=findViewById(R.id.message_display);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messages=message.getText().toString();
                SharedPreferences sharedPreferences=getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("message",messages);
                editor.apply();

            }
        });

        SharedPreferences preferences=getPreferences(MODE_PRIVATE);
        String data=preferences.getString("message","default");
        display.setText(data);
    }
}