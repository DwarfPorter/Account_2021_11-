package ru.geekbrains.account;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        EditText editName = findViewById(R.id.editName);
        String text = getIntent().getExtras().getString(YOUR_NAME);
        editName.setText(text);

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(view -> {
            finish();
        });
    }
}