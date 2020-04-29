package dev.chrismercer.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import dev.chrismercer.swoosh.R
import dev.chrismercer.swoosh.Utilities.EXTRA_LEAGUE
import dev.chrismercer.swoosh.Utilities.EXTRA_SKILL
import dev.chrismercer.swoosh.Utilities.League
import dev.chrismercer.swoosh.Utilities.Skill
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var selectedLeague: League = League.None
    var selectedSkill: Skill = Skill.None

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        selectedLeague = League.valueOf(intent.getStringExtra(
            EXTRA_LEAGUE
        ))
        Log.d("LEAGUE", selectedLeague.name)
    }

    fun onBegginerButtonClick(view: View) {
        ballerButton.isChecked = false
        selectedSkill = Skill.Beginner
    }

    fun onBallerButtonClick(view: View) {
        beginnerButton.isChecked = false
        selectedSkill = Skill.Baller
    }

    fun onFinishButtonClick(view: View) {
        if(selectedSkill != Skill.None) {
            val finishIntent = Intent(this, FinishActivity::class.java)
            finishIntent.putExtra(EXTRA_LEAGUE, selectedLeague.name)
            finishIntent.putExtra(EXTRA_SKILL, selectedSkill.name)
            startActivity(finishIntent)
        } else {
            Toast.makeText(this, "You must select a skill level", Toast.LENGTH_SHORT).show()
        }
    }
}
