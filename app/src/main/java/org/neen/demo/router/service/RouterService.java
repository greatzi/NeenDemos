package org.neen.demo.router.service;


import org.neen.annotation.router.CombinationUri;
import org.neen.annotation.router.FullUri;
import org.neen.annotation.router.IntentExtrasParam;
import org.neen.annotation.router.UriParam;
import org.neen.demo.router.model.User;

import java.util.ArrayList;

public interface RouterService {

    @CombinationUri(scheme = "router", host = "org.neen.demo.router.secondactivity")
    void startSecondActivity(@UriParam("preActivity") String preActivity, @IntentExtrasParam("stringParam") String stringParam, @IntentExtrasParam("intParam") int intParam);

    @CombinationUri(scheme = "router", host = "org.neen.demo.router", port = "8080", path = "/activity/third")
    void startThirdActivity(@UriParam("preActivity") String preActivity, @IntentExtrasParam("array") ArrayList<Integer> array);

    @FullUri("router://org.neen.demo.router.forthactivity")
    void startForthActivity(@UriParam("preActivity") String preActivity, @IntentExtrasParam("user") User user);

    @FullUri("router://org.neen.demo.router.fifthactivity")
    void startFifthActivity(@UriParam("preActivity") String preActivity, @IntentExtrasParam("users") ArrayList<User> users);
}
