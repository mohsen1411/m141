package com.mohsen.persiancalendar;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

import com.mohsen.persiancalendar.util.UpdateUtils;
import com.mohsen.persiancalendar.util.Utils;

/**
 * 1x1 widget provider, implementation is on {@code CalendarWidget}
 *
 * @author ebraminio
 */
public class Widget1x1 extends AppWidgetProvider {
    @Override
    public void onReceive(Context context, Intent intent) {
        Utils.startEitherServiceOrWorker(context);
        UpdateUtils.update(context, false);
    }
}
