package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val item: MenuItem = menu.findItem(R.id.loginFragment)
        if (item != null) item.setVisible(false)
    }

    lateinit var binding: WelcomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.welcome_fragment, container, false)
        binding.fragment = this
        return binding.root
    }



    companion object {
        @JvmStatic
        fun newInstance() = WelcomeFragment()
    }


    fun onNextClick(view: View){
//        WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
        findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
    }
}
