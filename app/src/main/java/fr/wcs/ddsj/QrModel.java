package fr.wcs.ddsj;

/**
 * Created by apprenti on 29/11/17.
 */

public class QrModel {
    String question;
    String reponse;

    public QrModel(String question, String reponse) {
        this.question = question;
        this.reponse = reponse;
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
}
