package dev.chrismercer.swoosh.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.chrismercer.swoosh.R
import dev.chrismercer.swoosh.Utilities.EXTRA_LEAGUE
import dev.chrismercer.swoosh.Utilities.EXTRA_SKILL
import dev.chrismercer.swoosh.Utilities.League
import dev.chrismercer.swoosh.Utilities.Skill
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    var selectedLeague = ""
    var selectedSkill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        selectedLeague = intent.getStringExtra(EXTRA_LEAGUE)
        selectedSkill = intent.getStringExtra(EXTRA_SKILL)

        lookingText.text = "Looking for a ${selectedLeague} ${selectedSkill} league near you..."
    }
}
