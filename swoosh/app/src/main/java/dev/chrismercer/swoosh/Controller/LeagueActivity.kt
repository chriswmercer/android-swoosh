package dev.chrismercer.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dev.chrismercer.swoosh.R
import dev.chrismercer.swoosh.Utilities.EXTRA_LEAGUE
import dev.chrismercer.swoosh.Utilities.League
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague: League = League.None

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueNextClicked(view: View) {
        if(selectedLeague != League.None) {
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague.name)
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "You must select a league", Toast.LENGTH_SHORT).show()
        }
    }

    fun onMenClicked(view: View) {
        womensButton.isChecked = false
        coedButton.isChecked = false
        selectedLeague = League.Mens
    }

    fun onWomenClicked(view: View) {
        mensButton.isChecked = false
        coedButton.isChecked = false
        selectedLeague = League.Womens
    }

    fun onCoedClicked(view: View) {
        mensButton.isChecked = false
        womensButton.isChecked = false
        selectedLeague = League.Coed
    }
}