package com.avisper.easycoumpoundbuttongroup.mixedCompoundButtonGroup

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * Created by Avishay.Peretz on 10/12/2019.
 */
class MixedCompoundButtonGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var currentCompoundButton: CompoundButton? = null

    private lateinit var compoundButtonCheckedChangedListener: CompoundButton.OnCheckedChangeListener

    private var checkedChangedListener: OnCheckedChangeListener? = null

    init {
        initCompoundButtonListener()
    }

    private fun initCompoundButtonListener() {
        compoundButtonCheckedChangedListener =
            CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->
                setChecked(compoundButton, isChecked)
            }
    }

    private fun setChecked(compoundButton: CompoundButton, isChecked: Boolean) {
        if (isChecked.not()) return
        if (currentCompoundButton != null) {
            currentCompoundButton!!.isChecked = false
            currentCompoundButton = compoundButton
        } else {
            currentCompoundButton = compoundButton
        }
        checkedChangedListener?.onCheckedChanged(currentCompoundButton!!)
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        super.addView(child, index, params)
        setCompoundButtonListener(child)
    }

    private fun setCompoundButtonListener(view: View?) {
        if (view == null) return
        if (view is CompoundButton) {
            view.setOnCheckedChangeListener(compoundButtonCheckedChangedListener)
        } else if (view is ViewGroup && view !is RadioGroup) { // NOT RadioGroup!
            for (i in 0 until view.childCount) {
                setCompoundButtonListener(view.getChildAt(i))
            }
        }
    }

    fun setOnCheckedChangeListener(onCheckedChangeListener: OnCheckedChangeListener?) {
        checkedChangedListener = onCheckedChangeListener
    }

}

interface OnCheckedChangeListener {
    fun onCheckedChanged(compoundButton: CompoundButton)
}