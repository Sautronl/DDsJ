package fr.wcs.ddsj;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class BottomNavMainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Fragment mFrag;
    private ArrayList<Fragment> mNewPager = new ArrayList<>();
    public static BottomNavigationView mBotNav;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_wrong:
                    mFrag = mNewPager.get(0);
                    fragmentTransaction.replace(R.id.content_frame,mFrag);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case R.id.navigation_right:
                    mFrag = mNewPager.get(1);
                    fragmentTransaction.replace(R.id.content_frame,mFrag);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case R.id.navigation_skip:
                    mFrag = mNewPager.get(2);
                    fragmentTransaction.replace(R.id.content_frame,mFrag);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                   break;
//               default:
//                   mFrag = mNewPager.get(1);
//                   fragmentTransaction.replace(R.id.content_frame,mFrag);
//                   fragmentTransaction.addToBackStack(null);
//                   fragmentTransaction.commit();
//                   break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mBotNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBotNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mNewPager.add(Fragment.instantiate(this,MainFragment.class.getName()));
        mNewPager.add(Fragment.instantiate(this,MainFragment.class.getName()));
        mNewPager.add(Fragment.instantiate(this,MainFragment.class.getName()));

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFrag = mNewPager.get(0);
        fragmentTransaction.replace(R.id.content_frame,mFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
