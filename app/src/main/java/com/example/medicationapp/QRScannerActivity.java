package com.example.medicationapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRScannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscanner);

        new IntentIntegrator(this).initiateScan(); // QR 스캐너 시작
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Log.d("QRScanner", "Cancelled scan");
            } else {
                Log.d("QRScanner", "Scanned");
                // 스캔된 데이터를 처리합니다. 예: 결과를 TextView에 표시
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}