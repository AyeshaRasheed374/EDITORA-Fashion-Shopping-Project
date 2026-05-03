package com.example.ayeshafinalappproject.Modules.Home.ViewModel

import androidx.lifecycle.ViewModel
import com.example.ayeshafinalappproject.Modules.Home.Model.Product
import com.example.ayeshafinalappproject.Modules.Home.Model.Collection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _featuredCollections = MutableStateFlow<List<Collection>>(emptyList())
    val featuredCollections: StateFlow<List<Collection>> = _featuredCollections

    private val _discoverStyleProducts = MutableStateFlow<List<Product>>(emptyList())
    val discoverStyleProducts: StateFlow<List<Product>> = _discoverStyleProducts

    init {
        loadData()
    }

    private fun loadData() {
        _featuredCollections.value = listOf(
            Collection("Dresses", android.R.drawable.ic_menu_gallery),
            Collection("Crop Tops", android.R.drawable.ic_menu_gallery)
        )

        _discoverStyleProducts.value = listOf(
            Product("1", "Cocktail Dress", 1799.0, android.R.drawable.ic_menu_gallery, "Dresses"),
            Product("2", "Floral Dress", 2999.0, android.R.drawable.ic_menu_gallery, "Dresses"),
            Product("3", "Short Dress", 2999.0, android.R.drawable.ic_menu_gallery, "Dresses"),
            Product("4", "Full Sleeve Top", 1999.0, android.R.drawable.ic_menu_gallery, "Tops"),
            Product("5", "Grey Top", 4599.0, android.R.drawable.ic_menu_gallery, "Tops")
        )
    }
}
