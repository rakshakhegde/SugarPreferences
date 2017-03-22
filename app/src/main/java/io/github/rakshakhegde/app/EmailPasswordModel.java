package io.github.rakshakhegde.app;

import android.app.Activity;
import android.widget.Toast;

import io.github.rakshakhegde.sugarprefs.obsrvprefs.ObsrvStringPref;

/**
 * Created by rakshakhegde on 11/03/17.
 */

public class EmailPasswordModel {

	private final Activity act;
	public ObsrvStringPref email = new ObsrvStringPref("EMAIL");
	public ObsrvStringPref password = new ObsrvStringPref("PASSWORD");

	EmailPasswordModel(Activity _act) {
		act = _act;
	}

	public void signInBtnClicked() {
		Toast.makeText(act, email.get() + "\n" + password.get(), Toast.LENGTH_SHORT).show();
	}
}
