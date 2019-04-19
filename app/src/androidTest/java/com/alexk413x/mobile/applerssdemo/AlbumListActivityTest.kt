package com.alexk413x.mobile.applerssdemo


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AlbumListActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(AlbumListActivity::class.java)

    @Test
    fun albumListActivityTest() {

        Thread.sleep(30000)

        val imageView = onView(
            allOf(
                withId(R.id.album_artwork_view),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.album_list_view),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withId(R.id.album_title_view),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.album_list_view),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textView.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(
                withId(R.id.album_artist_view),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.album_list_view),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(isDisplayed()))

        val recyclerView = onView(
            allOf(
                withId(R.id.album_list_view),
                childAtPosition(
                    withClassName(`is`("android.support.constraint.ConstraintLayout")),
                    0
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        Thread.sleep(3000)

        val imageView2 = onView(
            allOf(
                withId(R.id.album_details_artwork_view),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        imageView2.check(matches(isDisplayed()))

        val button = onView(
            allOf(
                withId(R.id.album_details_goto_apple_button),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val textView3 = onView(
            allOf(
                withId(R.id.album_details_title_view),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textView3.check(matches(isDisplayed()))

        val textView4 = onView(
            allOf(
                withId(R.id.album_details_copyright_view),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        textView4.check(matches(isDisplayed()))

        pressBack()
        Thread.sleep(3000)

        val recyclerView2 = onView(
            allOf(
                withId(R.id.album_list_view),
                childAtPosition(
                    withClassName(`is`("android.support.constraint.ConstraintLayout")),
                    0
                )
            )
        )
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(1, click()))

        Thread.sleep(3000)

        val imageView3 = onView(
            allOf(
                withId(R.id.album_details_artwork_view),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        imageView3.check(matches(isDisplayed()))

        val button2 = onView(
            allOf(
                withId(R.id.album_details_goto_apple_button),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        button2.check(matches(isDisplayed()))

        val textView5 = onView(
            allOf(
                withId(R.id.album_details_artist_view),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(isDisplayed()))

        val textView6 = onView(
            allOf(
                withId(R.id.album_details_genre_view),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        textView6.check(matches(isDisplayed()))

        pressBack()
        Thread.sleep(3000)

        val recyclerView3 = onView(
            allOf(
                withId(R.id.album_list_view),
                childAtPosition(
                    withClassName(`is`("android.support.constraint.ConstraintLayout")),
                    0
                )
            )
        )
        recyclerView3.perform(actionOnItemAtPosition<ViewHolder>(9, click()))

        Thread.sleep(3000)

        val imageView4 = onView(
            allOf(
                withId(R.id.album_details_artwork_view),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        imageView4.check(matches(isDisplayed()))

        val button3 = onView(
            allOf(
                withId(R.id.album_details_goto_apple_button),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        button3.check(matches(isDisplayed()))

        val textView7 = onView(
            allOf(
                withId(R.id.album_details_genre_view),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        textView7.check(matches(isDisplayed()))

        pressBack()
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
