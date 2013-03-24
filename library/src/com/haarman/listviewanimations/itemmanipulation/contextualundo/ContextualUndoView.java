/*
 * Copyright 2013 Frankie Sardo
 * Copyright 2013 Niek Haarman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.haarman.listviewanimations.itemmanipulation.contextualundo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

@SuppressLint("ViewConstructor")
public class ContextualUndoView extends FrameLayout {

	private View undoView;
	private View contentView;
	private long itemId;

	public ContextualUndoView(Context context, int undoLayoutResourceId) {
		super(context);
		initUndo(undoLayoutResourceId);
	}

	private void initUndo(int undoLayoutResourceId) {
		undoView = View.inflate(getContext(), undoLayoutResourceId, null);
		addView(undoView);
	}

	public void updateContentView(View contentView) {
		if (this.contentView == null) {
			addView(contentView);
		}
		this.contentView = contentView;
	}

	public View getContentView() {
		return contentView;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getItemId() {
		return itemId;
	}

	public boolean isContentDisplayed() {
		return contentView.getVisibility() == View.VISIBLE;
	}

	public void displayUndo() {
		contentView.setVisibility(View.GONE);
		undoView.setVisibility(View.VISIBLE);
	}

	public void displayContentView() {
		contentView.setVisibility(View.VISIBLE);
		undoView.setVisibility(View.GONE);
	}
}