package com.esdonmez.esd.healthmonitor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.esdonmez.esd.healthmonitor.Models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "HealthMonitorDB";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE UserTable(UserId INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                          "UserName TEXT," +
                                                          "Email TEXT NOT NULL," +
                                                          "Password TEXT NOT NULL)";
        db.execSQL(CREATE_USER_TABLE);

        String CREATE_BODY_PART_TABLE = "CREATE TABLE BodyPartTable(BodyPartId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                                                                   "Name TEXT," +
                                                                   "Status TEXT)";
        db.execSQL(CREATE_BODY_PART_TABLE);

        String CREATE_ACTIVITY_TABLE = "CREATE TABLE ActivityTable(ActivityId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                                                                  "BodyPartId INTEGER," +
                                                                  "Name TEXT," +
                                                                  "Type TEXT," +
                                                                  "Calorie INTEGER," +
                                                                  "StartTime TEXT," +
                                                                  "Duration INTEGER," +
                                                                  "FOREIGN KEY (BodyPartId) REFERENCES BodyPartTable(BodyPartId))";
        db.execSQL(CREATE_ACTIVITY_TABLE);

        String CREATE_USER_FEATURE_TABLE = "CREATE TABLE UserFeatureTable(UserFeatureId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                                                                         "UserId INTEGER," +
                                                                         "EnergyLevel INTEGER," +
                                                                         "HealthStatus TEXT," +
                                                                         "TotalCalorie INTEGER," +
                                                                         "FOREIGN KEY (UserId) REFERENCES UserTable(UserId))";
        db.execSQL(CREATE_USER_FEATURE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS UserTable");
        db.execSQL("DROP TABLE IF EXISTS BodyPartTable");
        db.execSQL("DROP TABLE IF EXISTS ActivityTable");
        db.execSQL("DROP TABLE IF EXISTS UserFeatureTable");
        // Creating tables again
        onCreate(db);
    }

    public void addUser(UserModel user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("UserName", user.getUserName());
        values.put("Email", user.getEmail());
        values.put("Password", user.getPassword());

        // Inserting Row
        db.insert("UserTable", null, values);
        db.close(); // Closing database connection
    }

    public int login(UserModel user) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT UserId FROM UserTable WHERE Email='" + user.getEmail() + "' AND Password='" + user.getPassword() + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null)
        {
            cursor.moveToFirst();

            UserModel model = new UserModel(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3));

            return model.getUserId();
        }
        else
            return 0;
    }

    public UserModel getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM UserTable WHERE UserId=1";
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null)
            cursor.moveToFirst();

        UserModel model = new UserModel(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return model;
    }

    public List<UserModel> getAllUsers() {
        List<UserModel> userList = new ArrayList<UserModel>();
        // Select All Query
        String selectQuery = "SELECT * FROM UserTable";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserModel user = new UserModel();
                user.setUserId(Integer.parseInt(cursor.getString(0)));
                user.setUserName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPassword(cursor.getString(2));
                // Adding contact to list
                userList.add(user);
            } while (cursor.moveToNext());
        }

        // return contact list
        return userList;
    }

    public int getUsersCount() {
        String countQuery = "SELECT COUNT(*) FROM UserTable";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public int updateUser(UserModel user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("UserName", user.getUserName());
        values.put("Email", user.getEmail());
        values.put("Password", user.getPassword());

        // updating row
        return db.update("UserTable", values, "UserId" + " = ?",
        new String[]{String.valueOf(user.getUserId())});
    }

    public void deleteUser(UserModel user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("UserTable", "UserId" + " = ?",
        new String[] { String.valueOf(user.getUserId()) });
        db.close();
    }
}
