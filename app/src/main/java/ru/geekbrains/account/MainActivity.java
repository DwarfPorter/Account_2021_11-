package ru.geekbrains.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        Button bthGreeting = findViewById(R.id.btnGreetings);
        EditText txtName = findViewById(R.id.textName);
        TextView txtHello = findViewById(R.id.textHello);
        bthGreeting.setOnClickListener(view -> {
            String name = txtName.getText().toString();
            String sayHello = getString(R.string.say_hello) + name;
            txtHello.setText(sayHello);
        });

        Button btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(view -> {
            Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(runSettings);
        });
    }
}