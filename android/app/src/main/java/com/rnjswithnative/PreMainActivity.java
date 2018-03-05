package com.rnjswithnative;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 00326434 on 2018/3/5.
 */

public class PreMainActivity extends Activity {
    TextView tv_jump_rn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_main_activity);
        tv_jump_rn= (TextView) findViewById(R.id.tv_jump_rn);
        tv_jump_rn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToRN();
            }
        });
    }
    public void jumpToRN(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
