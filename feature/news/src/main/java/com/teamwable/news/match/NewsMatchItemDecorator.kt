package com.teamwable.news.match

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.teamwable.ui.extensions.pxToDp

class NewsMatchItemDecorator(val context: Context) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val itemCount = parent.adapter?.itemCount ?: 0

        if (position != itemCount - 1) outRect.bottom = context.pxToDp(32)
        else outRect.bottom = context.pxToDp(48)
    }
}
