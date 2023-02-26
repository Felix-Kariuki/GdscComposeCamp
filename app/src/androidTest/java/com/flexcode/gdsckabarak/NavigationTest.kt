package com.flexcode.gdsckabarak

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.flexcode.gdsckabarak.navigation.GdscAppNavigationHost
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setUpNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            GdscAppNavigationHost(navController = navController)
        }
    }

    @Test
    fun verifyLoginScreen_is_the_start_destination(){
        composeTestRule
            .onNodeWithText("Continue")
            .assertIsDisplayed()
    }

   /*@Test
    fun verify_click_on_login_button_navigates_to_home_screen(){
        composeTestRule.onNodeWithText("Continue")
            .performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        Assert.assertEquals(route, "$HOME_SCREEN/{data}")
    }*/

}