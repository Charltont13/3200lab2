package com.example.mvc_pattern

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvc_pattern.R
import controller.QuestionController
import controller.UserController
import com.example.mvc_pattern.model.Question
import com.example.mvc_pattern.model.Score
import com.example.mvc_pattern.model.User
import controller.ScoreController

class MainActivity : AppCompatActivity() {
    private lateinit var questionController: QuestionController
    private lateinit var scoreController: ScoreController
    private lateinit var answersRadioGroup: RadioGroup
    private lateinit var questionTextView: TextView
    private lateinit var submitAnswerButton: Button
    private lateinit var nextQuestionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        // Initialize the TextView, RadioGroup, and Button
        questionTextView = findViewById(R.id.questionTextView)
        answersRadioGroup = findViewById(R.id.answersRadioGroup)
        nextQuestionButton = findViewById(R.id.button_next_question)
        submitAnswerButton = findViewById(R.id.submitAnswerButton)

        // Initialize controllers with dummy data for demonstration
        val dummyQuestions = listOf(
            Question("What is the capital of France?", listOf("Paris", "Rome", "Madrid", "Berlin"), 0),
            Question("What is the largest planet in our Solar System?", listOf("Earth", "Venus", "Jupiter", "Mars"), 2),
            Question("Who wrote 'Romeo and Juliet'?", listOf("Mark Twain", "William Shakespeare", "Ernest Hemingway", "Jane Austen"), 1),
            Question("What is the currency of Japan?", listOf("Dollar", "Euro", "Yen", "Rupee"), 2),
            Question("How many continents are there on Earth?", listOf("Five", "Six", "Seven", "Eight"), 2),
            // Add more dummy questions as needed
        )
        scoreController = ScoreController(Score())

        questionController = QuestionController(dummyQuestions)

        // Load the first question
        loadNextQuestion()

        submitAnswerButton.setOnClickListener {
            // Logic to check the selected answer and update the score
            val selectedId = answersRadioGroup.checkedRadioButtonId
            if (selectedId != -1) { // Make sure an option is selected
                val radioButton = findViewById<RadioButton>(selectedId)
                val currentQuestion = questionController.getCurrentQuestion()
                if (currentQuestion != null) {
                    val correctAnswer = currentQuestion.options[currentQuestion.correctAnswerIndex]
                    if (radioButton.text == correctAnswer) {
                        scoreController.addPoints(10) // Assuming each correct answer gives 10 points
                        Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // After submitting the answer, load the next question
            loadNextQuestion()
        }

        nextQuestionButton.setOnClickListener {
            // This button could be used to simply move to the next question without submitting
            loadNextQuestion()
        }
    }

    private fun loadNextQuestion() {
        val question = questionController.getNextQuestion()
        if (question != null) {
            questionTextView.text = question.questionText
            // Update the radio buttons with the answer choices from question.options
            // Assume you have a method to dynamically create or update radio buttons
            // Hide the next question button until an answer is submitted
            nextQuestionButton.visibility = View.GONE
        } else {
            // No more questions available
            Toast.makeText(this, "No more questions!", Toast.LENGTH_SHORT).show()
            // Here you could also navigate to a score summary screen or similar
        }
    }

    private fun updateScoreDisplay(newScore: Int) {
        // Update the TextView that displays the score
        findViewById<TextView>(R.id.scoreTextView).text = "Score: $newScore"
    }

    // ... other methods ...
}
