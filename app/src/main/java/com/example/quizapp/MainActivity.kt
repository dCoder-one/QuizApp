package com.example.quizapp

import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    lateinit var quiz : Quiz
    lateinit var layout : ConstraintLayout

    lateinit var groupMain : Group
    lateinit var answer1 : Button
    lateinit var answer2 : Button
    lateinit var answer3 : Button
    lateinit var newQuestion : TextView

    lateinit var groupEnd : Group
    lateinit var endScreen : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wireWidgets()
        loadQuestions()

        colors()

        groupEnd.visibility = View.GONE
        endScreen.text = "You are a "

        var black = rgb(0,0,0)
        var white = rgb(255, 255, 255)
        layout.setBackgroundColor(black)
        newQuestion.setTextColor(white)
        newQuestion.textSize = 30F

        newQuestion.text = quiz.getQuestion()
        answer1.text = quiz.getAnswer1()
        answer2.text = quiz.getAnswer2()
        answer3.text = quiz.getAnswer3()

        answer1.setOnClickListener {
            newQuestion.text = quiz.getQuestion()
            answer1.text = quiz.getAnswer1()
            answer2.text = quiz.getAnswer2()
            answer3.text = quiz.getAnswer3()
            quiz.n++
            if (quiz.n == 4) {
                groupEnd.visibility = View.VISIBLE
                groupMain.visibility = View.GONE
            }
        }
        answer2.setOnClickListener {
            newQuestion.text = quiz.getQuestion()
            answer1.text = quiz.getAnswer1()
            answer2.text = quiz.getAnswer2()
            answer3.text = quiz.getAnswer3()
            quiz.n++
            if (quiz.n == 4) {
                groupEnd.visibility = View.VISIBLE
                groupMain.visibility = View.GONE
            }
        }
        answer3.setOnClickListener {
            newQuestion.text = quiz.getQuestion()
            answer1.text = quiz.getAnswer1()
            answer2.text = quiz.getAnswer2()
            answer3.text = quiz.getAnswer3()
            quiz.n++
            if (quiz.n == 4) {
                groupEnd.visibility = View.VISIBLE
                groupMain.visibility = View.GONE
            }
        }


        val score = resources.getString(R.string.score)

        // do the initial questions & answer choices setup

        // set listeners to react to user input
            // passing info to and from the quiz object

    }

    private fun colors() {
        var red = rgb(255, 0, 0)
        var black = rgb(0,0,0)
    }

    private fun wireWidgets() {
        answer1 = findViewById(R.id.button_main_answerOne)
        answer2 = findViewById(R.id.button_main_answerTwo)
        answer3 = findViewById(R.id.button_main_answerThree)
        newQuestion = findViewById(R.id.text_main_question)
        groupMain = findViewById(R.id.group_main_baseUI)
        groupEnd = findViewById(R.id.group_endscreen_scoreUI)
        endScreen = findViewById(R.id.text_endscreen_score)
        layout = findViewById(R.id.layout_main)
    }

    private fun loadQuestions() {
        // load questions from JSON
        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
        }
        Log.d(TAG, "OnCreate: jsonString $jsonString")

        val gson = Gson()
        val qType = object : TypeToken<List<Question>>() { }.type // TypeToken tells gson what to convert to json
        val questions = gson.fromJson<List<Question>>(jsonString, qType)
        Log.d(TAG, "loadQuestions: $questions")

        quiz = Quiz(questions)
        quiz.getQuestion()
        quiz.getAnswer1()
        quiz.getAnswer2()
        quiz.getAnswer3()
//        quiz.blank()

        Log.d(TAG, "loadQuestions: $quiz")

        // next steps:
        // make your Question data class
        // use this tutorial:
        //
        // scroll down to "parsing between a Collection, List, or Array
        // convert your jsonString to a List<Question>
        // log that list of questions to see if it worked


        // create a quiz object and pass in that list of questions
        // as a parameter
    }
}