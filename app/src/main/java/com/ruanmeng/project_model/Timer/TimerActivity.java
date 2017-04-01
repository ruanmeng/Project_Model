package com.ruanmeng.project_model.Timer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.ruanmeng.BaseActivity;
import com.ruanmeng.project_model.R;
import com.ruanmeng.utils.CommonUtil;


/**
 * 倒计时演示Demo
 *
 * @author zhouyou
 */
public class TimerActivity extends BaseActivity implements CountdownView.OnCountdownEndListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        init_title();
        changeTitle("秒杀倒计时", null);

        CountdownView mCvCountdownViewTest1 = (CountdownView) findViewById(R.id.cv_countdownViewTest1);
        mCvCountdownViewTest1.setTag("test1");
        long time1 = (long) 5 * 60 * 60 * 1000;
        mCvCountdownViewTest1.start(time1);

        CountdownView mCvCountdownViewTest2 = (CountdownView) findViewById(R.id.cv_countdownViewTest2);
        mCvCountdownViewTest1.setTag("test2");
        long time2 = (long) 30 * 60 * 1000;
        mCvCountdownViewTest2.start(time2);

        CountdownView mCvCountdownViewTest3 = (CountdownView) findViewById(R.id.cv_countdownViewTest3);
        long time3 = (long) 9 * 60 * 60 * 1000;
        mCvCountdownViewTest3.start(time3);

        CountdownView mCvCountdownViewTest4 = (CountdownView) findViewById(R.id.cv_countdownViewTest4);
        long time4 = (long) 150 * 24 * 60 * 60 * 1000;
        mCvCountdownViewTest4.start(time4);

        final CountdownView mCvCountdownViewTest5 = (CountdownView) findViewById(R.id.cv_countdownViewTest5);
        new AsyncTask<Void, Long, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                long time = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                        time += 1000;
                        publishProgress(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            protected void onProgressUpdate(Long... values) {
                super.onProgressUpdate(values);
                mCvCountdownViewTest5.updateShow(values[0]);
            }
        }.execute();

        CountdownView mCvCountdownViewTest6 = (CountdownView) findViewById(R.id.cv_countdownViewTest6);
//        long time6 = (long)2 * 60 * 60 * 1000;
        long time6 = (long)  10 * 1000;
        mCvCountdownViewTest6.setTag("lfc");
        mCvCountdownViewTest6.start(time6);
//
//        mCvCountdownViewTest6.restart();
    }

    @Override
    public void onEnd(CountdownView cv) {
        // 倒计时结束时调用该方法
        Object tag = cv.getTag();

        if (null != tag) {
            Log.i("wg", "tag = " + tag.toString());
            CommonUtil.showToask(baseContext,tag.toString());
        }
    }
}
