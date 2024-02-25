package com.example.mvc_pattern

import controller.ScoreController
import com.example.mvc_pattern.model.Score
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ScoreControllerTest {

    private lateinit var scoreController: ScoreController
    private lateinit var score: Score

    @Before
    fun setUp() {
        score = Score()
        scoreController = ScoreController(score)
    }

    @Test
    fun addPoints_incrementsScoreCorrectly() {
        assertEquals(0, scoreController.getScore())

        scoreController.addPoints(10)
        assertEquals(10, scoreController.getScore())

        scoreController.addPoints(5)
        assertEquals(15, scoreController.getScore())
    }

    @Test
    fun getScore_returnsCurrentScore() {
        // Initial score should be zero
        assertEquals(0, scoreController.getScore())

        // Increment the score and check if it is updated
        score.incrementScore(20)
        assertEquals(20, scoreController.getScore())
    }
}
