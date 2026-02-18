package com.example.lab3_resolution;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class Screen2Activity extends AppCompatActivity {

    private TextView tvSummary;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        tvSummary = findViewById(R.id.tvSummary);
        btnBack   = findViewById(R.id.btnBack);

        // Récupération de l'Intent qui a ouvert cet écran
        Intent intent = getIntent();

        // Extraction des valeurs envoyées depuis MainActivity
        String name   = intent.getStringExtra("KEY_NAME");
        String email  = intent.getStringExtra("KEY_EMAIL");
        String phone  = intent.getStringExtra("KEY_PHONE");
        String street = intent.getStringExtra("KEY_STREET");
        String city   = intent.getStringExtra("KEY_CITY");

        // Construction du texte récapitulatif affiché à l'écran
        String summary = "Nom : "     + display(name)   +
                "\nEmail : " + display(email)  +
                "\nTél : "   + display(phone)  +
                "\nRue : "   + display(street) +
                "\nVille : " + display(city);

        tvSummary.setText(summary);

        // Ferme cet écran et retourne automatiquement au précédent
        btnBack.setOnClickListener(v -> finish());
    }

    // Retourne la valeur si elle est renseignée, sinon affiche "—"
    private String display(String value) {
        return (value == null || value.trim().isEmpty()) ? "—" : value.trim();
    }
}