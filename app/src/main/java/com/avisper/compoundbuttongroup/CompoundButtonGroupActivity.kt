package com.avisper.compoundbuttongroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.avisper.easycoumpoundbuttongroup.mixedCompoundButtonGroup.MixedCompoundButtonGroup
import com.avisper.easycoumpoundbuttongroup.mixedCompoundButtonGroup.OnCheckedChangeListener

class CompoundButtonGroupActivity : AppCompatActivity() {

    private lateinit var mixedCompoundButtonGroup: MixedCompoundButtonGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compound_button_group)

        mixedCompoundButtonGroup = findViewById(R.id.mixedCompoundButtonGroup_container)
        mixedCompoundButtonGroup.setOnCheckedChangeListener(object : OnCheckedChangeListener {
            override fun onCheckedChanged(compoundButton: CompoundButton) {
                Toast.makeText(applicationContext, "checkedId = ${compoundButton.id}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroy() {
        mixedCompoundButtonGroup.setOnCheckedChangeListener(null)
        super.onDestroy()
    }
}
