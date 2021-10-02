
import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class UserDefault<T : Any>(val klass: Class<T>) : ReadWriteProperty<Any?, T?> {


    /*
    ====application class==========

        UserDefault.context=this

    * how to use this ->
    * ====create object class and create varible====

     object UDConst {

         var userid: String? by UserDefault(String::class.java)

     }
      ====use case====
      set value->  UDConst.userid = "android"
      get value->  UDConst.userid
    *
    *
    *
    * */


    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        if (sharedPreferences == null) {
            throw Exception(messageerror)
        }

        return when {
            klass.isAssignableFrom("".javaClass) -> {
                sharedPreferences?.getString(property.name, null) as? T?
            }
            klass.isAssignableFrom(1.javaClass) -> {
                val dummy = sharedPreferences?.getInt(property.name, -111111111)
                if (dummy == -111111111) {
                    null
                } else {
                    dummy as T?
                }

            }
            klass.isAssignableFrom(true.javaClass) -> {
                sharedPreferences?.getBoolean(property.name, false) as? T?
            }
            klass.isAssignableFrom(0f.javaClass) -> {
                val dummy = sharedPreferences?.getFloat(property.name, -111111111f)
                if (dummy == -111111111f) {
                    null
                } else {
                    dummy as? T?
                }
            }
            klass.isAssignableFrom(0L.javaClass) -> {
                val dummy = sharedPreferences?.getLong(property.name, -111111111L)
                if (dummy == -111111111L) {
                    null
                } else {
                    dummy as? T?
                }
            }

            else -> {
                null
            }
        }

    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        if (sharedPreferences == null) {
            throw Exception(messageerror)
        }
        sharedPreferences?.edit()?.apply {


            when (value) {
                is String -> {
                    putString(property.name, value)
                }
                is Boolean -> {
                    putBoolean(property.name, value)
                }
                is Int -> {
                    putInt(property.name, value)
                }
                is Float -> {
                    putFloat(property.name, value)
                }
                is Long -> {
                    putLong(property.name, value)
                }
            }

            apply()
        }


    }

    companion object {

        private var messageerror = "\n\n\n\n#####################################\n" +
                "#   Add in Application Class        #\n" +
                "#####################################\n" +
                "#                                   #\n" +
                "#     UserDefault.context=this      #\n" +
                "#                                   #\n" +
                "#####################################\n" +
                "\n" +
                "\n" +
                "\n"

        private const val defaultdata = "defaultdata"
        private var sharedPreferences: SharedPreferences? = null

        var context: Context?
            get() {
                return null
            }
            set(value) {
                sharedPreferences = value?.getSharedPreferences(defaultdata, ContextWrapper.MODE_PRIVATE)
            }


        fun clear() {
            if (sharedPreferences == null) {
                throw Exception(messageerror)
            } else {
                sharedPreferences?.edit()?.clear()?.apply()
            }
        }

    }


}
