//package com.mohsen.persiancalendar.service;
//
//import com.mohsen.persiancalendar.util.UpdateUtils;
//import com.mohsen.persiancalendar.util.Utils;
//
//import androidx.work.Worker;
//
//public class UpdateWorker extends Worker {
//    @Override
//    public Worker.Result doWork() {
//        Utils.setChangeDateWorker();
//        Utils.updateStoredPreference(getApplicationContext());
//        UpdateUtils.update(getApplicationContext(), true);
//        return Result.SUCCESS;
//    }
//}