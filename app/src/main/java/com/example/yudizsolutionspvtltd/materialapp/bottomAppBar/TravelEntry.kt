package com.example.yudizsolutionspvtltd.materialapp.bottomAppBar

import android.content.res.Resources
import android.net.Uri
import com.example.yudizsolutionspvtltd.materialapp.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.util.*

class TravelEntry(
        val title: String, dynamicUrl: String, val url: String, val price: String, val description: String) {
    val dynamicUrl: Uri = Uri.parse(dynamicUrl)

    companion object {
        fun initProductEntryList(resources: Resources): List<TravelEntry> {
            val inputStream = resources.openRawResource(R.raw.products)
            val jsonProductsString = inputStream.bufferedReader().use(BufferedReader::readText)
            val gson = Gson()
            val productListType = object : TypeToken<ArrayList<TravelEntry>>() {}.type
            return gson.fromJson<List<TravelEntry>>(jsonProductsString, productListType)
        }
    }
}