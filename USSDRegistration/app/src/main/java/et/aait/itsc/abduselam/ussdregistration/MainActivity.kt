package et.aait.itsc.abduselam.ussdregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        call_button.setOnClickListener {
            val inputText = num_text_view.text.toString()

            if(inputText == "*800#"){
                num_text_view.text = ""
                val languageDialog = LanguageDialog()
                languageDialog.show(supportFragmentManager, "language")

        }
            else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle(R.string.invalid_input)
                    .setMessage("Please Use *800#")
                    .create().show()
            }
        }
        delete_character.setOnClickListener {
            num_text_view.text = ""
        }

        button0.setOnClickListener {
            num_text_view.append(button0.text)
        }

        button1.setOnClickListener {
            num_text_view.append(button1.text)
        }

        button2.setOnClickListener {
            num_text_view.append(button2.text)
        }

        button3.setOnClickListener {
            num_text_view.append(button3.text)
        }

        button4.setOnClickListener {
            num_text_view.append(button4.text)
        }

        button5.setOnClickListener {
            num_text_view.append(button5.text)
        }

        button6.setOnClickListener {
            num_text_view.append(button6.text)
        }

        button7.setOnClickListener {
            num_text_view.append(button7.text)
        }

        button8.setOnClickListener {
            num_text_view.append(button8.text)
        }

        button9.setOnClickListener {
            num_text_view.append(button9.text)
        }
        button_hash.setOnClickListener {
            num_text_view.append(button_hash.text)
        }

        button_star.setOnClickListener {
            num_text_view.append(button_star.text)
        }

}}





