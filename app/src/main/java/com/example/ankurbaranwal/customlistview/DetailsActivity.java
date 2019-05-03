package com.example.ankurbaranwal.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);

        editText = (EditText)findViewById(R.id.edit);
        Bundle extra = getIntent().getExtras();
        String value,reg;

        if(extra!=null)
        {
            value = extra.getString("K1");
            reg = extra.getString("K2");
            editText.setText("Welcome "+value);
        }


    }
}
