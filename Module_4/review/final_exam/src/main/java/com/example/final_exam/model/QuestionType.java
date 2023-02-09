package com.example.final_exam.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_type")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "questionType")
    List<QuestionContent> questionContentList;

    public QuestionType() {
    }

    public QuestionType(Integer id, String name, List<QuestionContent> questionContentList) {
        this.id = id;
        this.name = name;
        this.questionContentList = questionContentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionContent> getQuestionContentList() {
        return questionContentList;
    }

    public void setQuestionContentList(List<QuestionContent> questionContentList) {
        this.questionContentList = questionContentList;
    }
}
