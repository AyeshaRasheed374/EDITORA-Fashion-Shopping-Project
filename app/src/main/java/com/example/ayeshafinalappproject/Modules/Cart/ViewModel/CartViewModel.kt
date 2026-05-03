package com.example.ayeshafinalappproject.Modules.Cart.ViewModel

import androidx.lifecycle.ViewModel
import com.example.ayeshafinalappproject.Modules.Cart.Model.CartItem
import com.example.ayeshafinalappproject.Modules.Home.Model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems.asStateFlow()

    init {
        // Sample data
        _cartItems.value = listOf(
            CartItem(
                Product("1", "Grey Pullover", 4599.0, android.R.drawable.ic_menu_gallery, "Tops"),
                1, "XS", "Grey"
            ),
            CartItem(
                Product("2", "Cocktail Dress", 1799.0, android.R.drawable.ic_menu_gallery, "Dresses"),
                1, "L", "Black"
            )
        )
    }

    fun updateQuantity(item: CartItem, delta: Int) {
        _cartItems.update { currentList ->
            currentList.map {
                if (it == item) {
                    val newQuantity = (it.quantity + delta).coerceAtLeast(1)
                    it.copy(quantity = newQuantity)
                } else it
            }
        }
    }

    fun removeItem(item: CartItem) {
        _cartItems.update { currentList ->
            currentList.filter { it != item }
        }
    }

    fun getSubtotal(): Double = _cartItems.value.sumOf { it.product.price * it.quantity }
}
