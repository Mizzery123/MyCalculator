package sg.edu.rp.c346.mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var numbers : MutableList<Double> = mutableListOf<Double>()
    var calculation : MutableList<String> = mutableListOf<String>()
    var msg = ""
    var display = ""
    var count = 0
    var dotPressed = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun btnOnClick(view: View){
        val btnSelected = view as Button
        when(btnSelected.id){
            buttonAC.id -> {
                display = ""
                msg = ""
                numbers.clear()
                calculation.clear()
                dotPressed = 0
            }
            buttonDivide.id -> {
                count = 0
                msg += "/"
                dotPressed = 0
            }
            button3.id -> {
                if (count == 0){
                    display="7"
                }else{
                    display+="7"
                }
                count++
                msg += "7"
            }
            button4.id -> {
                if (count == 0){
                    display="8"
                }else{
                    display+="8"
                }
                count++
                msg += "8"
            }
            button5.id -> {
                if (count == 0){
                    display="9"
                }else{
                    display+="9"
                }
                count++
                msg += "9"
            }
            buttonMultiply.id -> {
                count = 0
                msg += "*"
                dotPressed = 0
            }
            button7.id -> {
                if (count == 0){
                    display="4"
                }else{
                    display+="4"
                }
                count++
                msg += "4"
            }
            button8.id -> {
                if (count == 0){
                    display="5"
                }else{
                    display+="5"
                }
                count++
                msg += "5"
            }
            button9.id -> {
                if (count == 0){
                    display="6"
                }else{
                    display+="6"
                }
                count++
                msg += "6"
            }
            buttonMinus.id -> {
                count = 0
                msg += "-"
                dotPressed = 0
            }
            button11.id -> {
                if (count == 0){
                    display="1"
                }else{
                    display+="1"
                }
                count++
                msg += "1"
            }
            button12.id -> {
                if (count == 0){
                    display="2"
                }else{
                    display+="2"
                }
                count++
                msg += "2"
            }
            button13.id -> {
                if (count == 0){
                    display="3"
                }else{
                    display+="3"
                }
                count++
                msg += "3"
            }
            buttonPlus.id -> {
                count = 0
                msg += "+"
                dotPressed = 0
            }
            button15.id -> {

                    if (count == 0) {
                        display = "0"
                    } else {
                        display += "0"
                    }
                    count++
                    msg += "0"


            }
            button16.id -> {
                if (dotPressed == 0) {
                    if (count == 0) {
                        display = "0."
                    } else {
                        display += "."
                    }
                    count++
                    msg += "."
                    dotPressed++
                } else {

                }
            }
            buttonEqual.id -> {
                msg += "="
                var num = 0.0
                var number = ""
                for (i in msg){
                    if (i.equals('+') || i.equals('*') || i.equals('/') || i.equals('-') || i.equals('=')){
                        numbers.add(number.toDouble())
                        calculation.add(i.toString())
                        number = ""
                    }else{
                        number += i
                    }
                }
                var counter = 0
                for (i in 0..(numbers.size-1)){
                    if (counter == 0){
                        num = numbers.get(i)

                    }else{

                        var numb = numbers.get(i)
                        var cal = calculation.get(i-1)
                        if (cal.equals("+")){
                            num = num + numb
                        }else if (cal.equals("*")){
                            num = num * numb
                        }else if (cal.equals("-")){
                            num = num - numb
                        }else if (cal.equals("/")){
                            num = num / numb
                        }
                    }
                    counter++
                }

                display = "$num"
                msg = "$num"
                numbers.clear()
                calculation.clear()
                dotPressed = 0
            }

        }
        if (display.equals("")){
            tvResult.text = "0"
        }else {
            tvResult.text = display
        }
    }
}
