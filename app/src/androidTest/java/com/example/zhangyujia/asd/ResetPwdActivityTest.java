package com.example.zhangyujia.asd;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ResetPwdActivityTest {

    @Rule
    public ActivityTestRule<ResetPwdActivity> mActivityTestRule = new ActivityTestRule<>(ResetPwdActivity.class);

    @Test
    public void resetPasswordActivityTest() {
        onView(withId(R.id.resetEmail_eT)).perform(typeText("liu.7707@osu.edu"),closeSoftKeyboard());
        onView(withId(R.id.resetPwd_btn)).perform(click());

    }
}
