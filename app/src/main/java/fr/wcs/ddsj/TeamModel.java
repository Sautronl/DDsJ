package fr.wcs.ddsj;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apprenti on 08/12/17.
 */

public class TeamModel implements Parcelable{
    private String team1;
    private String team2;
    private int score1;
    private int score2;

    public TeamModel(){

    }

    public TeamModel(String team1, String team2, int score1, int score2) {
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = score1;
        this.score2 = score2;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public static final Creator<TeamModel> CREATOR = new Creator<TeamModel>() {
        @Override
        public TeamModel createFromParcel(Parcel in) {
            return new TeamModel(in);
        }

        @Override
        public TeamModel[] newArray(int size) {
            return new TeamModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    private TeamModel(Parcel in) {
        team1 = in.readString();
        team2 = in.readString();
        score1 = in.readInt();
        score2 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(team1);
        parcel.writeString(team2);
        parcel.writeInt(score1);
        parcel.writeInt(score2);
    }
}
