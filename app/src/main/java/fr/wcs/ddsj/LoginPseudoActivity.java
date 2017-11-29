package fr.wcs.ddsj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPseudoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pseudo);

        final EditText pseudoJOne = (EditText) findViewById(R.id.pseudoP1);
        final EditText pseudoJTwo = (EditText) findViewById(R.id.pseudoP2);
        Button valid = (Button) findViewById(R.id.valider);

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1 = pseudoJOne.getText().toString().trim();
                String p2 = pseudoJTwo.getText().toString().trim();

                Intent i = new Intent();
                i.putExtra("pseudo", p1);
                i.putExtra("pseudo", p2);

            }
        });
    }
}
