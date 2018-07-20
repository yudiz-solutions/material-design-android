package com.example.yudizsolutionspvtltd.materialapp.bottomAppBar

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.yudizsolutionspvtltd.materialapp.R
import com.example.yudizsolutionspvtltd.materialapp.backdrop.BackDropActivity
import com.example.yudizsolutionspvtltd.materialapp.backdrop.StaggeredProductCardRecyclerViewAdapter
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_bottom_app_behaviour.*

class BottomAppbarBehaviourActivity : AppCompatActivity() {

    var counter = 0
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_behaviour)
        setSupportActionBar(appbar)
        setCardRecyclerView()
        changeStatusBarColor(this.getColor(android.R.color.white))
        listener()

    }

    fun changeStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }

    fun resetFabChanges(){
        counter=0
        appbar.navigationIcon = this.getDrawable(R.drawable.ic_menu_24dp)
        appbar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        appbar.replaceMenu(R.menu.bottom_appbar_menu_primary)
        fab_bar?.setImageDrawable(this.getDrawable(R.drawable.ic_local_florist_black_24dp))
    }
    private fun listener() {
        fab_bar.setOnClickListener {
            if (counter == 0) {
                counter++
                appbar.navigationIcon = null
                appbar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                appbar.replaceMenu(R.menu.bottom_appbar_menu_secondary)
                fab_bar?.setImageDrawable(this.getDrawable(R.drawable.ic_keyboard_return_black_24dp))
            } else {
                var iNagigation = Intent(this, BackDropActivity::class.java)
                startActivity(iNagigation)
            }
        }
    }
//        app_bar.setNavigationItemSelectedListener { menuItem ->
//            //            // Bottom Navigation Drawer menu item clicks
//            when (menuItem!!.itemId) {
//                R.id.nav1 -> context!!.toast(getString(R.string.nav1_clicked))
//                R.id.nav2 -> context!!.toast(getString(R.string.nav2_clicked))
//                R.id.nav3 -> context!!.toast(getString(R.string.nav3_clicked))
//            }
//            true
//        }


    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    private fun setCardRecyclerView() {
        recycler_view.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position % 3 == 2) 2 else 1
            }
        }
        recycler_view.layoutManager = gridLayoutManager
        val adapter = StaggeredProductCardRecyclerViewAdapter(
                TravelEntry.initProductEntryList(resources))
        recycler_view.adapter = adapter
        val largePadding = resources.getDimensionPixelSize(R.dimen._10sdp)
        val smallPadding = resources.getDimensionPixelSize(R.dimen._10sdp)
        recycler_view.addItemDecoration(TravelGridItemDecoration(largePadding, smallPadding))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_appbar_menu_primary, menu)
        return true
    }

    private fun displayMaterialSnackBar() {
        val marginSide = 0
        val marginBottom = 550
        val snackbar = Snackbar.make(
                toolbar,
                "FAB Clicked",
                Snackbar.LENGTH_LONG
        ).setAction("UNDO") { }
        snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.colorAccent))

        val snackbarView = snackbar.view
        val params = snackbarView.layoutParams as CoordinatorLayout.LayoutParams

        params.setMargins(
                params.leftMargin + marginSide,
                params.topMargin,
                params.rightMargin + marginSide,
                params.bottomMargin + marginBottom
        )

        snackbarView.layoutParams = params
        snackbar.show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
            R.id.app_bar_fav -> Toast.makeText(this, "Fav menu item is clicked!", Toast.LENGTH_LONG).show()
            R.id.app_bar_search -> Toast.makeText(this, "Search menu item is clicked!", Toast.LENGTH_LONG).show()
            R.id.app_bar_settings -> Toast.makeText(this, "Settings item is clicked!", Toast.LENGTH_LONG).show()
            R.id.app_bar_archieve -> resetFabChanges()
        }
        return true
    }


//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when (item!!.itemId) {
//            R.id.app_bar_fav -> Toast.makeText(this, "Fav menu item is clicked!", Toast.LENGTH_LONG).show()
//            R.id.app_bar_search -> Toast.makeText(this, "Search menu item is clicked!", Toast.LENGTH_LONG).show()
//            R.id.app_bar_settings -> Toast.makeText(this, "Settings item is clicked!", Toast.LENGTH_LONG).show()
//
//        }
//
//        return true
//    }
}
