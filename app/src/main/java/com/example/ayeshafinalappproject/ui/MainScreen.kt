package com.example.ayeshafinalappproject.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ayeshafinalappproject.Modules.Home.View.HomeView
import com.example.ayeshafinalappproject.Modules.Home.View.ProfileView
import com.example.ayeshafinalappproject.Modules.Wishlist.View.WishlistView
import com.example.ayeshafinalappproject.Modules.Cart.View.CartView
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    object Home : BottomBarScreen("home_content", "Home", Icons.Default.Home)
    object Category : BottomBarScreen("category", "Category", Icons.Default.GridView)
    object Cart : BottomBarScreen("cart_content", "Cart", Icons.Default.ShoppingCart)
    object Favourites : BottomBarScreen("favourites", "Favourites", Icons.Default.Favorite)
    object Profile : BottomBarScreen("profile_content", "Profile", Icons.Default.Person)
}

@Composable
fun MainScreen(
    onNavigateToProduct: (String) -> Unit,
    onLogout: () -> Unit,
    onNavigateToCheckout: () -> Unit,
    onNavigateToProfileSection: (String) -> Unit
) {
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = BottomBarScreen.Home.route) {
                HomeView(onProductClick = { product -> onNavigateToProduct(product.id) })
            }
            composable(route = BottomBarScreen.Category.route) {
                Text("Category View")
            }
            composable(route = BottomBarScreen.Cart.route) {
                CartView(onBack = { navController.popBackStack() }, onCheckout = onNavigateToCheckout)
            }
            composable(route = BottomBarScreen.Favourites.route) {
                WishlistView(onBack = { navController.popBackStack() }, onProductClick = { onNavigateToProduct(it.id) })
            }
            composable(route = BottomBarScreen.Profile.route) {
                ProfileView(onNavigate = onNavigateToProfileSection, onLogout = onLogout)
            }
        }
    }
}

@Composable
fun BottomNavigation(navController: androidx.navigation.NavHostController) {
    val screens = listOf(
        BottomBarScreen.Category,
        BottomBarScreen.Cart,
        BottomBarScreen.Home,
        BottomBarScreen.Favourites,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(containerColor = Color.White) {
        screens.forEach { screen ->
            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title, fontSize = 10.sp) },
                selected = selected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = PrimaryPink,
                    selectedTextColor = PrimaryPink,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
