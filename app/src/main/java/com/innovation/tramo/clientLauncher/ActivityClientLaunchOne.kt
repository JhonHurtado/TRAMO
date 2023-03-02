package com.innovation.tramo.clientLauncher

import android.os.Bundle
import android.view.Menu
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.innovation.tramo.R
//import com.innovation.tramo.clientLauncher.databinding.ActivityClientLaunchOneBinding
import com.innovation.tramo.databinding.ActivityClientLaunchOneBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton



class ActivityClientLaunchOne : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityClientLaunchOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityClientLaunchOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarActivityClientLaunchOne.toolbar)
//-----------------------------------------------------------------------------------------------

        val button1 = findViewById<FloatingActionButton>(R.id.btn1)
        val button2 = findViewById<FloatingActionButton>(R.id.btn2)

        button1.visibility = View.GONE
        button2.visibility = View.GONE

        binding.appBarActivityClientLaunchOne.fab.setOnClickListener { view ->
            if (button1.visibility == View.VISIBLE && button2.visibility == View.VISIBLE) {
                button1.visibility = View.GONE
                button2.visibility = View.GONE
            } else {
                button1.visibility = View.VISIBLE
                button2.visibility = View.VISIBLE
            }
        }







//-------------------------------------------------------------------------------------------------
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController =
            findNavController(R.id.nav_host_fragment_content_activity_client_launch_one)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_pqrs
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_client_launch_one, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =
            findNavController(R.id.nav_host_fragment_content_activity_client_launch_one)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}