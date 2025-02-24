package com.example.medwise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import java.util.*

class PersonalInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        val nameField: EditText = findViewById(R.id.etFullName)
        val mobileField: EditText = findViewById(R.id.etMobile)
        val dateField: EditText = findViewById(R.id.etDay)
        val monthField: EditText = findViewById(R.id.etMonth)
        val yearField: EditText = findViewById(R.id.etYear)
        val genderGroup: RadioGroup = findViewById(R.id.radioGroupGender)
        val submitButton: Button = findViewById(R.id.btnSubmit)

        submitButton.setOnClickListener {
            val name = nameField.text.toString().trim()
            val mobile = mobileField.text.toString().trim()
            val date = dateField.text.toString().trim()
            val month = monthField.text.toString().trim()
            val year = yearField.text.toString().trim()
            val selectedGenderId = genderGroup.checkedRadioButtonId

            // Validate Name
            if (name.isEmpty()) {
                nameField.error = "Full Name is required"
                return@setOnClickListener
            }

            // Validate Mobile Number (10 digits)
            if (mobile.isEmpty() || !mobile.matches(Regex("^[0-9]{10}$"))) {
                mobileField.error = "Enter a valid 10-digit mobile number"
                return@setOnClickListener
            }

            // Validate Date of Birth
            val dayInt = date.toIntOrNull()
            val monthInt = month.toIntOrNull()
            val yearInt = year.toIntOrNull()

            if (dayInt == null || dayInt !in 1..31) {
                dateField.error = "Enter a valid day (1-31)"
                return@setOnClickListener
            }
            if (monthInt == null || monthInt !in 1..12) {
                monthField.error = "Enter a valid month (1-12)"
                return@setOnClickListener
            }
            if (yearInt == null || yearInt !in 1900..Calendar.getInstance().get(Calendar.YEAR)) {
                yearField.error = "Enter a valid year (1900-${Calendar.getInstance().get(Calendar.YEAR)})"
                return@setOnClickListener
            }

            // Validate Gender Selection
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // If all fields are valid, navigate to Dashboard
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}





