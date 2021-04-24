package com.example.gottalearn_beta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : BottomNavigationView.OnNavigationItemSelectedListener, FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav:BottomNavigationView= findViewById(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(this)



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var selectedFragment: Fragment?=HomeFragment()
        when(item.itemId){
            R.id.nav_home->{
                selectedFragment= HomeFragment()
            }
            R.id.nav_add->{
                selectedFragment=AddFragment()
            }
            R.id.nav_list->{
                selectedFragment=ListFragment()
            }
            R.id.nav_book->{
                selectedFragment=BookFragment()
            }
        }
            if(selectedFragment !=null){
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, selectedFragment)
                transaction.commit()
            }


            return true
    }

//    override fun passDataCom(data: ArrayList<Assignment>) {
//        val bundle = Bundle()
//        bundle.putParcelableArrayList("DATA_ASSIGNMENT", data )
//
//        val transaction = this.supportFragmentManager.beginTransaction()
//        val fragmentList =ListFragment()
//        fragmentList.arguments = bundle
//
//        transaction.replace(R.id.fragment_container, fragmentList)
//        transaction.addToBackStack(null)
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//        transaction.commit()
//
//    }


}