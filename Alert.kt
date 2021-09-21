 


import android.content.Context
import androidx.appcompat.app.AlertDialog

class Alert(
    val title: String? = null,
    val mssage: String? = null,
    val positivetext: String? = null,
    val negativetext: String? = null,
    val alertContext: Context,
    val positiveButton: (Boolean) -> Unit

) {

    constructor(builder: Builder) : this(
        builder.title,
        builder.message,
        builder.positivetext,
        builder.negativetext,
        builder.context,
        builder.listener

    )

    init {

        AlertDialog.Builder(alertContext).apply {
            title?.let {
                setTitle(title)
            }
            mssage?.let {
                setMessage(mssage)
            }
            positivetext?.let {
                setPositiveButton(positivetext) { dialog, which -> positiveButton.invoke(true) }
            }
            negativetext?.let {
                setNegativeButton(negativetext) { dialog, which -> positiveButton.invoke(false) }
            }

        }.show()

    }

    companion object {
        inline fun alert(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    class Builder {
        lateinit var context: Context
        var title: String? = null
        var message: String? = null
        var positivetext: String? = null
        var negativetext: String? = null
        lateinit var listener: (Boolean) -> Unit
        fun build() = Alert(this)
    }


}
