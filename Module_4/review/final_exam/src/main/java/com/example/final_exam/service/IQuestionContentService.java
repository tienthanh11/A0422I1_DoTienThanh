package com.example.final_exam.service;

import com.example.final_exam.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IQuestionContentService {
    void create(QuestionContent questionContent);
    void delete(Integer id);
    Page findAll(Pageable pageable);
    Optional<QuestionContent> findById(Integer id);
    Page search(String title, Pageable pageable);
    Page searchType(Integer type, Pageable pageable);
}
