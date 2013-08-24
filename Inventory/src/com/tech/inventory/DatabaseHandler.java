package com.tech.inventory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
		 
	    // All Static variables
	    // Database Version
	    private static final int DATABASE_VERSION = 1;
	 
	    // Database Name
	    private static final String DATABASE_NAME = "myDatabase";
	 
	    // Contacts table name
	    private static final String TABLE_NAME = "myTable";
	   
	 
	    public Context mContext;
	    public DatabaseHandler(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	        this.mContext = context;
	    }
	    
	    // Creating Tables
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	    	String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY,";
	    	
	    	String[] columns = mContext.getResources().getStringArray(R.array.columns);
	    	int columnLength = columns.length; 
	        for (String column: columns)
	    	{
	        	String[] parts = column.split(",");
        		String columnName = parts[0];
        		String columnType = parts[1];
        		columnLength -= 1;
	        	if (columnLength == 1)	//last one
	        	{
	        		CREATE_TABLE += columnName + " " + columnType;
	        	}
	        	else
	        	{
	        		CREATE_TABLE += columnName + " " + columnType + ",";
	        	}
	    	}
	        
	        CREATE_TABLE += ")";
	        db.execSQL(CREATE_TABLE);
	    }
	 
	    // Upgrading database
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        // Drop older table if existed
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	 
	        // Create tables again
	        onCreate(db);
	    }
}

