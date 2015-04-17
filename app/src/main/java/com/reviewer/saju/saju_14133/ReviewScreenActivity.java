package com.reviewer.saju.saju_14133;


import com.reviewer.saju.saju_14133.util.Review;
import com.reviewer.saju.saju_14133.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class ReviewScreenActivity extends Activity {

    final Context context = this;

    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;
    private EditText editTxtdate;
    private EditText editTxtTime;
    private EditText editTxtRestNmae;
    private EditText editTxtAddress;
    private EditText editTxtNumCompanion;
    private EditText editTxtBill;
    private EditText editTxtTip;
    private RatingBar ratingOverall;
    private RatingBar ratingFood;
    private RatingBar ratingWine;
    private RatingBar ratingAmbiance;
    private RatingBar ratingStaff;
    private DatabaseHandler db;
    public DatabaseHandler getDb() {
        return db;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_review_screen);

        editTxtdate = (EditText) findViewById(R.id.editTextDate);
        editTxtTime = (EditText) findViewById(R.id.editTextTime);
        editTxtRestNmae = (EditText) findViewById(R.id.editTextRestName);
        editTxtAddress = (EditText) findViewById(R.id.editText_Address);
        editTxtNumCompanion = (EditText) findViewById(R.id.editTextNumCompanion);
        editTxtBill = (EditText) findViewById(R.id.editTextBill);
        editTxtTip = (EditText) findViewById(R.id.editTextTip);

        //Rating
        ratingFood =(RatingBar) findViewById(R.id.ratingBarFood);
        ratingWine =(RatingBar) findViewById(R.id.ratingBarWine);
        ratingAmbiance =(RatingBar) findViewById(R.id.ratingBarAmbiance);
        ratingStaff =(RatingBar) findViewById(R.id.ratingBarStaff);
        ratingOverall =(RatingBar) findViewById(R.id.ratingBarOverall);

        //Remove title bar
        ActionBar actionBar = getActionBar();
        // hide the action bar
        actionBar.hide();

         db = new DatabaseHandler(this);

        //current date on view
        setCurrentDateOnView();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }


    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    Handler mHideHandler = new Handler();
    Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            mSystemUiHider.hide();
        }
    };

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    // display current date
    public void setCurrentDateOnView() {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour =c.get(Calendar.HOUR);
        int min =c.get(Calendar.MINUTE);

        // set current date into textview
        editTxtdate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" (Date)"));

        editTxtTime.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(hour).append(":").append(min).append(" hours (Time)"));

    }

    public void popBillDialog(View view) {

        // custom dialog

    }

    public void review_submit(View view) {

        if(!(editTxtRestNmae.getText().toString().equals("")|
        editTxtdate.getText().toString().equals("")|
                editTxtTime.getText().toString().equals("")|
                editTxtAddress.getText().toString().equals("")|
                editTxtNumCompanion.getText().toString().equals("")|
               editTxtBill.getText().toString().equals("")|
                editTxtTip.getText().toString().equals(""))){

        //add to database
        if(addReviewToDatabase()) {
            //List<Review> review = db.getAllReviews();
            Intent i = new Intent(getApplicationContext(), ReviewDashboardActivity.class);
            startActivity(i);
            // close this activity
            finish();
        }

        }else
        {
            Toast.makeText(getApplicationContext(),"Please Enter All the details",Toast.LENGTH_LONG).show();
        }
    }

    boolean addReviewToDatabase()
    {
        boolean success=false;

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        int count=0;
        count=db.getReviewsCount();
        Log.d("Insert: ", "Inserting .."+count);

        count++;
        db.addReview(new Review(count,
                        editTxtRestNmae.getText().toString(),
                        editTxtdate.getText().toString(),
                        editTxtTime.getText().toString(),
                        editTxtAddress.getText().toString(),
                        Integer.parseInt(editTxtNumCompanion.getText().toString()),
                        Integer.parseInt(editTxtBill.getText().toString()),
                        Integer.parseInt(editTxtTip.getText().toString()),
                        ratingFood.getRating(),
                        ratingWine.getRating(),
                        ratingAmbiance.getRating(),
                        ratingStaff.getRating(),
                        ratingOverall.getRating()));
        success=true;

        return success;
    }

    public void tip_1(View view) {
       int bill= Integer.parseInt(editTxtBill.getText().toString());
       int tip= (int) (0.1*(bill));
       editTxtTip.setText( String.valueOf(tip));
    }

    public void tip_2(View view) {
        int bill= Integer.parseInt(editTxtBill.getText().toString());
        int tip= (int) (0.125*(bill));
        editTxtTip.setText( String.valueOf(tip));
    }

    public void tip_3(View view) {
        int bill= Integer.parseInt(editTxtBill.getText().toString());
        int tip= (int) (0.15*(bill));
        editTxtTip.setText( String.valueOf(tip));

    }
}
