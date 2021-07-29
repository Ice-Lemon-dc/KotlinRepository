package com.dc.kotlinrepository.view

import android.app.Dialog
import android.content.Context
import com.dc.kotlinrepository.R

object LoadingDialog {
    fun show1(){}

    private var dialog: Dialog? = null

    fun show(context: Context) {
        cancel()
        dialog = Dialog(context)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }

    fun cancel() {
        dialog?.dismiss()
    }
}