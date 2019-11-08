package com.example.demoasynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    private Activity mContextParent;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private String TAG = "hieuvh";

    public MyAsyncTask(Activity mContextParent) {
        this.mContextParent = mContextParent;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i <= 100; i = i + 5) {
            SystemClock.sleep(1000);
            Log.d(TAG, "doInBackgroundBeforeCanceled: " + i);
            publishProgress(i);
            Log.d(TAG, "doInBackgroundAfterCanceled: " + i);
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar = mContextParent.findViewById(R.id.progressBar1);
        mTextView = mContextParent.findViewById(R.id.textView1);
        mProgressBar.setVisibility(View.VISIBLE);
        mProgressBar.setProgress(0);
        mProgressBar.setMax(100);
        Log.d(TAG, "onPreExecute: ");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        SystemClock.sleep(2000);
        mTextView.setText("finish");
        Log.d(TAG, "onPostExecute: ");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int number = values[0];
        mProgressBar.setProgress(number);
        mTextView.setText("updating... (" + number + "%)");
        Log.d(TAG, "onProgressUpdate: ");
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        mProgressBar.setProgress(0);
        mTextView.setText("canceled");
    }
}
