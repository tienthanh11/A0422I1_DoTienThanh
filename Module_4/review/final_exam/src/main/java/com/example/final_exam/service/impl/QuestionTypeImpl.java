package com.example.final_exam.service.impl;

import com.example.final_exam.model.QuestionType;
import com.example.final_exam.service.IQuestiontypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeImpl implements IQuestiontypeService {
    @Override
    public List<QuestionType> findAll() {
        return null;
    }
}
