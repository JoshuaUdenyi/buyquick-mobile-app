package com.udenyijoshua.buyquick

import android.annotation.SuppressLint
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.udenyijoshua.buyquick.screens.toplevelscreens.Bag
import com.udenyijoshua.buyquick.screens.toplevelscreens.Home
import com.udenyijoshua.buyquick.screens.toplevelscreens.Profile
import com.udenyijoshua.buyquick.screens.toplevelscreens.Shop
import com.udenyijoshua.buyquick.viewmodel.AuthState
import com.udenyijoshua.buyquick.viewmodel.AuthViewModel

// Sealed class for defining all the routes
sealed class TopLevelRoute(val route: String, val name: String, val icon: Int) {
    data object Home : TopLevelRoute("home_route", "Home", R.drawable.profile_icon)
    data object Shop : TopLevelRoute("shop_route", "Shop", R.drawable.shop_icon)
    data object Bag : TopLevelRoute("bag_route", "Bag", R.drawable.shopping_icon)
    data object Profile : TopLevelRoute("profile_route", "Profile", R.drawable.profile_icon)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Application(authViewModel: AuthViewModel, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val authState = authViewModel.authState.collectAsState()

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> {
                context.startActivity(Intent(context, AuthFlow::class.java))
                (context as? ComponentActivity)?.finish()
            }

            else -> Unit
        }
    }

    val navController = rememberNavController()
    val topLevelRoutes = listOf(
        TopLevelRoute.Home,
        TopLevelRoute.Shop,
        TopLevelRoute.Bag,
        TopLevelRoute.Profile
    )
    Scaffold(
        bottomBar = { BottomNavigationComponent(navController, topLevelRoutes) }
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

            val isSelected = currentDestination?.route == route.route
            NavigationBarItem(
                icon = {
                    // Use ImageVector from drawable resource
                    Icon(
                        painter = painterResource(id = route.icon),
                        contentDescription = route.name,
                        tint = if (isSelected) Color.Red else Color.Gray
                    )
                },
                label = {
                    Text(
                        route.name,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) Color.Black else Color.Gray
                    )
                },
                selected = isSelected,
                onClick = {
                    // Safely navigate and ensure correct behavior
                    navController.navigate(route.route) {
                        // Ensure single top behavior and preserve backstack state
                        launchSingleTop = true
                        restoreState = false
                    }
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Red
                )
            )
        }
    }
}
