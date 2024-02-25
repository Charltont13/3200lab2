package com.example.mvc_pattern.model

data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)