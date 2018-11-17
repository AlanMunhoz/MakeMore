package com.udacity.gradle.buildbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest implements EndpointsAsyncTask.CallbackAsyncTask {

    CountDownLatch countDownLatch;
    String joke;

    @Test
    public void returnAsyncTaskEmptyTest() {

        try
        {
            countDownLatch = new CountDownLatch(1);
            new EndpointsAsyncTask().execute(this);
            countDownLatch.await(10, TimeUnit.SECONDS);
            assertNotNull("AsyncTask return is null", joke);
            assertFalse("AsyncTask return is empty", joke.isEmpty());
        }
        catch(InterruptedException e)
        {
            fail(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void resultOnPostExecute(String strJoke) {

        this.joke = strJoke;
        countDownLatch.countDown();
    }
}
