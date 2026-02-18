package com.example.lab3_resolution;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Références vers les champs du formulaire
    private EditText fieldFullName, fieldEmail, fieldPhone, fieldStreet, fieldCity;

    // Référence vers le bouton d'envoi
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // onCreate est appelé au démarrage de l'écran
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // association avec le XML

        // Liaison des variables aux composants définis dans le XML
        fieldFullName = findViewById(R.id.fieldFullName);
        fieldEmail    = findViewById(R.id.fieldEmail);
        fieldPhone    = findViewById(R.id.fieldPhone);
        fieldStreet   = findViewById(R.id.fieldStreet);
        fieldCity     = findViewById(R.id.fieldCity);
        btnSend       = findViewById(R.id.btnSend);

        // Écoute du clic sur le bouton Envoyer
        btnSend.setOnClickListener(v -> {

            // Lecture et nettoyage du texte saisi dans chaque champ
            String inputName    = fieldFullName.getText().toString().trim();
            String inputEmail   = fieldEmail.getText().toString().trim();
            String inputPhone   = fieldPhone.getText().toString().trim();
            String inputStreet  = fieldStreet.getText().toString().trim();
            String inputCity    = fieldCity.getText().toString().trim();

            // Vérification : nom et e-mail sont obligatoires
            if (inputName.isEmpty() || inputEmail.isEmpty()) {
                Toast.makeText(this, "Le nom et l'e-mail sont obligatoires.", Toast.LENGTH_SHORT).show();
                return; // on stoppe si les champs requis sont vides
            }

            // Création d'un Intent explicite vers Screen2Activity
            Intent intent = new Intent(MainActivity.this, Screen2Activity.class);

            // Transmission des données sous forme de paires clé / valeur
            intent.putExtra("KEY_NAME",   inputName);
            intent.putExtra("KEY_EMAIL",  inputEmail);
            intent.putExtra("KEY_PHONE",  inputPhone);
            intent.putExtra("KEY_STREET", inputStreet);
            intent.putExtra("KEY_CITY",   inputCity);

            // Lancement de l'écran de récapitulatif
            startActivity(intent);
        });
    }
}