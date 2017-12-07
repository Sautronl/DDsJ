package fr.wcs.ddsj;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PointActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    private static int DURATION2 = 4500;
    private TextView textVTeam1,textVTeam2,textVPoint1,textVPoint2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

         textVTeam1 = findViewById(R.id.textVTeam1);
         textVTeam2 = findViewById(R.id.textVTeam2);
         textVPoint1 = findViewById(R.id.textVPoint1);
         textVPoint2 = findViewById(R.id.textVPoint2);



        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent score = getIntent();
                String score1 = score.getStringExtra("point1");
                String score2 = score.getStringExtra("point2");
                String tag1 = score.getStringExtra("team1");
                String tag2 = score.getStringExtra("team2");


                textVTeam1.setText(tag1);
                textVTeam2.setText(tag2);

                textVPoint1.setText(score1);
                textVPoint2.setText(score2);
                startActivity(new Intent(PointActivity.this, BattleActivity.class));
                finish();
            }
        },DURATION2);
     }
}
