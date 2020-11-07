package com.example.revisao26102020_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewParent
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {

//    private lateinit var tablayout: TabLayout

    private val tablayout by lazy {
        findViewById<TabLayout>(R.id.tablayout)
    }

    private val viewPager by lazy {
        findViewById<ViewPager>(R.id.viewPager)
    }

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportActionBar?.title = "Cadastro" //para colocar o label na toolbar ou dessa forma ou no Manifest (label)

        initComponents()
    }

    private fun initComponents(){

        //callFragment(NaoSocioFragment())
        //tablayout = findViewById(R.id.tablayout)
//        tablayout.addOnTabSelectedListener(this)

        viewPager.adapter = RegisterAdapter(
            listOf(
                getString(R.string.salgados) ,
                getString(R.string.lanches),
                getString(R.string.bebidas)
            ),
            listOf(
                SalgadosFragment(),
                LanchesFragment(),
                BebidasFragment()
            ),
            supportFragmentManager
        )
        tablayout.setupWithViewPager(viewPager)
        viewModel = ViewModelProvider(this).get(CadastroViewModel::class.java)

        //tablayout.getTabAt(1)?.select()
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }

//    private fun callFragment(fragment: Fragment){
//        val ft = supportFragmentManager.beginTransaction()
//        ft.replace(R.id.container, fragment)
//        ft.commit()
//    }
//
//    override fun onTabSelected(tab: TabLayout.Tab?) {
//        when (tab?.position){
//            0 -> { callFragment(NaoSocioFragment()) }
//            1 -> { callFragment(SocioFragment()) }
//        }
//    }
//
//    override fun onTabUnselected(tab: TabLayout.Tab?) { /* não usado */ }
//
//    override fun onTabReselected(tab: TabLayout.Tab?) { /* não usado */ }
}
