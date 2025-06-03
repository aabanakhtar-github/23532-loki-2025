package org.firstinspires.ftc.teamcode

import com.qualcomm.hardware.lynx.LynxModule
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.teamcode.util.CachedDoubleWriter

class Robot(hardwareMap: HardwareMap) {
    private var modules: List<LynxModule> = hardwareMap.getAll(LynxModule::class.java)
    private var motor: DcMotorEx = hardwareMap.get(DcMotorEx::class.java, "motor a");

    private var writers: Array<CachedDoubleWriter> = arrayOf(
        CachedDoubleWriter {
            power -> motor.power = power
        }
    )

    init {
        for (hub in modules) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }

    fun clearBulkCache() {
        for (hub in modules) {
           hub.clearBulkCache()
        }
    }

    fun update() {
        writers[0].write();
    }
}