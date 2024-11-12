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


class Colocviu1_1MainActivity : AppCompatActivity() {

    // Define EditText and Button variables
    private lateinit var leftEditText: EditText
    private lateinit var rightEditText: EditText
    private lateinit var leftButton: Button
    private lateinit var rightButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviul1_1_main)
        enableEdgeToEdge()
        leftEditText = findViewById(R.id.left_edit_text)
        rightEditText = findViewById(R.id.right_edit_text)
        leftButton = findViewById(R.id.left_button)
        rightButton = findViewById(R.id.right_button)


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
    }
}