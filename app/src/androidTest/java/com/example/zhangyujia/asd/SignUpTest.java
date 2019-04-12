package com.example.zhangyujia.asd;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SignUpTest {
    private static final String TAG="signUpActivity";
    @Rule
    public ActivityTestRule<SignUpActivity> mActivityTestRule = new ActivityTestRule<>(SignUpActivity.class);


    @Test
    public void signUpTest() {
        onView(withId(R.id.etUsername)).perform(typeText("ttttttttt@safood.com"));
        onView(withId(R.id.etPassword1)).perform(typeText("123123"));
        onView(withId(R.id.etPassword2)).perform(typeText("123123"),closeSoftKeyboard());
        onView(withId(R.id.signUpConfirm_btn)).perform(click());
    }

}
