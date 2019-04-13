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
public class AddRecipeActivityTest {

    @Rule
    public ActivityTestRule<AddRecipeActivity> mActivityTestRule = new ActivityTestRule<>(AddRecipeActivity.class);

    @Test
    public void addRecipeActivityTest() {
        onView(withId(R.id.etRecipeName)).perform(typeText("Espresso Test Menu"));
        onView(withId(R.id.etIngredient1)).perform(typeText("Espresso Ingredient1"));
        onView(withId(R.id.etIngredient2)).perform(typeText("Espresso Ingredient2"));
        onView(withId(R.id.etIngredient3)).perform(typeText("Espresso Ingredient3"),closeSoftKeyboard());
        onView(withId(R.id.btnAddRecipe)).perform(click());
    }
}
