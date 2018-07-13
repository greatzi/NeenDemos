package org.neen.demo.router;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.neen.demo.R;
import org.neen.demo.router.model.User;
import org.neen.demo.router.service.RouterService;
import org.neen.router.api.Router;
import org.neen.router.api.RouterInjector;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    public RouterService routerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        routerService = new Router(this).create(RouterService.class);
        RouterInjector.inject(this);

        Button startSecondActivityBtn = (Button) findViewById(R.id.btn_start_second_activity);
        startSecondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                routerService.startSecondActivity("FirstActivity", "字符串参数", 2018);
            }
        });


        Button startThirdActivityBtn = (Button) findViewById(R.id.btn_start_third_activity);
        startThirdActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Integer> array = new ArrayList<>();
                array.add(0);
                array.add(1);
                array.add(1);
                array.add(2);
                array.add(3);
                array.add(5);
                routerService.startThirdActivity("FirstActivity", array);
            }
        });

        Button startFourthActivityBtn = (Button) findViewById(R.id.btn_start_fourth_activity);
        startFourthActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("小叶子", 17, 165, 88);
                routerService.startForthActivity("FirstActivity", user);
            }
        });

        Button startFifthActivityBtn = (Button) findViewById(R.id.btn_start_fifth_activity);
        startFifthActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<User> users = new ArrayList<>();
                users.add(new User("James Cokie", 17, 165, 88));
                users.add(new User("Lily Crusie", 16, 175, 88));
                routerService.startFifthActivity("FirstActivity", users);
            }
        });
    }
}
