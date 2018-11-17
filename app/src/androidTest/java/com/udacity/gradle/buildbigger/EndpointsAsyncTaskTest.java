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
    String strJoke = null;

    @Test
    public void returnAsyncTaskEmptyTest() {

        try
        {
            /**
             * initialize a simple gate
             */
            countDownLatch = new CountDownLatch(1);

            /**
             * starts joke request
             */
            new EndpointsAsyncTask().execute(this);

            /**
             * wait until countDownLath reach zero or pass 5 seconds
             */
            countDownLatch.await(5, TimeUnit.SECONDS);

            /**
             * verify if asyncTask returns a valid string
             */
            assertNotNull("AsyncTask return is null", strJoke);
            assertFalse("AsyncTask return is empty", strJoke.isEmpty());
        }
        catch(InterruptedException e)
        {
            fail(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void resultOnPostExecute(String strJoke) {

        /**
         * Update result to compare
         */
        this.strJoke = strJoke;

        /**
         * Unblock gate to verify asyncTask resut
         */
        countDownLatch.countDown();
    }
}
