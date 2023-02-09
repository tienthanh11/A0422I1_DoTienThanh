package com.example.final_exam.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "question_content")
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    @NotBlank(message = "Title is not empty.")
    @Size(min = 5, max = 100)
    private String title;
    @Column(name = "content")
    @NotBlank(message = "Content is not empty.")
    @Size(min = 10, max = 500)
    private String content;
    @Column(name = "answer")
    @NotBlank(message = "Answer is not empty.")
    private String answer;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_question_type", referencedColumnName = "id")
    @NotBlank(message = "Type is not empty.")
    private QuestionType questionType;
    @Column(name = "date_create")
    @NotBlank(message = "Date is not empty.")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateCreate;
    @Column(name = "status")
    @NotBlank(message = "Status is not empty.")
    private boolean status;

    public QuestionContent() {
    }

    public QuestionContent(Integer id, String title, String content, String answer, QuestionType questionType, Date dateCreate, boolean status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.questionType = questionType;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
