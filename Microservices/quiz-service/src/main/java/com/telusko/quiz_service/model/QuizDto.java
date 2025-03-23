package com.telusko.quiz_service.model;

import lombok.Data;

@Data
public class QuizDto {
    private  String categoryName;
    private  Integer noOfQuestions;
    private  String title;
}
