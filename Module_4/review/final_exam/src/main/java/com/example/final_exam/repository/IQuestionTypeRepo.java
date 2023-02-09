package com.example.final_exam.repository;

import com.example.final_exam.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionTypeRepo extends JpaRepository<QuestionType, Integer> {
}
