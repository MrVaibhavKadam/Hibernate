package xmlbasedexample.onetoonemapping;


public class QuestionX {

    private int questionId;
    private String question;

    private AnswerX answer;

    public QuestionX() {
    }

    public QuestionX(int questionId, String question, AnswerX answer) {
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

    public AnswerX getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerX answer) {
        this.answer = answer;
    }
}
