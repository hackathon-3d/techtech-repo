package com.tech.inventory;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class InventoryCreate extends Inventory {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inventory, menu);
		return true;
	}
	
	protected void selectFields(View view)
	{
		//DatabaseHandler dbHandler = new DatabaseHandler();
		//dbHandler = new DatabaseHandler(this);
		
		
	}

}
