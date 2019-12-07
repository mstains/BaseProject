package com.moran.baseproject.activity

import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moran.base.activity.BasicsActivity
import com.moran.base.fragment.BaseFragment
import com.moran.baseproject.R
import com.moran.baseproject.fragment.HomeFragment
import com.moran.baseproject.fragment.ListFragment
import com.moran.baseproject.fragment.MoreFragment
import com.moran.baseproject.fragment.UserFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BasicsActivity() {


    private var mCurrentFragment : BaseFragment? = null

    override fun getLayoutId(): Int {


        return R.layout.activity_home
    }




    override fun initView() {

        bottom_navigation.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{

            override fun onNavigationItemSelected(item: MenuItem): Boolean {


                when(item.itemId){

                    R.id.home ->{
                        selectNavigationFragment(HomeFragment())

                    }

                    R.id.list ->{

                        selectNavigationFragment(ListFragment())

                    }

                    R.id.user ->{
                        selectNavigationFragment(UserFragment())

                    }

                    R.id.more ->{

                        selectNavigationFragment(MoreFragment())

                    }

                    else ->{
                        selectNavigationFragment(HomeFragment())
                    }

                }


                return true
            }
        })

        selectNavigationFragment(HomeFragment())
    }






    private fun selectNavigationFragment(baseFragment: BaseFragment){

        if (baseFragment != mCurrentFragment){

            //FragmentTransaction
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            if (baseFragment.isAdded) {
                fragmentTransaction.hide(mCurrentFragment!!).show(baseFragment).commit()

            }else{
                if (mCurrentFragment == null){
                    fragmentTransaction.add(R.id.main_container,baseFragment).commit()
                }
                else{
                    fragmentTransaction.hide(mCurrentFragment!!).add(R.id.main_container,baseFragment).commit()
                }
            }
        }
        mCurrentFragment = baseFragment

    }
}
