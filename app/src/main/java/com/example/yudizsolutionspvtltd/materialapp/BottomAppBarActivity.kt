package com.example.yudizsolutionspvtltd.materialapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizsolutionspvtltd.materialapp.bottomAppBar.BottomNavigationDrawerFragment
import kotlinx.android.synthetic.main.activity_bottom_appbar.*

class BottomAppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_appbar)
        setSupportActionBar(bar)
        bar.setNavigationOnClickListener {
            println("bottomNavDrawerFragment called")

            val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
            bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)

        }
//        bar.setNavigationItemSelectedListener { menuItem ->
//            // Bottom Navigation Drawer menu item clicks
//            when (menuItem!!.itemId) {
//                R.id.nav1 -> context!!.toast(getString(R.string.nav1_clicked))
//                R.id.nav2 -> context!!.toast(getString(R.string.nav2_clicked))
//                R.id.nav3 -> context!!.toast(getString(R.string.nav3_clicked))
//            }
//            true
//        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.app_bar_fav -> Toast.makeText(this, "Fav menu item is clicked!", Toast.LENGTH_LONG).show()
            R.id.app_bar_search -> Toast.makeText(this, "Search menu item is clicked!", Toast.LENGTH_LONG).show()
            R.id.app_bar_settings -> Toast.makeText(this, "Settings item is clicked!", Toast.LENGTH_LONG).show()

        }

        return true
    }


}