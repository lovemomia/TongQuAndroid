package com.youxing.common.adapter;

import android.content.Context;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.youxing.common.utils.UnitTools;

public abstract class BasicAdapter extends BaseAdapter {
	public static final Object LOADING = new Object();
	public static final Object ERROR = new Object();
	public static final Object HEAD = new Object();
	public static final Object EMPTY = new Object();
	public static final Object LAST_EXTRA = new Object();

	protected View getLoadingView(ViewGroup parent, View convertView) {
		TextView loadingTV = convertView == null ? null
				: convertView.getTag() == EMPTY ? (TextView) convertView : null;
		if (loadingTV == null) {
			loadingTV = (TextView) createSimpleListItem18(parent.getContext());
			loadingTV.setTag(LOADING);
		}
		loadingTV.setText("正在加载，请稍侯...");
		return loadingTV;
	}

	protected View getFailedView(String msg, View.OnClickListener retry,
			ViewGroup parent, View convertView) {
		TextView errorTV = convertView == null ? null
				: convertView.getTag() == EMPTY ? (TextView) convertView : null;
		if (errorTV == null) {
			errorTV = (TextView) createSimpleListItem18(parent.getContext());
			errorTV.setTag(EMPTY);
		}

		errorTV.setText(msg + "，点击重试");
		errorTV.setOnClickListener(retry);
		return errorTV;
	}

	protected View getEmptyView(String msg, ViewGroup parent, View convertView) {

		TextView emptyTV = convertView == null ? null
				: convertView.getTag() == EMPTY ? (TextView) convertView : null;
		if (emptyTV == null) {
			emptyTV = (TextView) createSimpleListItem18(parent.getContext());
			emptyTV.setTag(ERROR);
		}

		emptyTV.setText(Html.fromHtml(msg));

		return emptyTV;
	}

	private View createSimpleListItem18(Context ctx) {
		TextView view = new TextView(ctx);
		view.setId(android.R.id.text1);
		view.setLayoutParams(new AbsListView.LayoutParams(
				AbsListView.LayoutParams.MATCH_PARENT,
				AbsListView.LayoutParams.WRAP_CONTENT));
		view.setTextAppearance(ctx, android.R.attr.textAppearanceMedium);
		int padding = UnitTools.dip2px(ctx, 16);
		view.setPadding(padding, padding, padding, padding);
		view.setGravity(Gravity.CENTER);
		return view;
	}

}
