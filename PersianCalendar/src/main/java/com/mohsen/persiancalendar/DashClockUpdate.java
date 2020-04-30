package com.mohsen.persiancalendar;

import android.content.Intent;

import com.mohsen.persiancalendar.util.CalendarUtils;
import com.mohsen.persiancalendar.util.Utils;
import com.mohsen.persiancalendar.view.activity.MainActivity;
import com.google.android.apps.dashclock.api.DashClockExtension;
import com.google.android.apps.dashclock.api.ExtensionData;

import calendar.AbstractDate;
import calendar.CalendarType;

public class DashClockUpdate extends DashClockExtension {
    @Override
    protected void onUpdateData(int reason) {
        setUpdateWhenScreenOn(true);
        CalendarType mainCalendar = Utils.getMainCalendar();
        long jdn = CalendarUtils.getTodayJdn();
        AbstractDate date = CalendarUtils.getDateFromJdnOfCalendar(mainCalendar, jdn);
        publishUpdate(new ExtensionData().visible(true)
                .icon(Utils.getDayIconResource(date.getDayOfMonth()))
                .status(CalendarUtils.getMonthName(date))
                .expandedTitle(CalendarUtils.dayTitleSummary(date))
                .expandedBody(Utils.dateStringOfOtherCalendars(jdn))
                .clickIntent(new Intent(getApplicationContext(), MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
    }
}
