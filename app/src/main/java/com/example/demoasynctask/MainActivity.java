
package com.example.demoasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar mProgress;
    private TextView mTextView;
    private Button mButtonStart;
    private Button mButtonStop;
    MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = findViewById(R.id.progressBar1);
//        mProgress.setMax(100);
        mTextView = findViewById(R.id.textView1);
        mButtonStart = findViewById(R.id.buttonStart);
        mButtonStop = findViewById(R.id.buttonStop);
        myAsyncTask = new MyAsyncTask(this);

        mButtonStart.setOnClickListener(this);
        mButtonStop.setOnClickListener(this);
    }


//    public void startProgress(View view) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <= 10; i++) {
//                    final int value = i;
//                    doFakeWork();
//                    mProgress.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            mTextView.setText("Updating");
//                            mProgress.setProgress(value);
//                        }
//                    });
//                }
//            }
//        };
//        new Thread(runnable).start();
//    }

    // Simulating something timeconsuming
    private void doFakeWork() {
        SystemClock.sleep(5000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonStart:
                startProgress();
                break;
            case R.id.buttonStop:
                stopProgress();
                break;
        }
    }

    private void stopProgress() {
        myAsyncTask.cancel(true);
    }

    private void startProgress() {
//        if (mProgress.getProgress()!=0){
//            mProgress.setProgress(0);
//        }
//        myAsyncTask.execute();
        mProgress.setVisibility(View.VISIBLE);
        mProgress.setMax(100);
    }
}

