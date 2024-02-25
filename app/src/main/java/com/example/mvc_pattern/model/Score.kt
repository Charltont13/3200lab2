package com.example.mvc_pattern.model

class Score {
    private var currentScore = 0

    fun incrementScore(points: Int) {
        currentScore += points
    }

    fun getCurrentScore(): Int {
        return currentScore
    }
}
