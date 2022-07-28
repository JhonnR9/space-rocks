package me.jhonn.game.entities

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class Warp(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadAnimationFromSheet("warp.png", 4, 8, 0.5f, true)
       vanish()

    }
}