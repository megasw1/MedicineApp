package com.example.medicationapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MedicationDose {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String medicationName;
    public String dose;
    public String date; // "YYYY-MM-DD" 형식을 사용
}
