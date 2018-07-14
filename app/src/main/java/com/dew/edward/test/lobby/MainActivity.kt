package com.dew.edward.test.lobby

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.dew.edward.test.R
import com.dew.edward.test.common.CommonHelloService
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, LobbyFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    lateinit var commonHelloService: CommonHelloService
    @Inject set

    @Inject
    lateinit var lobbyHelloService: LobbyHelloService

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


    }

    override fun onResume() {
        super.onResume()
        sayCommonHello()
        sayLobbyHello()
    }

    private fun sayLobbyHello() {
        lobbyHelloTextView.text = lobbyHelloService.sayHello()
    }

    private fun sayCommonHello() {
        commonHelloTextView.text = commonHelloService.sayHello()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
