package me.seaman.android.fragmentlifecircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by SeamanZhang on 2017/8/30.
 */

public class IntentItem {
    public Class<? extends Activity> mClazz;
    public String mName;

    public IntentItem(Class<? extends Activity> clazz, String name) {
        mClazz = clazz;
        mName = name;
    }

    @Override
    public String toString() {
        return mName;
    }

    public Intent getIntent(Context context) {
        return new Intent(context, mClazz);
    }
}
