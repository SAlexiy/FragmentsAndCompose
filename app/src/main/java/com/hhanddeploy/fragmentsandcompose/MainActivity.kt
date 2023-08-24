package com.hhanddeploy.fragmentsandcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.hhanddeploy.fragmentsandcompose.databinding.ActivityMainBinding
import com.hhanddeploy.fragmentsandcompose.ui.main.MainFragment
import com.hhanddeploy.fragmentsandcompose.ui.map.MapFragment

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding.root
        setContentView(view)

        replaceFragment(MainFragment.newInstance())
        activityMainBinding.navComposeView.setContent {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color = Color.Blue),
                horizontalArrangement = Arrangement.SpaceAround) {

                Box(modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.Black)
                    .clickable {
                        replaceFragment(MainFragment.newInstance())
                    })

                Box(modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.White)
                    .clickable {
                        replaceFragment(MapFragment.newInstance())
                    })
            }
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}

