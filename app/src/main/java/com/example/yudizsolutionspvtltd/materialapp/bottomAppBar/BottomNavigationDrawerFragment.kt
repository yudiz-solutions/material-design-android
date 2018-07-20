package com.example.yudizsolutionspvtltd.materialapp.bottomAppBar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.yudizsolutionspvtltd.materialapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottomsheet.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navigation_view.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.nav1 -> Toast.makeText(activity, "Nav 1 clicked", Toast.LENGTH_LONG).show()
                R.id.nav2 -> Toast.makeText(activity, "Nav 2 clicked", Toast.LENGTH_LONG).show()
                R.id.nav3 -> Toast.makeText(activity, "Nav 3 clicked", Toast.LENGTH_LONG).show()
            }
            true
        }
    }
}