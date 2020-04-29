package dev.chrismercer.swoosh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class BaseActivity : AppCompatActivity() {

    //lifecycle explanation
    /*
    App starts, loading main activity
    2020-04-29 09:45:51.079 27546-27546/dev.chrismercer.swoosh D/LifeCycle: MainActivity OnCreate
    2020-04-29 09:45:51.343 27546-27546/dev.chrismercer.swoosh D/LifeCycle: MainActivity OnStart
    2020-04-29 09:45:51.353 27546-27546/dev.chrismercer.swoosh D/LifeCycle: MainActivity OnResume

    Goes to league activity
    2020-04-29 09:46:43.003 27546-27546/dev.chrismercer.swoosh D/LifeCycle: MainActivity OnPause
    2020-04-29 09:46:43.029 27546-27546/dev.chrismercer.swoosh D/LifeCycle: LeagueActivity OnCreate
    2020-04-29 09:46:43.139 27546-27546/dev.chrismercer.swoosh D/LifeCycle: LeagueActivity OnStart
    2020-04-29 09:46:43.141 27546-27546/dev.chrismercer.swoosh D/LifeCycle: LeagueActivity OnResume
    2020-04-29 09:46:43.658 27546-27546/dev.chrismercer.swoosh D/LifeCycle: MainActivity OnStop

    Presses back
    2020-04-29 09:48:19.732 27546-27546/dev.chrismercer.swoosh D/LifeCycle: LeagueActivity OnPause
    2020-04-29 09:48:19.741 27546-27546/dev.chrismercer.swoosh D/LifeCycle: MainActivity OnRestart
    2020-04-29 09:48:19.742 27546-27546/dev.chrismercer.swoosh D/LifeCycle: MainActivity OnStart
    2020-04-29 09:48:19.744 27546-27546/dev.chrismercer.swoosh D/LifeCycle: MainActivity OnResume
    2020-04-29 09:48:20.213 27546-27546/dev.chrismercer.swoosh D/LifeCycle: LeagueActivity OnStop
    2020-04-29 09:48:20.216 27546-27546/dev.chrismercer.swoosh D/LifeCycle: LeagueActivity OnDestroy

    Points to note: doesn't become active until resume. Doesn't stop previous one or start the next
    one until its covered by another activity.

    */

    //logging, first create a tag
    val TAG = "LifeCycle"

    //called once and once only, view not visible, use to set up click handlers
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"${javaClass.simpleName} OnCreate")
        super.onCreate(savedInstanceState)
    }

    //makes it visible and is preparing to become interactive
    override fun onStart() {
        Log.d(TAG,"${javaClass.simpleName} OnStart")
        super.onStart()
    }

    //interactvity possible, stays in this state until moving to something else
    override fun onResume() {
        Log.d(TAG,"${javaClass.simpleName} OnResume")
        super.onResume()
    }

    //only called after onStop when it has focus again, then does
    //on start and on resume
    override fun onRestart() {
        Log.d(TAG,"${javaClass.simpleName} OnRestart")
        super.onRestart()
    }

    //when something else is being done - pause music, etc
    override fun onPause() {
        Log.d(TAG,"${javaClass.simpleName} OnPause")
        super.onPause()
    }

    //when a new activity completely covers the current activity
    //or another app is used, or on home. used to stop things
    override fun onStop() {
        Log.d(TAG,"${javaClass.simpleName} OnStop")
        super.onStop()
    }

    //called once at the end, free it all up!
    override fun onDestroy() {
        Log.d(TAG,"${javaClass.simpleName} OnDestroy")
        super.onDestroy()
    }
}
