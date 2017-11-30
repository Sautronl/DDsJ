package fr.wcs.ddsj;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class WrongFragment extends Fragment {


    public WrongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        BottomNavMainActivity.mBotNav.setSelectedItemId(R.id.navigation_wrong);
        View view = inflater.inflate(R.layout.fragment_wrong, container, false);
        return view;
    }

}
