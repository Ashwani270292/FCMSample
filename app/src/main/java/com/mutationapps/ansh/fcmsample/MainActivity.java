package com.mutationapps.ansh.fcmsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.message);
        if(getIntent().getExtras() != null){
            if(getIntent().getExtras().containsKey("Message")) {
                String message = getIntent().getExtras().getString("Message");
                textView.setText(message);
            }
        }

    }
}
