package fr.wcs.ddsj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleActivity extends AppCompatActivity {

    private FirebaseDatabase mFire;
    private DatabaseReference mRef;
    private List<QrModel> mListModel = new ArrayList<>();
    private QrModel mQrModel;

    private Button mButtonTeam1,mButtonTeam2, mButtonEx;
    private TextView mQuestionText, mReponseText, mPointTeam1,mPointTeam2, mTeamPlay1,mTeamPlay2;
    private Random rand = new Random();
    int mRngQuestion;
    String mResultat, mPointString1, mPointString2;
    public int mPoint1 = 0;
    public int mPoint2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        mFire = FirebaseDatabase.getInstance();
        mRef = mFire.getReference("test");

        mButtonTeam1 = findViewById(R.id.buttonTeam1);
        mButtonTeam2 = findViewById(R.id.buttonTeam2);
        mButtonEx = findViewById(R.id.buttonEx);

        mQuestionText = findViewById(R.id.questionText);
        mReponseText = findViewById(R.id.reponseText);
        mPointTeam1 = findViewById(R.id.pointTeam1);
        mPointTeam2 = findViewById(R.id.pointTeam2);
        mTeamPlay1 = findViewById(R.id.nomTeam1);
        mTeamPlay2 = findViewById(R.id.nomTeam2);

        Intent battle = getIntent();
        final String battleP1 = battle.getStringExtra("battleTeam1");
        final String battleP2 = battle.getStringExtra("battleTeam2");

        mPointString1 = String.valueOf(mPoint1);
        mPointString2 = String .valueOf(mPoint2);


        mTeamPlay1.setText(battleP1);
       //mTeamPlay2.setText(battleP2);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int nbrChild = (int) dataSnapshot.getChildrenCount();
                rng(nbrChild);
                mRef.child(mResultat).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        mQrModel = dataSnapshot.getValue(QrModel.class);
                        mListModel.add(mQrModel);
                        for (int i = 0; i < mListModel.size(); i++) {
                            mQuestionText.setText(mQrModel.getQuestion());
                            mReponseText.setText(mQrModel.getReponse());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mButtonTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPointTeam1.setText(mPointString1);
                mPoint1 += 1;
                if (mPoint1 == 10){
                   Intent resultat1 = new Intent(BattleActivity.this, FinishActivity.class);
                   resultat1.putExtra("team1", battleP1);

                }
                Intent teamOne = new Intent(BattleActivity.this, PointActivity.class);
                teamOne.putExtra("point1",mPointString1);
                teamOne.putExtra("point2", mPointString2);
                startActivity(teamOne);
            }
        });

        mButtonTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPointTeam2.setText(mPointString2);
                mPoint2 += 1;
                if (mPoint2 == 10){
                    Intent resultat2 = new Intent(BattleActivity.this, FinishActivity.class);
                    resultat2.putExtra("team2", battleP2);
                    startActivity(resultat2);
                }
                Intent teamTwo = new Intent(BattleActivity.this, PointActivity.class);
                teamTwo.putExtra("point1",mPointString1);
                teamTwo.putExtra("point2", mPointString2);
                startActivity(teamTwo);
            }
        });

        mButtonEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void rng(int child){
        int min = 0;
        int max = child - 1;

        mRngQuestion = min + rand.nextInt(max + min);
        mResultat = String.valueOf(mRngQuestion);
    }
}
