package com.udacity.shoestore

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.udacity.shoestore.models.Shoe

class ShoesObservable : BaseObservable() {

    val shoe = Shoe()

    @Bindable
    fun getName() : String{
        return shoe.name
    }

    @Bindable
    fun getSize() : Double{
        return shoe.size
    }

    @Bindable
    fun getCompany() : String{
        return shoe.company
    }


    @Bindable
    fun getDescription() : String{
        return shoe.description
    }


}