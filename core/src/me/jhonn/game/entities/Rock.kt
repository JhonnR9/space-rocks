package me.jhonn.game.entities

import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class Rock(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("rock.png")
        val random = MathUtils.random(30)
        addAction(Actions.forever(Actions.rotateBy(30f + random, 1f)))
        speed =  50f + random
        maxSpeed = 50f +random
        deceleration = 0f
        boundaryPolygon = createBoundaryRectangle()

        motionAngle = MathUtils.random(360f)
    }

    override fun act(delta: Float) {
        applyPhysics(delta)
        wrapAroundWorld()
        super.act(delta)
    }
}