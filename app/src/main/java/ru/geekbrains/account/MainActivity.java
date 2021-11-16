package ru.geekbrains.account;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Constants {

    private Button bthGreeting;
    private EditText txtName;
    private TextView txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        bthGreeting = findViewById(R.id.btnGreetings);
        txtName = findViewById(R.id.textName);
        txtHello = findViewById(R.id.textHello);
        bthGreeting.setOnClickListener(view -> {
            String name = txtName.getText().toString();
            String sayHello = getString(R.string.say_hello) + name;
            txtHello.setText(sayHello);
        });

        Button btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(view -> {
            Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
            runSettings.putExtra(YOUR_NAME, txtName.getText().toString());
            startActivity(runSettings);
        });
    }
}