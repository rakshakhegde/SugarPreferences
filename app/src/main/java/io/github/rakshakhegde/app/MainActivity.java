package io.github.rakshakhegde.app;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.github.rakshakhegde.app.databinding.ActivityMainBinding;
import io.github.rakshakhegde.lastpageradapter.LastPagerAdapter;
import io.github.rakshakhegde.sugarprefs.obsrvprefs.ObsrvIntPref;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActivityMainBinding activityMainBinding = DataBindingUtil
				.setContentView(this, R.layout.activity_main);

		new LastPagerAdapter(BR.model)
				.add(R.layout.progress_layout, "Progress", new ObsrvIntPref("PROGRESS"))
				.add(R.layout.sign_in_layout, "Sign In", new EmailPasswordModel(this))
				.into(activityMainBinding.viewpager);
	}
}
