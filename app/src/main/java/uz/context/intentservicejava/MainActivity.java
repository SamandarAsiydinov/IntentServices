package uz.context.intentservicejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import uz.context.intentservicejava.servises.ExampleIntentService;
import uz.context.intentservicejava.servises.ExampleJobIntentService;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnStartService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();

    }
    private void initViews() {
        editText = findViewById(R.id.editInput);
        btnStartService = findViewById(R.id.btnStartService);

        btnStartService.setOnClickListener(view -> {
            enqueueWork();
        });
    }

    private void enqueueWork() {
        String input = editText.getText().toString().trim();
        Intent serviceIntent = new Intent(this, ExampleJobIntentService.class);
        serviceIntent.putExtra("inputExtra",input);

        ExampleJobIntentService.enqueueWork(this,serviceIntent);
    }
}
    /*
    private void startService(){
        String input = editText.getText().toString().trim();

        Intent serviceIntent = new Intent(this, ExampleIntentService.class);
        serviceIntent.putExtra("inputExtra",input);

        ContextCompat.startForegroundService(this,serviceIntent);
    }
}

     */