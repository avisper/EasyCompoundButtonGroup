package com.avisper.compoundbuttongroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import com.avisper.easycoumpoundbuttongroup.multiRowsRadioGroup.MultiRowsRadioGroup
import com.avisper.easycoumpoundbuttongroup.multiRowsRadioGroup.OnCheckedChangeListener

class MultiRowsRadioGroupActivity : AppCompatActivity() {

    private lateinit var multiRowsRadioGroup: MultiRowsRadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_rows_radio_group)

        multiRowsRadioGroup = findViewById(R.id.multiRowsRadioGroup_container)
        multiRowsRadioGroup.setOnCheckedChangeListener(object : OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                Toast.makeText(applicationContext, "groupId = ${group.id}\ncheckedId = $checkedId", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroy() {
        multiRowsRadioGroup.setOnCheckedChangeListener(null)
        super.onDestroy()
    }
}
