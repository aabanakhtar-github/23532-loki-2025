package org.firstinspires.ftc.teamcode.util

class CachedDoubleWriter(private val writeMethod: (Double) -> Unit) {
    private var cache = 0.0
    private var dirty = false

    // write cached way
    var value = 0.0
    set(newValue) {
        if (newValue != field) {
            field = newValue
            dirty = true
        }
    }

    fun write() {
        if (dirty) {
            writeMethod(value)
            cache = value
            dirty = false
        }
    }
}
