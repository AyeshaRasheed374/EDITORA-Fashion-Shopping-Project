package com.example.ayeshafinalappproject.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ayeshafinalappproject.Modules.Authentication.View.LoginView
import com.example.ayeshafinalappproject.Modules.Authentication.View.PhoneSignupView
import com.example.ayeshafinalappproject.Modules.Authentication.View.SignUpView
import com.example.ayeshafinalappproject.Modules.Authentication.View.VerificationCodeView
import com.example.ayeshafinalappproject.Modules.Home.Model.Product
import com.example.ayeshafinalappproject.Modules.Home.View.ManageAddressView
import com.example.ayeshafinalappproject.Modules.Home.View.OrdersView
import com.example.ayeshafinalappproject.Modules.Onboarding.View.OnboardingView
import com.example.ayeshafinalappproject.Modules.PaymentCheckout.View.CheckoutView
import com.example.ayeshafinalappproject.Modules.PaymentCheckout.View.OrderConfirmationView
import com.example.ayeshafinalappproject.Modules.PaymentCheckout.View.PaymentMethodView
import com.example.ayeshafinalappproject.Modules.Policies.View.ContactUsView
import com.example.ayeshafinalappproject.Modules.Policies.View.HelpAndSupportView
import com.example.ayeshafinalappproject.Modules.Policies.View.PrivacyPolicyView
import com.example.ayeshafinalappproject.Modules.Policies.View.TermsOfServiceView
import com.example.ayeshafinalappproject.Modules.ProductDetail.View.ProductDetailView
import com.example.ayeshafinalappproject.Modules.Splash.View.LanguageSelectionView
import com.example.ayeshafinalappproject.Modules.Splash.View.SplashView

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashView(onNext = { navController.navigate("language_selection") })
        }
        composable("language_selection") {
            LanguageSelectionView(onContinue = { navController.navigate("onboarding") })
        }
        composable("onboarding") {
            OnboardingView(onFinish = { navController.navigate("login") })
        }
        composable("login") {
            LoginView(
                onLoginClick = { navController.navigate("main") },
                onSignUpClick = { navController.navigate("phone_signup") },
                onGoogleClick = { /* Google Login */ }
            )
        }
        composable("phone_signup") {
            PhoneSignupView(onSendOTP = { navController.navigate("verification") })
        }
        composable("verification") {
            VerificationCodeView(
                onVerify = { navController.navigate("signup") },
                onBack = { navController.popBackStack() }
            )
        }
        composable("signup") {
            SignUpView(
                onSignUpClick = { navController.navigate("main") },
                onLoginClick = { navController.navigate("login") }
            )
        }
        composable("main") {
            MainScreen(
                onNavigateToProduct = { productId -> navController.navigate("product_detail/$productId") },
                onLogout = { navController.navigate("login") { popUpTo(0) } },
                onNavigateToCheckout = { navController.navigate("checkout") },
                onNavigateToProfileSection = { section -> navController.navigate(section) }
            )
        }
        composable(
            "product_detail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            // In a real app, fetch product by ID. Here we use a dummy.
            ProductDetailView(
                product = Product("1", "Grey Pullover", 4599.0, android.R.drawable.ic_menu_gallery, "Tops"),
                onBack = { navController.popBackStack() },
                onAddToCart = { navController.navigate("main") }
            )
        }
        composable("checkout") {
            CheckoutView(
                onBack = { navController.popBackStack() },
                onContinue = { navController.navigate("payment_method") }
            )
        }
        composable("payment_method") {
            PaymentMethodView(
                onBack = { navController.popBackStack() },
                onContinue = { navController.navigate("order_confirmation") }
            )
        }
        composable("order_confirmation") {
            OrderConfirmationView(
                onBack = { navController.navigate("main") },
                onContinueShopping = { navController.navigate("main") },
                onViewOrderDetails = { navController.navigate("orders") }
            )
        }
        composable("orders") { OrdersView(onBack = { navController.popBackStack() }) }
        composable("wishlist") { /* Handled within MainScreen, but can be separate */ }
        composable("address") { ManageAddressView(onBack = { navController.popBackStack() }, onAddAddress = {}) }
        composable("terms") { TermsOfServiceView(onBack = { navController.popBackStack() }) }
        composable("privacy") { PrivacyPolicyView(onBack = { navController.popBackStack() }) }
        composable("help") { HelpAndSupportView(onBack = { navController.popBackStack() }) }
        composable("contact") { ContactUsView(onBack = { navController.popBackStack() }) }
    }
}
