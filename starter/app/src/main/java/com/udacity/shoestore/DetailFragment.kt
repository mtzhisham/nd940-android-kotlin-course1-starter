package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }


    private lateinit var binding: DetailFragmentBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.detail_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it).get(ShoeViewModel::class.java)

        }

        binding.navDirectionBack = DetailFragmentDirections.actionDetailFragmentToShoeListFragment()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getNewDestination()?.observe(viewLifecycleOwner, Observer {

            it?.let {

                Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
                findNavController().navigate(it)
                viewModel.setNewDestination(null)
            }


        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
