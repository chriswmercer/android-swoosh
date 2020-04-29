package dev.chrismercer.swoosh.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.chrismercer.swoosh.Model.Player
import dev.chrismercer.swoosh.R
import dev.chrismercer.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        player = intent.getParcelableExtra(EXTRA_PLAYER)

        lookingText.text = "Looking for a ${player.league} ${player.skill} league near you..."
    }
}
