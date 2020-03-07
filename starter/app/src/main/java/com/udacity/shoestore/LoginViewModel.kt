package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {


    private val newDestination: MutableLiveData<Int> = MutableLiveData<Int>()

    fun getNewDestination(): LiveData<Int>? {
        return newDestination
    }

    fun setNewDestination(destinationId: Int?) {
        newDestination.value = destinationId
    }
}
