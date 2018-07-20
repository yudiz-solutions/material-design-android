package com.example.yudizsolutionspvtltd.materialapp.backdrop

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.yudizsolutionspvtltd.materialapp.R
import com.example.yudizsolutionspvtltd.materialapp.bottomAppBar.ProductCardRecyclerViewAdapter
import com.example.yudizsolutionspvtltd.materialapp.bottomAppBar.TravelEntry
import com.example.yudizsolutionspvtltd.materialapp.bottomAppBar.TravelGridItemDecoration
import kotlinx.android.synthetic.main.activity_back_drop.*

class BackDropActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_drop)
        this.setSupportActionBar(app_bar)
            app_bar.setNavigationOnClickListener(NavigationIconClickListener(
                this,
                recycler_view,
                AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(this, R.drawable.branded_menu),
                ContextCompat.getDrawable(this, R.drawable.close_menu)))

        recycler_view.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        val adapter = ProductCardRecyclerViewAdapter(
                TravelEntry.initProductEntryList(resources))
        recycler_view.adapter = adapter
        val largePadding = resources.getDimensionPixelSize(R.dimen._16sdp)
        val smallPadding = resources.getDimensionPixelSize(R.dimen._4sdp)
        recycler_view.addItemDecoration(TravelGridItemDecoration(largePadding, smallPadding))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }


}
