package com.example.mvc_pattern



import com.example.mvc_pattern.model.Question
import controller.QuestionController
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class QuestionControllerTest {

    private lateinit var questionController: QuestionController
    private lateinit var questions: List<Question>

    @Before
    fun setUp() {
        // Setup some dummy questions
        questions = listOf(
            Question("Question 1", listOf("Option 1", "Option 2"), 0),
            Question("Question 2", listOf("Option 3", "Option 4"), 1)
        )
        questionController = QuestionController(questions)
    }

    @Test
    fun getNextQuestion_returnsFirstQuestion() {
        val question = questionController.getNextQuestion()
        assertNotNull(question)
        assertEquals("Question 1", question?.questionText)
    }

    @Test
    fun getNextQuestion_returnsNullAfterLastQuestion() {
        // Get all questions until no more left
        while (questionController.getNextQuestion() != null) {
            // No-op
        }
        assertNull(questionController.getNextQuestion())
    }

    @Test
    fun getCurrentQuestion_returnsCurrentQuestion() {
        questionController.getNextQuestion() // Move to the first question
        val currentQuestion = questionController.getCurrentQuestion()
        assertNotNull(currentQuestion)
        assertEquals("Question 1", currentQuestion?.questionText)
    }

    @Test
    fun getCurrentQuestion_returnsNullWhenNoCurrentQuestion() {
        // Without calling getNextQuestion(), there should be no current question
        val currentQuestion = questionController.getCurrentQuestion()
        assertNull(currentQuestion)
    }
}