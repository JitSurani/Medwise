package com.example.medwise

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Initialize Buttons
        val btnDiseaseDetection: Button = findViewById(R.id.btnDiseaseDetection)
        val btnMedicineRecommendation: Button = findViewById(R.id.btnMedicineRecommendation)
        val btnHome: Button = findViewById(R.id.btnHome)
        val btnSettings: Button = findViewById(R.id.btnSettings)

        // Click Listeners (For Future Navigation)
        btnDiseaseDetection.setOnClickListener {
            // TODO: Navigate to Disease Detection Page
        }

        btnMedicineRecommendation.setOnClickListener {
            // TODO: Navigate to Medicine Recommendation Page
        }

        btnHome.setOnClickListener {
            // TODO: Navigate to Home Page
        }

        btnSettings.setOnClickListener {
            // TODO: Navigate to Settings Page
        }
    }
}
