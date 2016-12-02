package com.developer.janna.jannachat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * Created by janna on 01/12/2016.
 */

public class MainActivity extends Activity{

    Button buttonChat;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.info_evento);

        buttonChat = (Button) findViewById(R.id.button_chat);
        // Capture button clicks
        buttonChat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        ChatActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public void onClick(View v) {
        buttonChat.setText("JOINED!");
    }


}


