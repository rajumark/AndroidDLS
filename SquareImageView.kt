 

import android.content.Context
import android.util.AttributeSet

class SquareImageView(context: Context, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatImageView(context, attrs) {


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//for ratio use below code
       // val ratio = 0.6
       // val width = measuredWidth
       // val height = measuredWidth * ratio
       // setMeasuredDimension(width, height.toInt())

        setMeasuredDimension(widthMeasureSpec, widthMeasureSpec)

    }

}
