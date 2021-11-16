package ru.geekbrains.account;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Constants {

    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;

    private Button bthGreeting;
    private EditText txtName;
    private TextView txtHello;

    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account = new Account();
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
            populateAccount();
            openSettingsActivityForResult();
        });
    }

    private void openSettingsActivityForResult(){
        Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
        runSettings.putExtra(YOUR_ACCOUNT, account);
        someActivityResultLauncher.launch(runSettings);
    }

    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        setSettingsResult(data);
                    }
                }
            });

    private void setSettingsResult(Intent data) {
        account = data.getParcelableExtra(YOUR_ACCOUNT);
        populateViews();
    }

    private void populateViews() {
        txtName.setText(account.getName());
    }

    private void populateAccount(){
        account.setName(txtName.getText().toString());
    }
}