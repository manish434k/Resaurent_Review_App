package com.reviewer.saju.saju_14133; /**
 * Created by Manish on 4/14/2015.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.reviewer.saju.saju_14133.util.Review;


public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "restaurantDB";

    // Reviewer table name
    private static final String TABLE_REVIEWER = "reviewer";

    // Table Columns names
    private static final String KEY_REVIEW_ID = "review_id";
    private static final String KEY_NAME = "restaurant_name";
    private static final String KEY_DATE = "review_date";
    private static final String KEY_TIME = "review_time";
    private static final String KEY_ADDRESS = "reviewer_address";
    private static final String KEY_COMP_COUNT = "companion_count";
    private static final String KEY_BILL = "bill_amount";
    private static final String KEY_TIP = "tip_amount";

    //rating table
    private static final String TABLE_RATING = "rating";

    //Rating table column name
    private static final String KEY_RATING_ID = "rating_id";
    private static final String KEY_FOOD = "food";
    private static final String KEY_WINE= "wine";
    private static final String KEY_AMBIANCE = "ambiance";
    private static final String KEY_STAFF = "staff";
    private static final String KEY_OVERALL = "overall";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_REVIEWER_TABLE = "CREATE TABLE " + TABLE_REVIEWER + "("
                + KEY_REVIEW_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_DATE + " TEXT"
                + KEY_TIME + " TEXT"
                + KEY_ADDRESS + " TEXT"
                + KEY_COMP_COUNT + " INTEGER"
                + KEY_BILL + " INTEGER"
                + KEY_TIP + " INTEGER" +")";

        String CREATE_RATING_TABLE = "CREATE TABLE " + TABLE_RATING + "("
                + KEY_RATING_ID + " INTEGER PRIMARY KEY,"
                + KEY_FOOD + " INTEGER,"
                + KEY_WINE + " INTEGER"
                + KEY_AMBIANCE + " INTEGER"
                + KEY_STAFF + " INTEGER"
                + KEY_OVERALL + " INTEGER" +" FOREIGN KEY ("+KEY_RATING_ID+") REFERENCES "+TABLE_REVIEWER+" ("+KEY_REVIEW_ID+"))";

        db.execSQL(CREATE_REVIEWER_TABLE);
        db.execSQL(CREATE_RATING_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RATING);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVIEWER);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new Review
    void addReview(Review review) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_REVIEW_ID, review.getId()); // ID
        values.put(KEY_NAME, review.getName()); // Rest Name
        values.put(KEY_DATE, review.getDate()); // Date
        values.put(KEY_TIME, review.getTime()); // Time
        values.put(KEY_ADDRESS, review.getAddress()); // Address
        values.put(KEY_COMP_COUNT, review.getCompanion()); // Companion
        values.put(KEY_BILL, review.getBill()); // Bill
        values.put(KEY_TIP, review.getTip()); // tip

        // Inserting Row
        db.insert(TABLE_REVIEWER, null, values);
        db.close(); // Closing database connection
    }

    // Getting single review
    Review  getReview(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_REVIEWER, new String[] { KEY_REVIEW_ID,
                        KEY_NAME, KEY_DATE, KEY_TIME, KEY_ADDRESS, KEY_COMP_COUNT,
                        KEY_BILL, KEY_TIP}, KEY_REVIEW_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Review review = new Review(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),
                cursor.getString(4),Integer.parseInt(cursor.getString(5)),
                Integer.parseInt(cursor.getString(6)),
                Integer.parseInt(cursor.getString(7)));
        // return review
        return review;
    }

    // Getting All Review
    public List<Review> getAllReviews() {
        List<Review> reviewList = new ArrayList<Review>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_REVIEWER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Review review = new Review();
                review.setId(Integer.parseInt(cursor.getString(0)));
                review.setName(cursor.getString(1));
                review.setDate(cursor.getString(2));
                review.setTime(cursor.getString(3));
                review.setAddress(cursor.getString(4));
                review.setCompanion(Integer.parseInt(cursor.getString(5)));
                review.setBill(Integer.parseInt(cursor.getString(6)));
                review.setTip(Integer.parseInt(cursor.getString(7)));
                // Adding review to list
                reviewList.add(review);
            } while (cursor.moveToNext());
        }

        // return review list
        return reviewList;
    }

    // Updating single review
    public int updateReview(Review review) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, review.getName()); // Rest Name
        values.put(KEY_DATE, review.getDate()); // Date
        values.put(KEY_TIME, review.getTime()); // Time
        values.put(KEY_ADDRESS, review.getAddress()); // Address
        values.put(KEY_COMP_COUNT, review.getCompanion()); // Companion
        values.put(KEY_BILL, review.getBill()); // Bill
        values.put(KEY_TIP, review.getTip()); // tip
        // updating row
        return db.update(TABLE_REVIEWER, values, KEY_REVIEW_ID + " = ?",
                new String[] { String.valueOf(review.getId()) });
    }

    // Deleting single review
    public void deleteReview(Review review) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_REVIEWER, KEY_REVIEW_ID + " = ?",
                new String[] { String.valueOf(review.getId()) });
        db.close();
    }


    // Getting reviews Count
    public int getReviewsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_REVIEWER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
