package com.rnjswithnative;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 00326434 on 2018/3/3.
 */

public class BActivity extends Activity {
    TextView tv_msg,tv_finish,tv_jump_rn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_activity);
        tv_msg= (TextView) findViewById(R.id.tv_msg);
        tv_finish= (TextView) findViewById(R.id.tv_finish);
        tv_jump_rn= (TextView) findViewById(R.id.tv_jump_rn);
        tv_msg.setText(getIntent().getStringExtra("msg").equals("")?"no msg from intent":getIntent().getStringExtra("msg"));
        tv_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BActivity.this.finish();
            }
        });
        tv_jump_rn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToRN();
            }
        });
    }
    public void jumpToRN(){
        Intent intent=new Intent(this,BRActivity.class);
        startActivity(intent);
        this.finish();
    }
}
