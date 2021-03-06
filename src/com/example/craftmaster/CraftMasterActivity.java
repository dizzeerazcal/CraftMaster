package com.example.craftmaster;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class CraftMasterActivity extends ListActivity {

	private CraftAdapter craftAdapter;
	private List<Craft> crafts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.craft_master);

		crafts = CraftGenerator.generateCrafts();
		craftAdapter = new CraftAdapter(this, R.layout.craft_item, crafts);

		setListAdapter(craftAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		String message = getString(R.string.lipsum_message, crafts
				.get(position).getText());

		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

		super.onListItemClick(l, v, position, id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.craft_master, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
