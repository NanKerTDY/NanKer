package com.ztb.nanke.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ztb.nanke.R;
import com.ztb.nanke.base.Store;


public class ExpandableAdapter extends BaseExpandableListAdapter {

	private Context context;
	private List<Store> stores;

	public ExpandableAdapter(Context context, List<Store> stores) {
		this.context = context;
		this.stores = stores;
	}

	public List<Store> getGroupData() {
		return stores;
	}

	public void setGroupData(List<Store> stores) {
		this.stores = stores;
	}

	@Override
	public int getGroupCount() {
		return stores.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return stores.get(groupPosition).getProducts().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return stores.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return stores.get(groupPosition).getProducts().get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		GroupViewHolder holder = null;
		if (convertView != null) {
			holder = (GroupViewHolder) convertView.getTag();
		} else {
			convertView = View.inflate(context, R.layout.group_item_layout,
					null);
			holder = new GroupViewHolder();
			holder.mGroupName = (TextView) convertView
					.findViewById(R.id.group_name);
			convertView.setTag(holder);
		}
		holder.mGroupName.setText(stores.get(groupPosition).getStoreName());
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		ChildViewHolder holder = null;
		if (convertView != null) {
			holder = (ChildViewHolder) convertView.getTag();
		} else {
			convertView = View.inflate(context, R.layout.child_item_layout,
					null);
			holder = new ChildViewHolder();
			holder.mIcon = (ImageView) convertView.findViewById(R.id.img);
			holder.mChildName = (TextView) convertView
					.findViewById(R.id.item_name);
			holder.mDetail = (TextView) convertView
					.findViewById(R.id.item_detail);
			convertView.setTag(holder);
		}
		// TODO set the image youself please
		holder.mChildName.setText(stores.get(groupPosition).getProducts()
				.get(childPosition).getName());
		holder.mDetail.setText(String.valueOf(stores.get(groupPosition)
				.getProducts().get(childPosition).getPrice()));
		return convertView;
	}

	private class GroupViewHolder {
		TextView mGroupName;
	}

	private class ChildViewHolder {
		ImageView mIcon;
		TextView mChildName;
		TextView mDetail;
	}
}
