package io.github.rakshakhegde.app;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.github.rakshakhegde.app.databinding.ActivityMainBinding;
import io.github.rakshakhegde.obsrvpref.obsrv.ObsrvIntPref;

public class MainActivity extends AppCompatActivity {

	public static final String MODEL_KEY = "MODEL_KEY";

	final ObsrvIntPref progress = new ObsrvIntPref(
			this,
			MODEL_KEY,
			60
	);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		binding.setProgress(progress);
	}
}
