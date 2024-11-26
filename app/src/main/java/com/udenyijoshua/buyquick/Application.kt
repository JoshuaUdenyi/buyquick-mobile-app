package com.udenyijoshua.buyquick

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.udenyijoshua.buyquick.screens.toplevelscreens.Bag
import com.udenyijoshua.buyquick.screens.toplevelscreens.Home
import com.udenyijoshua.buyquick.screens.toplevelscreens.Profile
import com.udenyijoshua.buyquick.screens.toplevelscreens.Shop

// Sealed class for defining all the routes
sealed class TopLevelRoute(val route: String, val name: String, val icon: Int) {
    data object Home : TopLevelRoute("home_route", "Home", R.drawable.profile_icon)
    data object Shop : TopLevelRoute("shop_route", "Shop", R.drawable.shop_icon)
    data object Bag : TopLevelRoute("bag_route", "Bag", R.drawable.shopping_icon)
    data object Profile : TopLevelRoute("profile_route", "Profile", R.drawable.profile_icon)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Application(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    val topLevelRoutes = listOf(
        TopLevelRoute.Home,
        TopLevelRoute.Shop,
        TopLevelRoute.Bag,
        TopLevelRoute.Profile
    )
    Scaffold(
        bottomBar = { BottomNavigationComponent(navController,topLevelRoutes) }
    ) {
        NavHost(navController = navController, startDestination = TopLevelRoute.Home.route) {
            composable(TopLevelRoute.Home.route) { Home() }
            composable(TopLevelRoute.Shop.route) { Shop() }
            composable(TopLevelRoute.Bag.route) { Bag() }
            composable(TopLevelRoute.Profile.route) { Profile() }
        }
    }
}

@Composable
fun BottomNavigationComponent(
    navController: NavHostController,
    topLevelRoutes: List<TopLevelRoute>,
    modifier: Modifier = Modifier
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        topLevelRoutes.forEach { route ->
            NavigationBarItem(
                icon = {
                    // Use ImageVector from drawable resource
                    Icon(
                        painter = painterResource(id = route.icon),
                        contentDescription = route.name
                    )
                },
                label = { Text(route.name) },
                selected = currentDestination?.route == route.route,
                onClick = {
                    // Safely navigate and ensure correct behavior
                    navController.navigate(route.route) {
                        // Ensure single top behavior and preserve backstack state
                        launchSingleTop = true
                        restoreState = false
                    }
                },
                alwaysShowLabel = true
            )
        }
    }
}
