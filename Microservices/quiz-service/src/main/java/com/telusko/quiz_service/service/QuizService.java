package com.telusko.quiz_service.service;


import com.telusko.quiz_service.dao.QuizDao;
import com.telusko.quiz_service.feign.QuizInterface;
import com.telusko.quiz_service.model.QuestionWrapper;
import com.telusko.quiz_service.model.Quiz;
import com.telusko.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category,int numQ,String title){
        List<Integer> questions = quizInterface.getQuestionForQuiz(category,numQ).getBody();

        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.OK);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {

        Quiz quiz = quizDao.findById(id).get();
        List<Integer>  qid = quiz.getQuestionIds();
        List<QuestionWrapper>  questionForUser= quizInterface.getQuestionById(qid).getBody();

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        Integer right= quizInterface.getScore(responses).getBody();
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
