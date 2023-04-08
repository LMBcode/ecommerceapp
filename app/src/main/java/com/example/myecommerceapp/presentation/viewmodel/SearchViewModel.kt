package com.example.myecommerceapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myecommerceapp.domain.model.Shoe
import com.example.myecommerceapp.domain.model.ShoeProvider
import com.example.myecommerceapp.domain.model.shoe.AllShoesObject

class SearchViewModel() : ViewModel() {

    private val _search = MutableLiveData<List<Shoe>>()
    val search : LiveData<List<Shoe>> get() = _search

    init {
        loadShoes()
    }

    private fun loadShoes(){
        _search.postValue(AllShoesObject.getShoes())
    }

    fun performQuery(
        query : String
    ){
        val listOfShoes = AllShoesObject.getShoes()
        val filteredList = ArrayList<Shoe>()
        listOfShoes.forEach{ shoes ->
            if(shoes.shoeName!!.lowercase().contains(query.lowercase()) || shoes.shoeBrand!!.lowercase().contains(query.lowercase())){
                filteredList.add(Shoe(shoeName = shoes.shoeName, shoeImage = shoes.shoeImage, shoeBrand = shoes.shoeBrand, shoePrice = shoes.shoePrice,
                    shoeBackSide = shoes.shoeBackSide, shoeFrontSide = shoes.shoeFrontSide, shoeSide = shoes.shoeSide))
            }
        }
        _search.postValue(filteredList)
    }


}