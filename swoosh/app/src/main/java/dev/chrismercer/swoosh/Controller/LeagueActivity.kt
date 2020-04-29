package dev.chrismercer.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dev.chrismercer.swoosh.Model.Player
import dev.chrismercer.swoosh.R
import dev.chrismercer.swoosh.Utilities.EXTRA_LEAGUE
import dev.chrismercer.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    fun leagueNextClicked(view: View) {
        if(player.league != "") {
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "You must select a league", Toast.LENGTH_SHORT).show()
        }
    }

    fun onMenClicked(view: View) {
        womensButton.isChecked = false
        coedButton.isChecked = false
        player.league = "MENS"
    }

    fun onWomenClicked(view: View) {
        mensButton.isChecked = false
        coedButton.isChecked = false
        player.league = "WOMENS"
    }

    fun onCoedClicked(view: View) {
        mensButton.isChecked = false
        womensButton.isChecked = false
        player.league = "COED"
    }
}