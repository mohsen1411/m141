package com.mohsen.persiancalendar.view.activity;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.mohsen.persiancalendar.R;
import com.mohsen.persiancalendar.util.UIUtils;
import com.mohsen.persiancalendar.util.UpdateUtils;
import com.mohsen.persiancalendar.util.Utils;
import com.mohsen.persiancalendar.view.preferences.FragmentWidgetNotification;

import androidx.appcompat.app.AppCompatActivity;

import static com.mohsen.persiancalendar.Constants.LIGHT_THEME;
import static com.mohsen.persiancalendar.Constants.PREF_THEME;

public class WidgetConfigurationActivity extends AppCompatActivity {
    protected void finishAndSuccess() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int appwidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);
            setResult(RESULT_OK, new Intent()
                    .putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appwidgetId));
        }
        Utils.updateStoredPreference(this);
        UpdateUtils.update(this, false);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        setTheme(UIUtils.getThemeFromName(prefs.getString(PREF_THEME, LIGHT_THEME)));

        Utils.applyAppLanguage(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_preference_layout);

        getSupportFragmentManager().beginTransaction().add(
                R.id.preference_fragment_holder,
                new FragmentWidgetNotification(), "TAG").commit();

        findViewById(R.id.add_widget_button).setOnClickListener(v -> finishAndSuccess());
    }
}
