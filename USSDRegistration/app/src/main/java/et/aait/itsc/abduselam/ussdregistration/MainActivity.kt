package et.aait.itsc.abduselam.ussdregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        call.setOnClickListener {

            val languageDialog = LanguageDialog()
            languageDialog.show(supportFragmentManager, "language")
        }



        one.setOnClickListener {
            text.append(one.text);
        }

        two.setOnClickListener {
            text.append(two.text);
        }
        three.setOnClickListener {
            text.append(three.text);
        }
        four.setOnClickListener {
            text.append(four.text);
        }
        five.setOnClickListener {
            text.append(five.text);
        }
        six.setOnClickListener {
            text.append(six.text);
        }
        seven.setOnClickListener {
            text.append(seven.text);
        }

        eight.setOnClickListener {
            text.append(seven.text);
        }
        nine.setOnClickListener {
            text.append(nine.text);
        }
        zero.setOnClickListener {
            text.append(zero.text);
        }
        star.setOnClickListener {
            text.append(star.text);
        }

        hashtag.setOnClickListener {
            text.append(hashtag.text);
        }


    }


}


