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

        mButtonTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectTeamActivity.this, BattleActivity.class));
            }
        });

        mButtonTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectTeamActivity.this, BattleActivity.class));
            }
        });
    }
}
