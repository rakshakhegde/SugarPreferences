<img src="ART/demo.gif" width="300" align="right" hspace="20">

# SugarPreferences

![Minimum API 9](https://img.shields.io/badge/API-9+-blue.svg)

Interacting with SharedPreferences made simple.

## Usage

`MainActivity.java` - inside onCreate()
```java
ActivityMainBinding binding = DataBindingUtil
        .setContentView(this, R.layout.activity_main);

// PROGRESS is Preferences key name with Int value type
binding.setModel(new ObsrvIntPref("PROGRESS"));
```
`activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout
	xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:app="http://schemas.android.com/apk/res-auto"
	xmlns:tools="http://schemas.android.com/tools">

	<data>

		<variable
			name="model"
			type="io.github.rakshakhegde.sugarprefs.obsrvprefs.ObsrvIntPref"/>
	</data>
	
    <SeekBar
		android:id="@+id/seekBar"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:progress="@={model, default=60}" />

</layout>
```

**Explanation**: Ok, WTF just happened there...

So just that's it. No need to pass `Context`, `apply()`, and what not ceremony...

## FAQ
**Q: I never gave you `Context`, how TF did you just access my SharedPrefs? 0_o**
A: To make your, developer, life simpler, a `ContentProvider` is built into this library that will automatically get the context.