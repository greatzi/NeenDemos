package org.neen.demo.router;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.neen.annotation.inject.Inject;
import org.neen.annotation.inject.InjectUriParam;
import org.neen.demo.R;
import org.neen.router.api.RouterInjector;

public class SecondActivity extends AppCompatActivity {

    @InjectUriParam
    String preActivity;

    @Inject("stringParam")
    String stringParam;

    @Inject("intParam")
    int intParam;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        RouterInjector.inject(this);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);

        textView1.setText("preActivityName: " + preActivity);
        textView2.setText("stringParam: " + stringParam);
        textView3.setText("intParam: " + intParam);
    }
}
