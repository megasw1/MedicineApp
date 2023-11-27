package com.example.medicationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class DosageTrackingActivity extends AppCompatActivity {

    EditText editTextMedicationName, editTextDose, editTextDate;
    Button btnSaveDose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosage_tracking);

        editTextMedicationName = findViewById(R.id.editTextMedicationName);
        editTextDose = findViewById(R.id.editTextDose);
        editTextDate = findViewById(R.id.editTextDate);
        btnSaveDose = findViewById(R.id.btnSaveDose);

        btnSaveDose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDose();
            }
        });
    }

    private void saveDose() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "medication-doses").build();
        MedicationDoseDao dao = db.medicationDoseDao();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MedicationDose dose = new MedicationDose();
                dose.medicationName = editTextMedicationName.getText().toString();
                dose.dose = editTextDose.getText().toString();
                dose.date = editTextDate.getText().toString();

                dao.insert(dose);
            }
        }).start();
    }
}
