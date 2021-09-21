 

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.fragment.app.FragmentActivity
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

object RootUtil {
    //add this permission manifest
    //    <uses-permission android:name="android.permission.REQUEST_DELETE_PACKAGES" />


    val isDeviceRooted: Boolean
        get() = checkRootMethod2() || checkRootMethod3() || checkRootMethod1()


    private fun checkRootMethod1(): Boolean {
        val buildTags = Build.TAGS
        return buildTags != null && buildTags.contains("test-keys")
    }

    private fun checkRootMethod2(): Boolean {
        val paths = arrayOf(
            "/system/app/Superuser.apk",
            "/sbin/su",
            "/system/bin/su",
            // "/system/xbin/su",
            "/data/local/xbin/su",
            "/data/local/bin/su",
            "/system/sd/xbin/su",
            "/system/bin/failsafe/su",
            "/data/local/su",
            "/su/bin/su"
        )

        for (path in paths) {
            val a = File(path).exists()
            if (a) {
                println("rootcheck:" + path)
            }
            if (a) return true
        }
        return false
    }

    private fun checkRootMethod3(): Boolean {
        var process: Process? = null
        return try {
            process = Runtime.getRuntime().exec(arrayOf("/system/xbin/which", "su"))
            val `in` = BufferedReader(InputStreamReader(process.inputStream))
            `in`.readLine() != null
        } catch (t: Throwable) {
            false
        } finally {
            process?.destroy()
        }
    }

}

fun FragmentActivity.uninstallSelf() {
    try {
        val intent = Intent(Intent.ACTION_DELETE)
        intent.data = Uri.parse("package:" + applicationContext.packageName)
        startActivity(intent)
    } catch (e: Exception) {
        println("error:Uninstall Failed")
    }
}
