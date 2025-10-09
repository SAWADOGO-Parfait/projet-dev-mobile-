package com.example.direction;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.direction.data.local.database.entities.Agent;
// Supprimer l'import de StatutOccupation si vous utilisez String

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
    }

    private void initializeUI() {
        TextView title = findViewById(R.id.textView);
        Button btnTest = findViewById(R.id.btn_test);
        TextView tvStatus = findViewById(R.id.tv_status);

        title.setText("Direction Prospective MARAH");

        btnTest.setOnClickListener(v -> {
            testDatabaseOperations();
        });
    }

    private void testDatabaseOperations() {
        // Créer un agent de test avec String pour le statut
        Agent agent = new Agent();
        agent.setNomComplet("Jean Dupont");
        agent.setService("Service de la Prospective");
        agent.setFonction("Chargé d'études");
        agent.setJourSemaine("Lundi");
        agent.setDateArrivee(new Date());
        agent.setStatut("DISPONIBLE"); // Utiliser String directement

        Toast.makeText(this, "Agent créé: " + agent.getNomComplet(), Toast.LENGTH_SHORT).show();
        // Note: Vous devrez implémenter l'insertion dans la base plus tard
    }
}