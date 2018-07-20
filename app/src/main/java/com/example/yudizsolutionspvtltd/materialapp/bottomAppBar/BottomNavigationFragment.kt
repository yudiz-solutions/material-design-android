package com.example.yudizsolutionspvtltd.materialapp.bottomAppBar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yudizsolutionspvtltd.materialapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.frg_drawer_navigation_drawer.*

class BottomNavigationFragment : BottomSheetDialogFragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.frg_drawer_navigation_drawer, container, false)
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)

            navigation_view.setNavigationItemSelectedListener { menuItem ->
                // Bottom Navigation Drawer menu item clicks
                when (menuItem.itemId) {
                // R.id.nav1 -> context!!.toast(getString(R.string.nav1_clicked))
                }
                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here
                true
            }
        }
    }