package com.example.final_exam.service.impl;

import com.example.final_exam.model.QuestionContent;
import com.example.final_exam.repository.IQuestionContentRepo;
import com.example.final_exam.service.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionContentImpl implements IQuestionContentService {
    @Autowired
    IQuestionContentRepo questionContentRepo;

    @Override
    public void create(QuestionContent questionContent) {
        questionContentRepo.save(questionContent);
    }

    @Override
    public void delete(Integer id) {
        questionContentRepo.deleteById(id);
    }

    @Override
    public Page findAll(Pageable pageable) {
        return questionContentRepo.findAll(pageable);
    }

    @Override
    public Optional<QuestionContent> findById(Integer id) {
        return questionContentRepo.findById(id);
    }

    @Override
    public Page search(String title, Pageable pageable) {
        return questionContentRepo.findAllByTitleContaining(title, pageable);
    }

    @Override
    public Page searchType(Integer type, Pageable pageable) {
        return questionContentRepo.findAllByQuestionType(type, pageable);
    }
}
