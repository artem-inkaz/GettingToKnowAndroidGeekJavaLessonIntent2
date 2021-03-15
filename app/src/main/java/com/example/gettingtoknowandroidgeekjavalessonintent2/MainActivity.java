package com.example.gettingtoknowandroidgeekjavalessonintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final static String SEND_DATA_TO_OTHER_APP = "SEND_DATA_TO_OTHER_APP";
    private EditText numberField_settings;   // поле для ввода числа

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberField_settings = findViewById(R.id.edit_text_input_setting);

        findViewById(R.id.button__send_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("example://intent");
                Intent runEchoIntent = new Intent(Intent.ACTION_VIEW, uri);
                if (numberField_settings.length() != 0) {
                    runEchoIntent.putExtra(SEND_DATA_TO_OTHER_APP, numberField_settings.getText().toString());
                }
                ActivityInfo activityInfo =runEchoIntent.resolveActivityInfo(getPackageManager(), runEchoIntent.getFlags());
                if (activityInfo != null) {
                    startActivity(runEchoIntent);
                }
            }
        });
    }
}