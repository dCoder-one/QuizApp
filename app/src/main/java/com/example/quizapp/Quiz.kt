package com.example.quizapp

class Quiz(val questions: List<Question>) {

    // variables to track: score, current question
    var score = 0
//    var currentQuestion = 3
//    fun blank(): Int {
//        var n = 0
//    }
    var n = 0
    var i = 0
    fun getQuestion() : String {
        return questions[n].question
    }
    fun getAnswer1() : String {
        return questions[n].choices[0]
    }
    fun getAnswer2() : String {
        return questions[n].choices[1]
    }
    fun getAnswer3() : String {
        return questions[n].choices[2]
    }


    // functions
    // are there more questions?
    // getting the current question
    // checking answer
    // optional: reset the quiz, shuffle questions
}