# EasyCoumpoundButtonGroup
[![](https://jitpack.io/v/avisper/EasyCompoundButtonGroup.svg)](https://jitpack.io/#avisper/EasyCompoundButtonGroup)

:vertical_traffic_light: **EasyCoumpoundButtonGroup** provide solution for CompoundButtons in group, and behave like a RadioGroup. It resolve the one and only selected button in CompoundButton (CheckBox, RadioButton, Switch, ToggleButton) group


* **MixedCompoundButtonGroup** - MixedCompoundButtonGroup is a ConstraintLayout with kinds of CompoundButton
* **MultiRowsRadioGroup** -  MultiRowsRadioGroup is a RadioGroups container with different columns or rows


## Installing - Gradle setup

### build.gradle (Project)
```
allprojects {
    repositories {
        ...
        
        maven { url 'https://jitpack.io' }
    }
}
```

### build.gradle (app)
```
dependencies {
    ...
    
    // EasyCompoundButtonGroup
    implementation 'com.github.avisper:EasyCompoundButtonGroup:1.0.0'
}
```


## Getting started

### Step 1
Add MultiRowsRadioGroup to your layout with content you want.
pay attention - if you want RadioButtons, even only one, you sould add RadioGroup to the content.
```
<com.avisper.multirowsradiogroup.MultiRowsRadioGroup 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/multiRowsRadioGroup_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">
    
    ...

    <RadioGroup
        android:id="@+id/radioGroup1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <RadioButton
            style="@style/CustomRadioButton1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="AAA" />

        <RadioButton
            style="@style/CustomRadioButton1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="AAA" />
    </RadioGroup>

 
    <RadioGroup
        android:id="@+id/radioGroup2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <RadioButton
            style="@style/CustomRadioButton1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="BBB" />

    </RadioGroup>
 
</com.avisper.multirowsradiogroup.MultiRowsRadioGroup>
```

### Step 2
find the MultiRowsRadioGroup in your view - Activity, Fragment, etc.

set OnCheckedChangeListener to  MultiRowsRadioGroup
```
multiRowsRadioGroup = findViewById(R.id.multiRowsRadioGroup_container)
multiRowsRadioGroup.setOnCheckedChangeListener(object : OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                Toast.makeText(applicationContext, "groupId = ${group.id}\ncheckedId = $checkedId", Toast.LENGTH_SHORT).show()
            }
})
```
