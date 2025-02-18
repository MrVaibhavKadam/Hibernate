package com.onetoone;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;
    @OneToOne(mappedBy = "answer")
//using this the answer table will not create foreign key only Question table shows FK
    @JoinColumn(name = "q_id")
    private Question Question;

    public Answer(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public Answer() {
    }

    public Question getQuestion() {
        return Question;
    }

    public Answer(Question Question) {
        this.Question = Question;
    }

    public void setQuestion(Question Question) {
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
