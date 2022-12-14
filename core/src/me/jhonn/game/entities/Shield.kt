package me.jhonn.game.entities

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class Shield(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("shields.png")
        val pulse = Actions.sequence(
            Actions.scaleTo(1.05f, 1.05f, 1f),
            Actions.scaleTo(0.95f, 0.95f, 1f))
       // addAction(pulse)
        addAction(Actions.forever(pulse))
    }

}