package com.teamwable.profile

import com.teamwable.profile.databinding.FragmentDeleteDialogBinding
import com.teamwable.ui.base.BindingDialogFragment
import com.teamwable.ui.extensions.dialogFragmentResize
import com.teamwable.ui.extensions.stringOf

class ProfileDeleteDialogFragment : BindingDialogFragment<FragmentDeleteDialogBinding>(FragmentDeleteDialogBinding::inflate) {
    override fun initView() {
        initText()
        initCancelBtnClickListener()
        initDeleteBtnClickListener()
    }

    private fun initText() {
        with(binding) {
            tvDeleteDialogTitle.text = stringOf(R.string.tv_profile_delete_dialog_title)
        }
    }

    override fun onResume() {
        super.onResume()
        context?.dialogFragmentResize(this, 30.0f)
    }

    private fun initCancelBtnClickListener() {
        binding.btnDeleteDialogCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun initDeleteBtnClickListener() {
        binding.btnDeleteDialogDelete.setOnClickListener {
            // Todo : 나중에 추가해야 함
        }
    }
}
