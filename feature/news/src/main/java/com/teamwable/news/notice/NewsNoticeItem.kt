package com.teamwable.news.notice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teamwable.designsystem.theme.WableTheme
import com.teamwable.model.news.NewsInfoModel
import com.teamwable.news.news.component.WableNewsTimeText

@Composable
fun NewsNoticeItem(
    data: NewsInfoModel,
    onItemClick: (NewsInfoModel) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(WableTheme.colors.white)
            .clickable { onItemClick(data) }
            .padding(vertical = 12.dp, horizontal = 20.dp)
    ) {
        Row {
            Text(text = data.newsTitle, style = WableTheme.typography.body01)
            Spacer(modifier = Modifier.weight(1f))
            WableNewsTimeText(data.time)
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = data.newsText, color = WableTheme.colors.gray600, maxLines = 2, style = WableTheme.typography.body04)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsNoticeItemPreview() {
    WableTheme {
        NewsNoticeItem(
            data = NewsInfoModel(1, "제목", "내용", null, "2024-01-10 11:47:18"),
            onItemClick = {}
        )
    }
}
