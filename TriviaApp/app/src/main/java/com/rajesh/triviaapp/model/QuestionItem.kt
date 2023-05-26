package com.rajesh.triviaapp.model

data class QuestionItem(
    val question: String,
    val category: String,
    val choices: List<String>,
    val answer: String
)