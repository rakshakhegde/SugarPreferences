package io.github.rakshakhegde.sugarprefs;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class SugarPreferencesInitProvider extends ContentProvider {

	@Override
	public boolean onCreate() {
		// Get the Application Context
		SugarPreferencesApp.ctx = getContext();
		return true;
	}

	@Override
	public void attachInfo(Context context, ProviderInfo providerInfo) {
		if (providerInfo == null) {
			throw new NullPointerException("SugarPreferencesInitProvider ProviderInfo cannot be null.");
		}
		// So if the authorities equal the library internal ones, the developer forgot to set his applicationId
		if ("io.github.rakshakhegde.sugarpref.sugarprefsinitprovider".equals(providerInfo.authority)) {
			throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a "
					+ "missing applicationId variable in application\'s build.gradle.");
		}
		super.attachInfo(context, providerInfo);
	}

	@Nullable
	@Override
	public Cursor query(
			@NonNull Uri uri,
			String[] projection,
			String selection,
			String[] selectionArgs,
			String sortOrder
	) {
		return null;
	}

	@Nullable
	@Override
	public String getType(@NonNull Uri uri) {
		return null;
	}

	@Nullable
	@Override
	public Uri insert(@NonNull Uri uri, ContentValues values) {
		return null;
	}

	@Override
	public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	@Override
	public int update(
			@NonNull Uri uri,
			ContentValues values,
			String selection,
			String[] selectionArgs
	) {
		return 0;
	}
}
