package com.aosap.settings.fragments;

import com.android.internal.logging.nano.MetricsProto;

import android.os.Bundle;
import com.android.settings.R;

import com.android.settings.SettingsPreferenceFragment;

import android.content.Context;
import android.content.res.Resources;

import androidx.preference.ListPreference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreference;

public class NotificationSettings extends SettingsPreferenceFragment {

    private static final String ALERT_SLIDER_PREF = "alert_slider_notifications";

    private Preference mAlertSlider;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        addPreferencesFromResource(R.xml.aosap_settings_notifications);

        final Context mContext = getActivity().getApplicationContext();

        final Resources res = mContext.getResources();

        final PreferenceScreen prefSet = getPreferenceScreen();

        mAlertSlider = (Preference) findPreference(ALERT_SLIDER_PREF);
        boolean mAlertSliderAvailable = res.getBoolean(
                com.android.internal.R.bool.config_hasAlertSlider);
        if (!mAlertSliderAvailable)
            prefSet.removePreference(mAlertSlider);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.AOSAP;
    }
}
