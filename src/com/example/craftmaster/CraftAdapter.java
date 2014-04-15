package com.example.craftmaster;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class CraftAdapter extends ArrayAdapter<Craft> {

	public LayoutInflater layoutInflater;

	public CraftAdapter(Context context, int resource, List<Craft> crafts) {
		super(context, resource, crafts);

		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view = convertView;
		Holder holder = null;
		Craft craft = getItem(position);

		if (view == null) {
			view = layoutInflater.inflate(R.layout.craft_item, null);
			TextView craftId = (TextView) view.findViewById(R.id.craft_id);
			TextView craftText = (TextView) view.findViewById(R.id.craft_text);
			holder = new Holder(craftId, craftText);
			view.setTag(holder);
		} else {
			holder = (Holder) view.getTag();
		}

		holder.craftID.setText(String.valueOf((craft.getIndex())));
		holder.craftText.setText(craft.getText());

		return view;
	}

	static class Holder {

		private TextView craftID;
		private TextView craftText;

		public Holder(TextView craftID, TextView craftText) {
			this.craftID = craftID;
			this.craftText = craftText;
		}

	}

}
