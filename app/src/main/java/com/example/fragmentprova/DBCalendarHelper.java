package com.example.fragmentprova;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.provider.CalendarContract;

import java.util.Calendar;

import static com.example.fragmentprova.DBCalendar.EVENT_PROJECTION;

public class DBCalendarHelper {

    private DBCalendar dbCalendar = new DBCalendar();
    private Context context;

    public DBCalendarHelper(Context context){
        this.context = context;
    }

    void ReadData(){
        // Run query

        Cursor cur = null;
        ContentResolver cr = context.getContentResolver();
        Uri uri = CalendarContract.Calendars.CONTENT_URI;
        String selection = "((" + CalendarContract.Calendars.ACCOUNT_NAME + " = ?) AND ("
                + CalendarContract.Calendars.ACCOUNT_TYPE + " = ?) AND ("
                + CalendarContract.Calendars.OWNER_ACCOUNT + " = ?))";
        String[] selectionArgs = new String[] {"hera@example.com", "com.example",
                "hera@example.com"};
        // Submit the query and get a Cursor object back.
        cur = cr.query(uri, EVENT_PROJECTION, selection, selectionArgs, null);
    }
}
