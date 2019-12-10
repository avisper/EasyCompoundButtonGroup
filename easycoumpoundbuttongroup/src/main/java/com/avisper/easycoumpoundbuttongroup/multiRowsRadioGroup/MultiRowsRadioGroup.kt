package com.avisper.easycoumpoundbuttongroup.multiRowsRadioGroup

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioGroup



/**
 * Created by Avishay.Peretz on 05/12/2019.
 */
class MultiRowsRadioGroup @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var isChecking: Boolean = false
    private var mCheckedId: Int = -1

    private lateinit var radioGroupCheckedChangedListener: RadioGroup.OnCheckedChangeListener

    private var checkedChangedListener: OnCheckedChangeListener? = null

    init {
        initRadioGroupListener()
    }


    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        super.addView(child, index, params)
        setRadioGroupListener(child)
    }

    private fun setRadioGroupListener(view: View?) {
        if (view != null && view is RadioGroup) {
            view.setOnCheckedChangeListener(radioGroupCheckedChangedListener)
        }
    }


    private fun initRadioGroupListener() {
        radioGroupCheckedChangedListener = RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1 && !isChecking) {
                isChecking = true

                val size = childCount
                for (i in 0 until size) {
                    val view = getChildAt(i)
                    if (view is RadioGroup) {
                        if (view != group) {
                            view.clearCheck()
                        }
                    }
                }

                mCheckedId = checkedId
                checkedChangedListener?.onCheckedChanged(group, checkedId)

                isChecking = false
            }
        }
    }

    fun setOnCheckedChangeListener(onCheckedChangeListener: OnCheckedChangeListener?) {
        checkedChangedListener = onCheckedChangeListener
    }

}


interface OnCheckedChangeListener {
    fun onCheckedChanged(group: RadioGroup, checkedId: Int)
}
