package controller

import com.example.mvc_pattern.model.Score

class ScoreController(private val score: Score) {

    fun addPoints(points: Int) {
        score.incrementScore(points)
    }

    fun getScore(): Int = score.getCurrentScore()

    // Additional methods related to score
}
