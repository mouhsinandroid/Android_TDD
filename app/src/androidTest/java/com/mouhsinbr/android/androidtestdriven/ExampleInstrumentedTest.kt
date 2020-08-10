package com.mouhsinbr.android.androidtestdriven

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun user_can_enter_user_name() {
        onView(withId(R.id.firstName)).perform(typeText("Jan"))
    }

    @Test
    fun user_can_enter_last_name() {
        onView(withId(R.id.lastName)).perform(typeText("Carlos"))
    }

    @Test
    fun when_user_enters_first_and_last_name_check_to_confirm_that_message_is_correct() {
        onView(withId(R.id.firstName)).perform(typeText("Jan"))
        onView(withId(R.id.lastName)).perform(typeText("Carlos"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message)).check(matches(withText("Welcome, Jan Carlos")))

    }

    @Test
    fun first_message_again() {
        onView(withId(R.id.firstName)).perform(typeText("Ronaldo"))
        onView(withId(R.id.lastName)).perform(typeText("Manel"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message)).check(matches(withText("Welcome, Ronaldo Manel")))

    }
}