# SlidingBottomDTPicker
[![](https://jitpack.io/v/sharukhmohammed/SlidingBottomDTPicker.svg)](https://jitpack.io/#sharukhmohammed/SlidingBottomDTPicker)

Both Date and Time Picker in one Simple BottomSheetDialogFragment
![](display.gif)

Add it in your root build.gradle at the end of repositories:
-----------------------------------------------------------

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}



Add the dependency
------------------

	dependencies {
	        
         implementation 'com.android.support:appcompat-v7:28.0.0'
         implementation 'com.android.support:design:28.0.0'
	 implementation 'com.github.sharukhmohammed:SlidingBottomDTPicker:1.1'
         
	}
 
 
Usage
-----

        BottomSlidingDateTimePicker bottomSlidingDateTimePicker = BottomSlidingDateTimePicker.newInstance("Title");

        bottomSlidingDateTimePicker.show(getSupportFragmentManager(), "SomeTAG");

        bottomSlidingDateTimePicker.setOnDateTimeSetListener(new BottomSlidingDateTimePicker.OnDateTimeSetListener() {
            @Override
            public void onDateTimeSelected(Calendar selectedDateTime) {

                something.setText(selectedDateTime.getTime().toString());

            }
        });
