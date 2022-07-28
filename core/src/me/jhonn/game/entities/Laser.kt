package me.jhonn.game.entities

import com.badlogic.gdx.scenes.scene2d.Stage

class Laser(x: Float, y: Float, s: Stage) : BaseActor(x, y, s) {
    init {
        loadTexture("laser.png")
        vanish()
        speed = 400f
        maxSpeed = 400f
        deceleration = 0f

        boundaryPolygon = createBoundaryPolygon(8)
    }

    override fun act(delta: Float) {
        applyPhysics(delta)
        wrapAroundWorld()
        super.act(delta)
    }
}