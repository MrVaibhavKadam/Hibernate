package com.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerOneToMany {

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @ManyToOne
    private QuestionOneToMany Question;

    public AnswerOneToMany(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public AnswerOneToMany() {
    }

    public QuestionOneToMany getQuestion() {
        return Question;
    }

    public AnswerOneToMany(QuestionOneToMany Question) {
        this.Question = Question;
    }

    public void setQuestion(QuestionOneToMany Question) {
        this.Question = Question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
