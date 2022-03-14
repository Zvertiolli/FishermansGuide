package space.alehandrozed.fishermansguide

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private var num1: Byte = 0
    private var num2: Short = 0
    private var num3: Int = 0
    private var num4: Long = 0

    private var text: String = "Text text"
    private var ch: Char = '5'
    private var f: Float = 0.0f
    private var d: Double = 0.0

    private var tvText: TextView? = null
    private var cLatout: ConstraintLayout? = null
    private var counter: Int = 0
    private var start: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText = findViewById(R.id.tvText)
        cLatout = findViewById(R.id.cLayout)

        tvText?.setText(num1.toString())

        Thread {
            start = true
            while (start) {
                Thread.sleep(1000)
                if (counter == 5) {
                    runOnUiThread { cLatout?.setBackgroundColor(Color.BLUE) }
                }
                runOnUiThread { tvText?.setText(counter.toString()) }
                counter++
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        start = false
    }
}