package com.udenyijoshua.buyquick

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.udenyijoshua.buyquick.data.TopLevelRoute
import com.udenyijoshua.buyquick.screens.toplevelscreens.Home

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Application() {
    Scaffold(
        bottomBar = {
            BottomNavigationComponent()
        }
    ) {
        Home()
    }
}


@Composable
fun BottomNavigationComponent(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val topLevelRoutes = listOf(
        TopLevelRoute(
            name = "Home",
            route = "profile_route",
            icon = ImageVector.vectorResource(R.drawable.profile_icon)
        ),
        TopLevelRoute(
            name = "Shop",
            route = "profile_route",
            icon = ImageVector.vectorResource(R.drawable.shop_icon)
        ),
        TopLevelRoute(
            name = "Bag",
            route = "friends_route",
            icon = ImageVector.vectorResource(R.drawable.shopping_icon)
        ),
        TopLevelRoute(
            name = "Profile",
            route = "profile_route",
            icon = ImageVector.vectorResource(R.drawable.profile_icon)
        ),
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        topLevelRoutes.forEach{topLevelRoute ->
            NavigationBarItem(
                icon = { Icon(topLevelRoute.icon, contentDescription = topLevelRoute.name) },
                label = { Text(topLevelRoute.name) },
//                Use this for more complex type for routes
//                selected = currentDestination?.hierarchy?.any { it.hasRoute(topLevelRoute.route::class) } == true,
                selected = currentDestination?.route == topLevelRoute.route,
                onClick = {},
                alwaysShowLabel = true,
                modifier = Modifier,
            )
        }
    }
}

