package ro.pub.cs.systems.eim.PracticalTest01

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import android.widget.Toast


class Colocviu1_1MainActivity : AppCompatActivity() {

    // Define EditText and Button variables
    private lateinit var leftEditText: EditText
    private lateinit var rightEditText: EditText
    private lateinit var leftButton: Button
    private lateinit var rightButton: Button
    private lateinit var navigateToSecondaryActivityButton: Button

    private val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val buttonText = result.data?.getStringExtra("button_text")
            buttonText?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviul1_1_main)
        enableEdgeToEdge()
        leftEditText = findViewById(R.id.left_edit_text)
        rightEditText = findViewById(R.id.right_edit_text)
        leftButton = findViewById(R.id.left_button)
        rightButton = findViewById(R.id.right_button)
        navigateToSecondaryActivityButton = findViewById(R.id.navigate_to_secondary_activity_button)



        val rootView: View = findViewById(R.id.root_view)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updatePadding(
                left = systemBars.left,
                top = systemBars.top,
                right = systemBars.right,
                bottom = systemBars.bottom
            )
            WindowInsetsCompat.CONSUMED
        }

        leftButton.setOnClickListener {
            val leftCount = leftEditText.text.toString().toIntOrNull() ?: 0
            leftEditText.setText((leftCount + 1).toString())
        }

        rightButton.setOnClickListener {
            val rightCount = rightEditText.text.toString().toIntOrNull() ?: 0
            rightEditText.setText((rightCount + 1).toString())
        }

        navigateToSecondaryActivityButton.setOnClickListener {
            val leftCount = leftEditText.text.toString().toIntOrNull() ?: 0
            val rightCount = rightEditText.text.toString().toIntOrNull() ?: 0
            val numberOfClicks = leftCount + rightCount

            val intent = Intent(this, Colocviul1_1SecondaryActivity::class.java)
            intent.putExtra("number_of_clicks", numberOfClicks)

            // Launch the secondary activity
            activityResultLauncher.launch(intent)
        }
    }
    }
