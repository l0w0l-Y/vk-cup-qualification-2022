package com.kaleksandra.vkcupqualification2022

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kaleksandra.featurecategory.CategoryScreen
import com.kaleksandra.coretheme.VKCupQualification2022Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKCupQualification2022Theme {
                CategoryScreen()
            }
        }
    }
}
