package dev.chrismercer.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import dev.chrismercer.swoosh.Model.Player
import dev.chrismercer.swoosh.R
import dev.chrismercer.swoosh.Utilities.*
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null) {
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
        }
    }

    fun onBegginerButtonClick(view: View) {
        ballerButton.isChecked = false
        player.skill = "BEGINNER"
    }

    fun onBallerButtonClick(view: View) {
        beginnerButton.isChecked = false
        player.skill = "BALLER"
    }

    fun onFinishButtonClick(view: View) {
        if(player.skill != "") {
            val finishIntent = Intent(this, FinishActivity::class.java)
            finishIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(finishIntent)
        } else {
            Toast.makeText(this, "You must select a skill level", Toast.LENGTH_SHORT).show()
        }
    }
}
