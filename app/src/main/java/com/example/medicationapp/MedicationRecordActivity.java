package com.example.medicationapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.List;

public class MedicationRecordActivity extends AppCompatActivity {

    ListView listViewRecords;
    List<String> recordsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_record);

        listViewRecords = findViewById(R.id.listViewRecords);
        loadMedicationRecords();
    }

    private void loadMedicationRecords() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "medication-doses").build();
        MedicationDoseDao dao = db.medicationDoseDao();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<MedicationDose> doses = dao.getAllDoses();
                for (MedicationDose dose : doses) {
                    recordsList.add(dose.medicationName + " - " + dose.dose + " - " + dose.date);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(MedicationRecordActivity.this,
                                android.R.layout.simple_list_item_1, recordsList);
                        listViewRecords.setAdapter(adapter);
                    }
                });
            }
        }).start();
    }
}
