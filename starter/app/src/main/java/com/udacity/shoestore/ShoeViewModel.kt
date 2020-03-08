package com.udacity.shoestore

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber
import java.util.ArrayList

class ShoeViewModel : ViewModel() {

     var shoe: Shoe = Shoe()


    private val shoeList: MutableLiveData<ArrayList<Shoe>> = MutableLiveData<ArrayList<Shoe>>()

    init {
        shoeList.value = arrayListOf()
    }
    fun getShoeList(): LiveData<ArrayList<Shoe>> {
        return shoeList
    }

    fun addShoeToList(shoe: Shoe) {
        shoeList.value?.add(shoe)
    }



    fun createShoe(name: String,  size: String, company: String, descreption: String )  {
        if (name.isBlank() || name.isEmpty()){  return}
        if (name.isBlank() || name.isEmpty()){  return}
        if (name.isBlank() || name.isEmpty()){  return}
        if (name.isBlank() || name.isEmpty()){  return}


        shoeList.value?.forEach{
            Timber.d(it.toString())
        }

        Timber.d("moataz" +" " + name+" " + size.toDouble()+" " + company+" " + descreption)
        setNewDestination(DetailFragmentDirections.actionDetailFragmentToShoeListFragment().actionId)
    }


    fun createShoe()  {

        if (shoe.name.isBlank() || shoe.name.isEmpty()){  return}
        if (shoe.company.isBlank() || shoe.company.isEmpty()){  return}
        if (shoe.size <= 0 ){  return}
        if (shoe.description.isBlank() || shoe.description.isEmpty()){  return}

        Timber.d(shoe.toString())
        addShoeToList(shoe)
      setNewDestination(DetailFragmentDirections.actionDetailFragmentToShoeListFragment().actionId)
    }



    private val newDestination: MutableLiveData<Int> = MutableLiveData<Int>()

    fun getNewDestination(): LiveData<Int>? {
        return newDestination
    }

    fun setNewDestination(destinationId: Int?) {
        newDestination.value = destinationId
    }
}
