package com.onetomany;

import com.onetomany.QuestionOneToMany;

import javax.persistence.*;

@Entity
public class AnswerOneToMany {

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @ManyToOne
    private QuestionOneToMany question;

    public AnswerOneToMany(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public AnswerOneToMany() {
    }

    public QuestionOneToMany getQuestion() {
        return question;
    }

    public AnswerOneToMany(QuestionOneToMany question) {
        this.question = question;
    }

    public void setQuestion(QuestionOneToMany question) {
        this.question = question;
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
