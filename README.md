[![](https://jitpack.io/v/avisper/EasyCompoundButtonGroup.svg)](https://jitpack.io/#avisper/EasyCompoundButtonGroup) [![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)


# EasyCoumpoundButtonGroup

:vertical_traffic_light: **EasyCoumpoundButtonGroup** provide solution for CompoundButtons in group, and behave like a RadioGroup. It resolve the one and only selected button in CompoundButton (CheckBox, RadioButton, Switch, ToggleButton) group


* [**MixedCompoundButtonGroup**](#MixedCompoundButtonGroup) - MixedCompoundButtonGroup is a ConstraintLayout with kinds of CompoundButton
* [**MultiRowsRadioGroup**](#MultiRowsRadioGroup) - MultiRowsRadioGroup is a RadioGroups container with different columns or rows


<!-- GETTING STARTED -->
## Getting started

### Installing - Gradle setup

#### build.gradle (Project)
```
allprojects {
    repositories {
        ...
        
        maven { url 'https://jitpack.io' }
    }
}
```

#### build.gradle (app)
```
dependencies {
    ...
    
    // EasyCompoundButtonGroup
    implementation 'com.github.avisper:EasyCompoundButtonGroup:x.x.x'
}
```



### MixedCompoundButtonGroup
#### Step 1
Add MixedCompoundButtonGroup to your layout with content you want.

```
<com.avisper.testerapplication.mixedCompundButtonGroup.MixedCompoundButtonGroup xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/mixedCompoundButtonGroup_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <RadioButton
        android:id="@+id/rb1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="aaa"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <RadioButton
        android:id="@+id/rb2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="bbb"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <RadioButton
        android:id="@+id/rb3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="ccc"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />


    <LinearLayout
        android:id="@+id/ll_radioGroup_container1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:orientation="horizontal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/rb3">

        <ToggleButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

        <ToggleButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

        <ToggleButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    </LinearLayout>

    <Switch
        android:id="@+id/btn_switch1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="Switch"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/ll_radioGroup_container1" />

    <CheckBox
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="check box"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/btn_switch1" />

</com.avisper.testerapplication.mixedCompundButtonGroup.MixedCompoundButtonGroup>
```

#### Step 2
set OnCheckedChangeListener to  MixedCompoundButtonGroup
```
  mixedCompoundButtonGroup = findViewById(R.id.mixedCompoundButtonGroup_container)
        mixedCompoundButtonGroup.setOnCheckedChangeListener(object : OnCheckedChangeListener {
            override fun onCheckedChanged(compoundButton: CompoundButton) {
                Toast.makeText(applicationContext, "checkedId = ${compoundButton.id}", Toast.LENGTH_SHORT).show()
        }
  })
```



### MultiRowsRadioGroup
#### Step 1
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

#### Step 2
set OnCheckedChangeListener to  MultiRowsRadioGroup
```
multiRowsRadioGroup = findViewById(R.id.multiRowsRadioGroup_container)
multiRowsRadioGroup.setOnCheckedChangeListener(object : OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                Toast.makeText(applicationContext, "groupId = ${group.id}\ncheckedId = $checkedId", Toast.LENGTH_SHORT).show()
            }
})
```



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [Android CompoundButton](https://developer.android.com/reference/android/widget/CompoundButton)
* [Android Checkable](https://developer.android.com/reference/android/widget/Checkable.html)
