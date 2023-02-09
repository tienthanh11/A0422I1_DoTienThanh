package com.example.final_exam.repository;

import com.example.final_exam.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionContentRepo extends JpaRepository<QuestionContent, Integer> {
    Page<QuestionContent>findAllByTitleContaining(String title, Pageable pageable);
    Page<QuestionContent>findAllByQuestionType(Integer type, Pageable pageable);
}
