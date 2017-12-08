package fr.wcs.ddsj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectTeamActivity extends AppCompatActivity {

    private Button mButtonTeam1,mButtonTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_team);

        mButtonTeam1 = findViewById(R.id.button_team1);
        mButtonTeam2 = findViewById(R.id.button_team2);

//        Intent playerBis = getIntent();
//        final String playerBis1 = playerBis.getStringExtra("pseudoBis1");
//        final String playerBis2 = playerBis.getStringExtra("pseudoBis2");

        TeamModel teamModelName = getIntent().getExtras().getParcelable("teamName");
            mButtonTeam1.setText(teamModelName.getTeam1());
            mButtonTeam2.setText(teamModelName.getTeam2());



        mButtonTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bisP = new Intent(SelectTeamActivity.this, BattleActivity.class);
                //bisP.putExtra("battleTeam1", playerBis1);
                startActivity(bisP);
            }
        });

        mButtonTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bisP2 = new Intent(SelectTeamActivity.this, BattleActivity.class);
                //bisP2.putExtra("battleTeam2", playerBis2);
                startActivity(bisP2);
            }
        });
    }
}
