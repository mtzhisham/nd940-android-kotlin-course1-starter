package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.ArrayList

class ShoeViewModel : ViewModel() {

    private val shoeList: MutableLiveData<ArrayList<Shoe>> = MutableLiveData<ArrayList<Shoe>>()

    fun getShoeList(): LiveData<ArrayList<Shoe>> {
        return shoeList
    }

    fun addShoeToList(shoe: Shoe) {
        shoeList.value?.add(shoe)
    }


}
