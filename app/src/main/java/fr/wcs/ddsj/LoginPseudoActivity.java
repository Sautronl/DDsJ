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

    public static String USERTWO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pseudo);

        final EditText pseudoJOne = (EditText) findViewById(R.id.pseudoP1);
        final EditText pseudoJTwo = (EditText) findViewById(R.id.pseudoP2);
        ImageView imageLogo = (ImageView) findViewById(R.id.imageLogo);
        Button valid = (Button) findViewById(R.id.valider);



        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1 = pseudoJOne.getText().toString().trim();
                String p2 = pseudoJTwo.getText().toString().trim();
                Random r = new Random();
                int valeurMin = 1;
                int valeurMax = 99;
                int player1 = valeurMin + r.nextInt(valeurMax - valeurMin);
                int player2 = valeurMin + r.nextInt(valeurMax - valeurMin);

                if (player1 >= player2){
                    USERTWO = p2;
                    Intent i = new Intent(LoginPseudoActivity.this, MainActivity.class);
                    i.putExtra("pseudo", p1);
                    startActivity(i);
                }else{
                    USERTWO = p1;
                    Intent i = new Intent(LoginPseudoActivity.this, MainActivity.class);
                    i.putExtra("pseudo", p2);
                    startActivity(i);
                }
            }
        });
    }
}
