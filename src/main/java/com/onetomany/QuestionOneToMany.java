package com.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class QuestionOneToMany {

    @Id
    @Column(name = "Question_id")
    private int QuestionId;
    private String Question;

    @OneToMany(mappedBy = "Question")
    private List<AnswerOneToMany> answer;

    public QuestionOneToMany() {
    }

    public QuestionOneToMany(int QuestionId, String Question, List<AnswerOneToMany> answer) {
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

    public List<AnswerOneToMany> getAnswer() {
        return answer;
    }

    public void setAnswer(List<AnswerOneToMany> answer) {
        this.answer = answer;
    }
}
