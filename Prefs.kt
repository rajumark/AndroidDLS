 

import android.annotation.TargetApi
import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import android.os.Build
import android.text.TextUtils
import android.util.Base64
import java.util.*

object Prefs {

    private const val LENGTH = "#LENGTH"
    private var mPrefs: SharedPreferences? = null


    fun initPrefs(context: Context?) {
        Builder().setContext(context).build()
    }

    private fun initPrefs(context: Context, prefsName: String?, mode: Int) {
        mPrefs = context.getSharedPreferences(prefsName, mode)
    }

    /**
     * Returns the underlying SharedPreference instance
     *
     * @return an instance of the SharedPreference
     * @throws RuntimeException if SharedPreference instance has not been instantiated yet.
     */
    private val preferences: SharedPreferences?
        get() {
            if (mPrefs != null) {
                return mPrefs
            }
            throw RuntimeException(
             
               /*
                * paste this
                *      Prefs.Builder().setContext(this).build()
                *
                *
                * */
             
                "put this code in \n*********\nMyApp.kt\n*********\n" +
                      "  Prefs.Builder().setContext(this).build()+

                        "Prefs class not correctly instantiated. Please call Builder.setContext().build() in the Application class onCreate."
            )
        }

    /**
     * @return Returns a map containing a list of pairs key/value representing
     * the preferences.
     * @see android.content.SharedPreferences.getAll
     */
    val all: Map<String, *>
        get() = preferences!!.all

    /**
     * Retrieves a stored int value.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not
     * an int.
     * @see android.content.SharedPreferences.getInt
     */
    fun getInt(key: String?, defValue: Int): Int {
        return preferences!!.getInt(key, defValue)
    }

    /**
     * Retrieves a stored int value, or 0 if the preference does not exist.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or 0.
     * @throws ClassCastException if there is a preference with this name that is not
     * an int.
     * @see android.content.SharedPreferences.getInt
     */
    fun getInt(key: String?): Int {
        return preferences!!.getInt(key, 0)
    }

    /**
     * Retrieves a stored boolean value.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not a boolean.
     * @see android.content.SharedPreferences.getBoolean
     */
    fun getBoolean(key: String?, defValue: Boolean): Boolean {
        return preferences!!.getBoolean(key, defValue)
    }

    /**
     * Retrieves a stored boolean value, or false if the preference does not exist.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or false.
     * @throws ClassCastException if there is a preference with this name that is not a boolean.
     * @see android.content.SharedPreferences.getBoolean
     */
    fun getBoolean(key: String?): Boolean {
        return preferences!!.getBoolean(key, false)
    }

    /**
     * Retrieves a stored long value.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not a long.
     * @see android.content.SharedPreferences.getLong
     */
    fun getLong(key: String?, defValue: Long): Long {
        return preferences!!.getLong(key, defValue)
    }

    /**
     * Retrieves a stored long value, or 0 if the preference does not exist.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or 0.
     * @throws ClassCastException if there is a preference with this name that is not a long.
     * @see android.content.SharedPreferences.getLong
     */
    fun getLong(key: String?): Long {
        return preferences!!.getLong(key, 0L)
    }

    /**
     * Returns the double that has been saved as a long raw bits value in the long preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue the double Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not a long.
     * @see android.content.SharedPreferences.getLong
     */
    fun getDouble(key: String?, defValue: Double): Double {
        return java.lang.Double.longBitsToDouble(
            preferences!!.getLong(
                key,
                java.lang.Double.doubleToLongBits(defValue)
            )
        )
    }

    /**
     * Returns the double that has been saved as a long raw bits value in the long preferences.
     * Returns 0 if the preference does not exist.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or 0.
     * @throws ClassCastException if there is a preference with this name that is not a long.
     * @see android.content.SharedPreferences.getLong
     */
    fun getDouble(key: String?): Double {
        return java.lang.Double.longBitsToDouble(
            preferences!!.getLong(
                key,
                java.lang.Double.doubleToLongBits(0.0)
            )
        )
    }

    /**
     * Retrieves a stored float value.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not a float.
     * @see android.content.SharedPreferences.getFloat
     */
    fun getFloat(key: String?, defValue: Float): Float {
        return preferences!!.getFloat(key, defValue)
    }

