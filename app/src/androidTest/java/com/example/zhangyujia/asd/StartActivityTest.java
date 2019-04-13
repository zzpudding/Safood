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
public class StartActivityTest {

    @Rule
    public ActivityTestRule<StartActivity> mActivityTestRule = new ActivityTestRule<>(StartActivity.class);


    @Test
    public void startActivityTest() {
       onView(withId(R.id.signIn_btn)).perform(click());
    }

}
