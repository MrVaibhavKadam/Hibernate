package com.onetomany;

import com.onetomany.AnswerOneToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionOneToMany {

    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;

    @OneToMany (mappedBy = "question")
    private List<AnswerOneToMany> answer;

    public QuestionOneToMany() {
    }

    public QuestionOneToMany(int questionId, String question, List<AnswerOneToMany> answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerOneToMany> getAnswer() {
        return answer;
    }

    public void setAnswer(List<AnswerOneToMany> answer) {
        this.answer = answer;
    }
}
