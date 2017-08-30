package me.seaman.android.fragmentlifecircle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import me.seaman.android.fragmentlifecircle.fragments.CenterFragment;
import me.seaman.android.fragmentlifecircle.fragments.LeftFragment;
import me.seaman.android.fragmentlifecircle.fragments.RightFragment;

public class FragmentPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private BottomNavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = Fragment.instantiate(getApplicationContext(), LeftFragment.class.getName());
                        break;
                    case 1:
                        fragment = Fragment.instantiate(getApplicationContext(), CenterFragment.class.getName());
                        break;
                    case 2:
                        fragment = Fragment.instantiate(getApplicationContext(), RightFragment.class.getName());
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int itemId = R.id.action_left;
                switch (position) {
                    case 0:
                        itemId = R.id.action_left;
                        break;
                    case 1:
                        itemId = R.id.action_center;
                        break;
                    case 2:
                        itemId = R.id.action_right;
                        break;
                }
                mNavigationView.setSelectedItemId(itemId);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
                mViewPager.setCurrentItem(index, false);
                return true;
            }
        });
        mNavigationView.setSelectedItemId(R.id.action_left);
    }
}
