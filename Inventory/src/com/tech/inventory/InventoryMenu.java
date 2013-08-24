package com.tech.inventory;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

public class InventoryMenu extends Inventory {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		boolean myTableExists = false;
		try 
		{
	        SQLiteDatabase.openDatabase("myDatabase", null, SQLiteDatabase.OPEN_READONLY);
	        myTableExists = true;
	    } 
		catch (SQLiteException e) 
		{
	        // database doesn't exist yet.
	    }
		
		Button btn = (Button) findViewById(R.id.setupButton);

		if (myTableExists)
			btn.setEnabled(false);
		else
			btn.setEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inventory, menu);
		return true;
	}

}