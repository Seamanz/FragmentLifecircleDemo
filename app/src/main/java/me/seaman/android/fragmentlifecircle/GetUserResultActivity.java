package me.seaman.android.fragmentlifecircle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GetUserResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_result);
    }

    public void setResultOk(View view) {
        setResult(RESULT_OK);
        finish();
    }
}
