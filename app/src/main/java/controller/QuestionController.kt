package controller

import com.example.mvc_pattern.model.Question

class QuestionController(private val questions: List<Question>) {
    private var currentQuestionIndex = 0
    private var currentIndex = 0

    fun getNextQuestion(): Question? =
        if (currentQuestionIndex < questions.size) {
            questions[currentQuestionIndex++]
        } else {
            null
        }

    fun getCurrentQuestion(): Question? {
        if (currentIndex >= questions.size) {
            return null // or handle the end of the list as you see fit
        }
        return questions[currentIndex]
    }

    // Additional methods to handle questions
}
