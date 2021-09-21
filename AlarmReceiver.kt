 


import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
 
import java.text.SimpleDateFormat
import java.util.*


class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {


        val timestr = SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().time)
        val nit = System.currentTimeMillis().toInt()
        context.createNotification(nit, "$timestr", "descrip test")

    }

    companion object {
        private const val NOTIFICATION_ID = 0
    }
}

fun Context.playRingtone() {
    val notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
    val r = RingtoneManager.getRingtone(this, notification)
    r.play()
}

fun Context.setAlarmAtThisTime(hour: Int, minute: Int, second: Int, millisecond: Int, delayinSec: Int) {
    val calendar: Calendar = Calendar.getInstance().apply {
        timeInMillis = System.currentTimeMillis()
        set(Calendar.HOUR_OF_DAY, hour)
        set(Calendar.MINUTE, minute)
        set(Calendar.SECOND, second)
        set(Calendar.MILLISECOND, millisecond)


        //  set(Calendar.MINUTE, 57)
    }


    println("timesetfor:" + SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(calendar.time))

    (getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager).setRepeating(
        AlarmManager.RTC_WAKEUP,
        calendar.timeInMillis,
        (delayinSec * 1000).toLong(),
        Intent(this, AlarmReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(this, 0, intent, 0)
        }
    )
}
