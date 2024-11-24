package com.teamwable.news.news

import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import com.teamwable.designsystem.theme.WableTheme
import com.teamwable.news.NewsFragmentDirections
import com.teamwable.news.databinding.FragmentNewsNewsBinding
import com.teamwable.news.model.NewsInfoModel
import com.teamwable.ui.base.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsNewsFragment : BindingFragment<FragmentNewsNewsBinding>(FragmentNewsNewsBinding::inflate) {
    override fun initView() {
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                WableTheme {
                    NewsNewsRoute(
                        navigateToDetail = ::navigateToDetail,
                    )
                }
            }
        }
    }

    private fun navigateToDetail(notice: NewsInfoModel) {
        val action = NewsFragmentDirections.actionNavigationNewsToNavigationNewsDetail(notice)
        requireParentFragment().findNavController().navigate(action)
    }
}
