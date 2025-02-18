package xmlbasedexample.onetoonemapping;

public class AnswerX {


    private int answerId;
    private String answer;
    private QuestionX Question;

    public AnswerX() {
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

    public QuestionX getQuestion() {
        return Question;
    }

    public void setQuestion(QuestionX question) {
        Question = question;
    }

    public AnswerX(int answerId, String answer, QuestionX question) {
        this.answerId = answerId;
        this.answer = answer;
        Question = question;
    }
}
