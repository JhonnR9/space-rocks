package me.jhonn.game.entities

import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class Ufo(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    var life = 200

    init {
        loadTexture("Ufo.png")
        val random = MathUtils.random(40)
        setSize(120f, 120f)

        addAction(Actions.forever(Actions.rotateBy(30f + random, 1f)))

        speed = 50f + random
        maxSpeed = 50f + random
        deceleration = 0f
        boundaryPolygon = createBoundaryPolygon(8)

        motionAngle = MathUtils.random(360f)
    }

    override fun act(delta: Float) {
        applyPhysics(delta)
        wrapAroundWorld()
        super.act(delta)
    }
}