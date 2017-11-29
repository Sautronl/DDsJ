package fr.wcs.ddsj;

/**
 * Created by apprenti on 29/11/17.
 */

public class QrModel {
    String question;
    String reponse;
    int score;

    public QrModel(){

    }

    public QrModel(String question, String reponse, int score) {
        this.question = question;
        this.reponse = reponse;
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
