package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import timber.log.Timber


class ShoeListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListFragment()
    }

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var  itemBinding: ShoeListItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.shoe_list_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(it).get(ShoeViewModel::class.java)

        }

        binding.navDirection = ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getShoeList().observe(viewLifecycleOwner, Observer {

            it.forEach{
                itemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.shoe_list_item, binding.shoeListLL, false )
                itemBinding.nameTv.text = it.name
                itemBinding.sizeTv.text = it.size.toString()
                itemBinding.companyTv.text = it.company
                itemBinding.descreptionTv.text = it.description

                binding.shoeListLL.addView(itemBinding.root)


            }


        })


        viewModel.getNewDestination()?.observe(viewLifecycleOwner, Observer {

            it?.let {

                findNavController().navigate(it)
                viewModel.setNewDestination(null)
            }


        })

    }

}
