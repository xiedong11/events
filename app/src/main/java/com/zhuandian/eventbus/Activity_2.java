package com.zhuandian.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_2 extends AppCompatActivity {

    private Button mButton;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mButton = (Button) findViewById(R.id.btn);
        mEditText = (EditText) findViewById(R.id.ed_content);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contentStr = mEditText.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("value",contentStr);

                setResult(3,intent);
                finish();
            }
        });
    }
}
