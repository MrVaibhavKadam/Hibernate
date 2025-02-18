package com.onetoone;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name = "Question_id")
    private int QuestionId;
    private String Question;

    @OneToOne
    @JoinColumn(name = "a_id")
    private Answer answer;

    public Question() {
    }

    public Question(int QuestionId, String Question, Answer answer) {
        this.QuestionId = QuestionId;
        this.Question = Question;
        this.answer = answer;
    }

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int QuestionId) {
        this.QuestionId = QuestionId;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
