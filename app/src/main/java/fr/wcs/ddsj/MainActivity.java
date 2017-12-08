package fr.wcs.ddsj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //public static String USER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView pseudoDD = (TextView) findViewById(R.id.pseudoDD);
        ImageButton free = (ImageButton) findViewById(R.id.free);

//        Intent player = getIntent();
//        final String player1 = player.getStringExtra("pseudo1");
//        final String player2 = player.getStringExtra("pseudo2");


//        Intent res = getIntent();
//        String pseudoPl = res.getStringExtra("pseudo");
//        USER = pseudoPl;
//        pseudoDD.setText(pseudoPl);

        free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, SelectTeamActivity.class);
//                in.putExtra("pseudoBis1", player1);
//                in.putExtra("pseudoBis2", player2);
                startActivity(in);
            }
        });
    }
}
