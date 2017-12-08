package fr.wcs.ddsj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LoginPseudoActivity extends AppCompatActivity {

    //public static String USERTWO;
    private EditText mPseudo1,mPseudo2;
    public String mTeam1,mTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pseudo);

        mPseudo1 = (EditText) findViewById(R.id.pseudoP1);
        mPseudo2 = (EditText) findViewById(R.id.pseudoP2);
        ImageView imageLogo = (ImageView) findViewById(R.id.imageLogo);
        Button valid = (Button) findViewById(R.id.valider);



        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1 = mPseudo1.getText().toString().trim();
                String p2 = mPseudo2.getText().toString().trim();
                TeamModel teamName = new TeamModel(p1,p2,0,0);
                Intent i = new Intent(LoginPseudoActivity.this, MainActivity.class);
                i.putExtra("team", teamName);
                startActivity(i);

//                String p1 = pseudoJOne.getText().toString().trim();
//                String p2 = pseudoJTwo.getText().toString().trim();
//                Random r = new Random();
//                int valeurMin = 1;
//                int valeurMax = 99;
//                int player1 = valeurMin + r.nextInt(valeurMax - valeurMin);
//                int player2 = valeurMin + r.nextInt(valeurMax - valeurMin);

                //if (player1 >= player2){
                  //  USERTWO = p2;
//                mTeam1 = mPseudo1.getText().toString().trim();
//                mTeam2 = mPseudo2.getText().toString().trim();
//                    Intent i = new Intent(LoginPseudoActivity.this, MainActivity.class);
//                    i.putExtra("pseudo1", mTeam1);
//                    i.putExtra("pseudo2", mTeam2);
//                    startActivity(i);
//                }else{
//                    USERTWO = p1;
//                    Intent i = new Intent(LoginPseudoActivity.this, MainActivity.class);
//                    i.putExtra("pseudo", p2);
//                    startActivity(i);
//                }
            }
        });
    }
}