    /**
     * Retrieves a stored float value, or 0 if the preference does not exist.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or 0.
     * @throws ClassCastException if there is a preference with this name that is not a float.
     * @see android.content.SharedPreferences.getFloat
     */
    fun getFloat(key: String?): Float {
        return preferences!!.getFloat(key, 0.0f)
    }

    /**
     * Retrieves a stored String value.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue.
     * @throws ClassCastException if there is a preference with this name that is not a String.
     * @see android.content.SharedPreferences.getString
     */
    fun getString(key: String?, defValue: String?): String? {
        return preferences!!.getString(key, defValue)
    }

    /**
     * Retrieves a stored String value, or an empty string if the preference does not exist.
     *
     * @param key The name of the preference to retrieve.
     * @return Returns the preference value if it exists, or "".
     * @throws ClassCastException if there is a preference with this name that is not a String.
     * @see android.content.SharedPreferences.getString
     */
    fun getString(key: String?): String? {
        return preferences!!.getString(key, "")
    }

    /**
     * Retrieves a Set of Strings as stored by [.putStringSet]. On Honeycomb and
     * later this will call the native implementation in SharedPreferences, on older SDKs this will
     * call [.getOrderedStringSet].
     * **Note that the native implementation of [SharedPreferences.getStringSet] does not reliably preserve the order of the Strings in the Set.**
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference values if they exist, or defValues otherwise.
     * @throws ClassCastException if there is a preference with this name that is not a Set.
     * @see android.content.SharedPreferences.getStringSet
     * @see .getOrderedStringSet
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getStringSet(key: String?, defValue: Set<String?>?): Set<String>? {
        val prefs = preferences
        return prefs!!.getStringSet(key, defValue)
    }

    /**
     * Retrieves a Set of Strings as stored by [.putOrderedStringSet],
     * preserving the original order. Note that this implementation is heavier than the native
     * [.getStringSet] method (which does not guarantee to preserve order).
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValues otherwise.
     * @throws ClassCastException if there is a preference with this name that is not a Set of
     * Strings.
     * @see .getStringSet
     */
    fun getOrderedStringSet(key: String, defValue: Set<String?>): Set<String?> {
        val prefs = preferences
        if (prefs!!.contains(key + LENGTH)) {
            val set = LinkedHashSet<String?>()
            val stringSetLength = prefs.getInt(key + LENGTH, -1)
            if (stringSetLength >= 0) {
                for (i in 0 until stringSetLength) {
                    set.add(prefs.getString("$key[$i]", null))
                }
            }
            return set
        }
        return defValue
    }

