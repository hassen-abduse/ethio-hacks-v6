package com.example.phoneui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var one:Button
    private lateinit var two:Button
    private lateinit var three:Button
    private lateinit var four:Button
    private lateinit var five:Button
    private lateinit var six:Button
    private lateinit var seven:Button
    private lateinit var eight:Button
    private lateinit var nine:Button
    private lateinit var zero:Button
    private lateinit var star:Button
    private lateinit var hashtag:Button
    private lateinit var text:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = text

        one = one
        one.setOnClickListener{
            text.append(one.text);
        }
        two = two
        two.setOnClickListener{
            text.append(two.text);
    }
        three = three
        three.setOnClickListener{
        text.append(three.text);
    }
        four = four
        four.setOnClickListener{
        text.append(four.text);
    }
        five = five
        five.setOnClickListener{
        text.append(five.text);
    }
        six = six
        six.setOnClickListener{
            text.append(six.text);
        }

        seven = seven
        seven.setOnClickListener{
            text.append(seven.text);
        }

        eight = eight
        seven.setOnClickListener{
            text.append(seven.text);
        }

        nine = nine
        nine.setOnClickListener{
            text.append(nine.text);
        }

        zero = zero
        zero.setOnClickListener{
            text.append(zero.text);
        }

        star = star
        star.setOnClickListener{
            text.append(star.text);
        }

        hashtag = hashtag
        hashtag.setOnClickListener{
            text.append(hashtag.text);
        }




    }






}
