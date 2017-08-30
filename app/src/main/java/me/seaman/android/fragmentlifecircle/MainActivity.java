package me.seaman.android.fragmentlifecircle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<IntentItem> sIntentItems = new ArrayList<>();

    static {
        sIntentItems.add(new IntentItem(FragmentPagerActivity.class, "ViewPager管理Fragment"));
        sIntentItems.add(new IntentItem(FragmentTabHostActivity.class, "FragmentTabHost管理Fragment"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView itemList = (ListView) findViewById(R.id.itemList);
        itemList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, sIntentItems));
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(sIntentItems.get(position).getIntent(getApplicationContext()));
            }
        });

    }
}
