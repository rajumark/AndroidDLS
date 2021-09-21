import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
 

@Target(
    AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Experimental

inline fun <reified T, B : ViewBinding> RecyclerView.adapterLite(
    viewBindingClass: Class<B>,
    items: List<T>,
    noinline render: (B, T, Int) -> Unit
) {
    layoutManager = LinearLayoutManager(this.context)
    adapter = AdapterLitePrivate<T, B>(viewBindingClass, items, render)

}


@Experimental
inline fun <reified T, B : ViewBinding> adapterLite(
    viewBindingClass: Class<B>,
    items: List<T>,
    noinline render: (B, T, Int) -> Unit
): AdapterLitePrivate<T, B> {

    return AdapterLitePrivate<T, B>(viewBindingClass, items, render)

}

class AdapterLitePrivate<T, B : ViewBinding>(
    name: Class<B>,
    items: List<T>,
    onRender: (B, T, Int) -> Unit
) :
    RecyclerView.Adapter<AdapterLitePrivate.Tempo>() {

    var nameT: Class<B> = name
    val list = ArrayList<T>()

    private var render: (B, T, Int) -> Unit = onRender


    init {

        list.clear()
        list.addAll(items)
    }

    class Tempo(javaClass: View, findClass: Any) : RecyclerView.ViewHolder(javaClass) {


        var findClassT: Any

        init {
            this.findClassT = findClass
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tempo {
        val mBinding: B = nameT.getBinding<B>(LayoutInflater.from(parent.context), parent)

        return Tempo(mBinding.root, mBinding)
        //  val itemView = LayoutInflater.from(parent.context).inflate(resId, parent, false)
        //  return Tempo(itemView)
    }

    override fun onBindViewHolder(holder: Tempo, position: Int) {


        render.invoke(
            holder.findClassT as B,
            list.get(position),
            position
        )

        /* holder.itemViewTT?.let {


             render.invoke(
                 it,
                 nameT.newInstance(),
                 list.get(position),
                 position
             )
         }*/
    }

    override fun getItemCount() = list.size
}


internal fun <V : ViewBinding> Class<*>.getBinding(
    layoutInflater: LayoutInflater,
    container: ViewGroup?
): V {
    return try {
        @Suppress("UNCHECKED_CAST")
        getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        ).invoke(null, layoutInflater, container, false) as V
    } catch (ex: Exception) {
        throw RuntimeException("The ViewBinding inflate function has been changed.", ex)
    }
}
