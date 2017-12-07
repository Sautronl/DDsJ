package fr.wcs.ddsj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private TextView mQuestionText, mReponseText;
    private Random rand = new Random();
    int mRngQuestion;
    String mResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        mFire = FirebaseDatabase.getInstance();
        mRef = mFire.getReference("test");

        mButtonTeam1 = findViewById(R.id.button_team1);
        mButtonTeam2 = findViewById(R.id.button_team2);
        mButtonEx = findViewById(R.id.buttonEx);

        mQuestionText = findViewById(R.id.questionText);
        mReponseText = findViewById(R.id.reponseText);

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

    }

    private void rng(int child){
        int min = 0;
        int max = child - 1;

        mRngQuestion = min + rand.nextInt(max + min);
        mResultat = String.valueOf(mRngQuestion);
    }
}
