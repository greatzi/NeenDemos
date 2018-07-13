package org.neen.demo.router;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.neen.annotation.inject.Inject;
import org.neen.annotation.inject.InjectUriParam;
import org.neen.demo.R;
import org.neen.demo.router.model.User;
import org.neen.router.api.RouterInjector;

public class ForthActivity extends AppCompatActivity {

    @InjectUriParam
    String preActivity;

    @Inject
    User user;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        RouterInjector.inject(this);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        textView1.setText("preActivityName: " + preActivity);
        textView2.setText("user: " + user);
    }
}
