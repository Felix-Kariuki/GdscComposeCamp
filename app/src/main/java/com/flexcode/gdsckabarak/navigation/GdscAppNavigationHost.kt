package com.flexcode.gdsckabarak.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.flexcode.gdsckabarak.home.HomeScreen
import com.flexcode.gdsckabarak.login.LoginScreen
import com.flexcode.gdsckabarak.login.LoginViewModel
import com.flexcode.gdsckabarak.navigation.Routes.HOME_SCREEN
import com.flexcode.gdsckabarak.navigation.Routes.LOGIN_SCREEN


@Composable
fun GdscAppNavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LOGIN_SCREEN) {
        composable(route = LOGIN_SCREEN) {
            LoginScreen(
                navigateToHome = {name->
                    navController.navigate(route = "$HOME_SCREEN/${name}")
                },
                viewModel = LoginViewModel()
            )
        }

        composable(
            route = "$HOME_SCREEN/{data}",
            arguments = listOf(navArgument("data") { type = NavType.StringType })
        ) { navBackStackEntry ->
            HomeScreen(
                navigateToLogin = {
                    navController.navigate(route = LOGIN_SCREEN){
                        popUpTo(route = "$HOME_SCREEN/{data}"){inclusive = true}
                    }
                },
                data = navBackStackEntry.arguments?.getString("data")
            )
        }
    }

}