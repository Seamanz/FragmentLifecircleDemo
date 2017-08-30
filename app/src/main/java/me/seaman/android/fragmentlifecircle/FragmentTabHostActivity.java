package me.seaman.android.fragmentlifecircle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import me.seaman.android.fragmentlifecircle.fragments.CenterFragment;
import me.seaman.android.fragmentlifecircle.fragments.LeftFragment;
import me.seaman.android.fragmentlifecircle.fragments.RightFragment;

public class FragmentTabHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab_host);

        final FragmentTabHost fragmentHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentHost.setup(this, getSupportFragmentManager(), R.id.real_tab_content);
        fragmentHost.addTab(fragmentHost.newTabSpec(LeftFragment.TAG).setIndicator(""), LeftFragment.class, null);
        fragmentHost.addTab(fragmentHost.newTabSpec(CenterFragment.TAG).setIndicator(""), CenterFragment.class, null);
        fragmentHost.addTab(fragmentHost.newTabSpec(RightFragment.TAG).setIndicator(""), RightFragment.class, null);

        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int index = 0;
                switch (item.getItemId()) {
                    case R.id.action_left:
                        index = 0;
                        break;
                    case R.id.action_center:
                        index = 1;
                        break;
                    case R.id.action_right:
                        index = 2;
                        break;
                }
                fragmentHost.setCurrentTab(index);
                return true;
            }
        });
        navigationView.setSelectedItemId(0);
    }
}
