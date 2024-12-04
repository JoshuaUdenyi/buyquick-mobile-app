package com.udenyijoshua.buyquick.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.udenyijoshua.buyquick.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel(){
     private val db = Firebase.firestore

     private val _productCategories = MutableStateFlow<List<Product>>(emptyList())
     val productCategories: StateFlow<List<Product>> = _productCategories

     private var listenerRegistration: ListenerRegistration? = null

     init {
          fetchProductCategories()
     }

     private fun fetchProductCategories(){
          db.collection("products")
               .addSnapshotListener{ snapshot, error ->
                    if(error!=null){
                         return@addSnapshotListener
                    }

                    if (snapshot != null){
                         val products = snapshot.documents.map { document ->
                              val data = document.data ?: emptyMap()
                              Product(
                                   productName = data["productName"] as? String ?: "",
                                   productBrand = data["productBrand"] as? String ?: "",
                                   productPrice = data["productPrice"] as? Double ?: 0.0,
                                   isProductNew = data["isProductNew"] as? Boolean ?: false,
                                   productImageUrl = data["productImageUrl"] as? String ?: "",
                                   productRating = data["productRating"] as? Double ?: 0.0,
                                   ratingCount = data["ratingCount"] as? Double ?: 0.0,
                                   productDiscount = data["productDiscount"] as? Double ?: 0.0,
                                   productHasDiscount = data["productHasDiscount"] as? Boolean ?: false
                              )
                         }
//                         _productCategories.value = snapshot.toObjects(Product::class.java)

                         _productCategories.value = products
                    }
               }
     }

     override fun onCleared() {
          super.onCleared()
          listenerRegistration?.remove() // Remove the snapshot listener to avoid memory leaks
     }
}