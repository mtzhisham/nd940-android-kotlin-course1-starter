package com.udacity.shoestore

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        navController = findNavController(R.id.nav_host_fragment)
        if(SharedPrefHelper.loggedIn) {
            val navHost =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
            val navController = navHost!!.navController

            val navInflater = navController.navInflater
            val graph = navInflater.inflate(R.navigation.main_navigation)
            graph.startDestination = R.id.shoeListFragment

            navController.graph = graph
        }

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)


        val appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment,R.id.welcomeFragment
            ,R.id.instructionFragment, R.id.shoeListFragment))
       val toolbar = findViewById<Toolbar>(R.id.toolbar)
            toolbar.setupWithNavController(navController, appBarConfiguration)


        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.activity_main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //I need to open the drawer onClick
        when (item!!.itemId) {
           R.id.loginFragment->{
               SharedPrefHelper.loggedIn = false
               val intent =  Intent(this, MainActivity::class.java)
               intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
               startActivity(intent)
           }

        }
        return  super.onOptionsItemSelected(item)
    }


}