    /**
     * Stores a long value.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @see android.content.SharedPreferences.Editor.putLong
     */
    fun putLong(key: String?, value: Long) {
        val editor = preferences!!.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    /**
     * Stores an integer value.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @see android.content.SharedPreferences.Editor.putInt
     */
    fun putInt(key: String?, value: Int) {
        val editor = preferences!!.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    /**
     * Stores a double value as a long raw bits value.
     *
     * @param key   The name of the preference to modify.
     * @param value The double value to be save in the preferences.
     * @see android.content.SharedPreferences.Editor.putLong
     */
    fun putDouble(key: String?, value: Double) {
        val editor = preferences!!.edit()
        editor.putLong(key, java.lang.Double.doubleToRawLongBits(value))
        editor.apply()
    }

    /**
     * Stores a float value.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @see android.content.SharedPreferences.Editor.putFloat
     */
    fun putFloat(key: String?, value: Float) {
        val editor = preferences!!.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    /**
     * Stores a boolean value.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @see android.content.SharedPreferences.Editor.putBoolean
     */
    fun putBoolean(key: String?, value: Boolean) {
        val editor = preferences!!.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    /**
     * Stores a String value.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @see android.content.SharedPreferences.Editor.putString
     */
    fun putString(key: String?, value: String?) {
        val editor = preferences!!.edit()
        editor.putString(key, value)
        editor.apply()
    }

    /**
     * Stores a Set of Strings. On Honeycomb and later this will call the native implementation in
     * SharedPreferences.Editor, on older SDKs this will call [.putOrderedStringSet].
     * **Note that the native implementation of [Editor.putStringSet] does not reliably preserve the order of the Strings in the Set.**
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @see android.content.SharedPreferences.Editor.putStringSet
     * @see .putOrderedStringSet
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun putStringSet(key: String?, value: Set<String?>?) {
        val editor = preferences!!.edit()
        editor.putStringSet(key, value)
        editor.apply()
    }

    /**
     * Stores a Set of Strings, preserving the order.
     * Note that this method is heavier that the native implementation [.putStringSet] (which does not reliably preserve the order of the Set). To preserve the order of the
     * items in the Set, the Set implementation must be one that as an iterator with predictable
     * order, such as [LinkedHashSet].
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     * @see .putStringSet
     * @see .getOrderedStringSet
     */
    fun putOrderedStringSet(key: String, value: Set<String?>) {
        val editor = preferences!!.edit()
        var stringSetLength = 0
        if (mPrefs!!.contains(key + LENGTH)) {
            // First read what the value was
            stringSetLength = mPrefs!!.getInt(key + LENGTH, -1)
        }
        editor.putInt(key + LENGTH, value.size)
        var i = 0
        for (aValue in value) {
            editor.putString("$key[$i]", aValue)
            i++
        }
        while (i < stringSetLength) {

            // Remove any remaining values
            editor.remove("$key[$i]")
            i++
        }
        editor.apply()
    }

    /**
     * Removes a preference value.
     *
     * @param key The name of the preference to remove.
     * @see android.content.SharedPreferences.Editor.remove
     */
    fun remove(key: String) {
        val prefs = preferences
        val editor = prefs!!.edit()
        if (prefs.contains(key + LENGTH)) {
            // Workaround for pre-HC's lack of StringSets
            val stringSetLength = prefs.getInt(key + LENGTH, -1)
            if (stringSetLength >= 0) {
                editor.remove(key + LENGTH)
                for (i in 0 until stringSetLength) {
                    editor.remove("$key[$i]")
                }
            }
        }
        editor.remove(key)
        editor.apply()
    }

    /**
     * Checks if a value is stored for the given key.
     *
     * @param key The name of the preference to check.
     * @return `true` if the storage contains this key value, `false` otherwise.
     * @see android.content.SharedPreferences.contains
     */
    operator fun contains(key: String?): Boolean {
        return preferences!!.contains(key)
    }

    /**
     * Removed all the stored keys and values.
     *
     * @return the [Editor] for chaining. The changes have already been committed/applied
     * through the execution of this method.
     * @see android.content.SharedPreferences.Editor.clear
     */
    fun clear(): SharedPreferences.Editor {
        val editor = preferences!!.edit().clear()
        editor.apply()
        return editor
    }

    /**
     * Returns the Editor of the underlying SharedPreferences instance.
     *
     * @return An Editor
     */
    fun edit(): SharedPreferences.Editor {
        return preferences!!.edit()
    }

    /**
     * Builder class for the EasyPrefs instance. You only have to call this once in the Application
     * onCreate. And in the rest of the code base you can call Prefs.method name.
     */
    class Builder {
        private var mKey: String? = null
        private var mContext: Context? = null
        private var mMode = ContextWrapper.MODE_PRIVATE
        fun setContext(context: Context?): Builder {
            mContext = context
            mKey = mContext!!.packageName
            return this
        }

        /**
         * Initialize the SharedPreference instance to used in the application.
         *
         * @throws RuntimeException if Context has not been set.
         */
        fun build() {
            if (mContext == null) {
                throw RuntimeException("Context not set, please set context before building the Prefs instance.")
            }
            if (TextUtils.isEmpty(mKey)) {
                mKey = mContext!!.packageName
            }
            if (mMode == -1) {
                mMode = ContextWrapper.MODE_PRIVATE
            }
            initPrefs(mContext!!, mKey, mMode)
        }
    }
}


fun String.decodeLocal(): String {
    return Base64.decode(this, Base64.DEFAULT).toString(charset("UTF-8"))
}

fun String.encodeLocal(): String {
    return Base64.encodeToString(this.toByteArray(charset("UTF-8")), Base64.DEFAULT)
}

fun putLocalString(key: String, value: String?) {
    value?.let {
        Prefs.putString(key, it.encodeLocal())
    }
}

fun putLocalInt(key: String, value: Int) {
    value.let {
        Prefs.putInt(key, value)
    }
}

fun removeLocalString(key: String) {
    Prefs.remove(key)
}


fun getLocalInt(key: String, default: Int): Int {

    val a = Prefs.getInt(key, default)
    return if (a == default) {
        return default
    } else {
        a
    }


}

fun getLocalString(key: String, default: String): String {

    val a = Prefs.getString(key, default)
    return if (a == default) {
        return default
    } else {
        a?.decodeLocal()?:default
    }


}
