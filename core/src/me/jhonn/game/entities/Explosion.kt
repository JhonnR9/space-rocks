package me.jhonn.game.entities

import com.badlogic.gdx.scenes.scene2d.Stage

class Explosion(s: Stage) : BaseActor(x = 0f, y = 0f, s) {
    init {
        loadAnimationFromSheet("explosion.png",6,6,0.2f,false)
    }

    override fun act(delta: Float) {
        if (isAnimationFinished()) remove()
        super.act(delta)
    }
}