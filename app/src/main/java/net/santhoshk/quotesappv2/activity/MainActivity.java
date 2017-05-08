package net.santhoshk.quotesappv2.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import net.santhoshk.quotesappv2.R;
import net.santhoshk.quotesappv2.fragment.RVListViewFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.mainActivityToolbar);
        //setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            RVListViewFragment rvListViewFragment = new RVListViewFragment();
            fragmentTransaction.replace(R.id.frag_view_main_list, rvListViewFragment, "RVFrag");
            fragmentTransaction.commit();
        }
    }
}
