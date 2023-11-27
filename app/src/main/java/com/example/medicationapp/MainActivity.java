package com.example.medicationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMedicationReminder = findViewById(R.id.btnMedicationReminder);
        Button btnDosageTracking = findViewById(R.id.btnDosageTracking);
        Button btnMedicationRecord = findViewById(R.id.btnMedicationRecord);
        Button btnPharmacyLocator = findViewById(R.id.btnPharmacyLocator);
        Button btnQRScanner = findViewById(R.id.btnQRScanner);

        btnMedicationReminder.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, com.example.medicationapp.MedicationReminderActivity.class)));
        btnDosageTracking.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DosageTrackingActivity.class)));
        btnMedicationRecord.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MedicationRecordActivity.class)));
        btnPharmacyLocator.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PharmacyLocatorActivity.class)));
        btnQRScanner.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, QRScannerActivity.class)));
    }
}
