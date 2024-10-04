package com.example.intent3ytres;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Intens que ponen tecto loco
        Button btnAction1 = findViewById(R.id.btnAction1);
        btnAction1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.putExtra("action", "action1");
            startActivity(intent);
        });

        Button btnAction2 = findViewById(R.id.btnAction2);
        btnAction2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.putExtra("action", "action2");
            startActivity(intent);
        });

        Button btnAction3 = findViewById(R.id.btnAction3);
        btnAction3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.putExtra("action", "action3");
            startActivity(intent);
        });

        // Verificar si se recibió alguna acción explícita en el intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("action")) {
            String action = intent.getStringExtra("action");
            performAction(action);
        }

        // Intents implícitos (Correo, llamada, ubicación, cámara, contactos, calculadora)
        Button btnEmail = findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:someone@example.com"));
            startActivity(emailIntent);
        });

        Button btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:123456789"));
            startActivity(callIntent);
        });

        Button btnLocation = findViewById(R.id.btnLocation);
        btnLocation.setOnClickListener(v -> {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW);
            mapIntent.setData(Uri.parse("geo:37.7749,-122.4194"));
            startActivity(mapIntent);
        });

        Button btnCamera = findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(cameraIntent);
        });

        Button btnContacts = findViewById(R.id.btnContacts);
        btnContacts.setOnClickListener(v -> {
            Intent contactsIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivity(contactsIntent);
        });

        Button btnCalculator = findViewById(R.id.btnCalculator);
        btnCalculator.setOnClickListener(v -> {
            Intent calcIntent = new Intent();
            calcIntent.setAction(Intent.ACTION_MAIN);
            calcIntent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
            try {
                startActivity(calcIntent);
            } catch (Exception e) {
                Toast.makeText(this, "Calculadora no encontrada", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void performAction(String action) {
        switch (action) {
            case "action1":
                textView.setText("Has realizado Accion 1");
                break;
            case "action2":
                textView.setText("Has realizado Accion 2");
                break;
            case "action3":
                textView.setText("Has realizado Accion 3");
                break;
            default:
                textView.setText("Sin acción");
                break;
        }
    }
}
