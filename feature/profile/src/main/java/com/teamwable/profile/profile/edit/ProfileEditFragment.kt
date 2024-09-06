package com.teamwable.profile.profile.edit

import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import com.teamwable.designsystem.theme.WableTheme
import com.teamwable.profile.R
import com.teamwable.profile.databinding.FragmentProfileEditBinding
import com.teamwable.ui.base.BindingFragment
import com.teamwable.ui.extensions.toast

class ProfileEditFragment : BindingFragment<FragmentProfileEditBinding>(FragmentProfileEditBinding::inflate) {
    override fun initView() {
        initProfileEditAppBar()
        initComposeView()
    }

    private fun initProfileEditAppBar() {
        binding.viewProfileEditAppbar.apply {
            btnProfileAppbarBack.setOnClickListener { findNavController().popBackStack() }
            tvProfileAppbarTitle.text = getString(R.string.profile_edit_app_bar)
        }
    }

    private fun initComposeView() {
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                WableTheme {
                    ProfileEditRoute(
                        navigateToProfile = { findNavController().popBackStack() },
                        onShowErrorSnackBar = { throwable -> toast(throwable?.message.toString()) },
                    )
                }
            }
        }
    }
}