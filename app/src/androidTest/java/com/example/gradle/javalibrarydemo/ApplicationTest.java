package com.example.gradle.javalibrarydemo;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;
import android.test.mock.MockContext;
import android.view.Display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }

//    CountDownLatch signal = null;
    String resultObtained = "";

    @Override
    protected void setUp() throws Exception {
        super.setUp();

//        signal = new CountDownLatch(1);
    }

    public void testAsynctask() throws InterruptedException {



        Context context = new MockContext();

        assertNotNull(context);

        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();


        resultObtained = asyncTask.doInBackground(new Pair<Context, String>(context,"Manfred"));

        assertTrue(resultObtained.length()>0);




    }

}