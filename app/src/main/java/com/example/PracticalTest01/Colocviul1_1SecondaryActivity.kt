package ro.pub.cs.systems.eim.PracticalTest01

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Colocviul1_1SecondaryActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var registerButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviul1_1_secondary)

        // Initialize views
        resultTextView = findViewById(R.id.result)
        registerButton = findViewById(R.id.register_button)
        cancelButton = findViewById(R.id.cancel_button)

        // Get the number of clicks passed from the main activity
        val numberOfClicks = intent.getIntExtra("number_of_clicks", 0)
        resultTextView.text = "Number of clicks: $numberOfClicks"

        // Handle register button click
        registerButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("button_text", "Register")
            setResult(RESULT_OK, intent)
            finish()  // Close the activity and return to the parent
        }

        // Handle cancel button click
        cancelButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("button_text", "Cancel")
            setResult(RESULT_OK, intent)
            finish()  // Close the activity and return to the parent
        }
    }
}