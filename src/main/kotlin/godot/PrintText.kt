package godot

import godot.annotation.Export
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.annotation.RegisterProperty
import godot.api.Label
import godot.global.GD

@RegisterClass
class PrintText : Label() {

    @Export
    @RegisterProperty
    var test: Double = 0.0

    @RegisterFunction
    override fun _ready() {
        text = "Hi! I'm a script written in Kotlin!"
    }

    @RegisterFunction
    override fun _process(delta: Double) {
        test += delta
        if (test > 1) {
            GD.print("test $test")
            test = 0.0
        }
    }
}
