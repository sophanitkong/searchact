package com.searchact.app.utils

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.searchact.app.R
import kotlinx.android.synthetic.main.delete_job_dialog.view.*
import kotlinx.android.synthetic.main.delete_job_dialog.view.btnCancel
import kotlinx.android.synthetic.main.delete_job_dialog.view.tvDialogMessage
import kotlinx.android.synthetic.main.delete_job_dialog.view.tvDialogTitle
import kotlinx.android.synthetic.main.layout_claim_dialog.view.*
import kotlinx.android.synthetic.main.layout_fail_payment.view.*
import kotlinx.android.synthetic.main.layout_success_report_flag.view.*
import java.util.*


object Core {

    fun showDeleteDialog(context: Context, title: String, message: String) {
        val builder =
            AlertDialog.Builder(context)
        val dialogView: View =
            LayoutInflater.from(context)
                .inflate(R.layout.delete_job_dialog, null, false)

        builder.setView(dialogView)
        val alertDialog = builder.create()
        dialogView.tvDialogTitle.text = title
        dialogView.tvDialogMessage.text = message
        dialogView.btnCancel.setOnClickListener { alertDialog.dismiss() }
        dialogView.btnDelete.setOnClickListener { alertDialog.dismiss() }
        alertDialog.setCancelable(false)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
    }

    fun showClaimDialog(context: Context, title: String, message: String) {
        val builder =
            AlertDialog.Builder(context)
        val dialogView: View =
            LayoutInflater.from(context)
                .inflate(R.layout.layout_claim_dialog, null, false)

        builder.setView(dialogView)
        val alertDialog = builder.create()
        dialogView.tvDialogTitle.text = title
        dialogView.tvDialogMessage.text = message
        dialogView.btnCancel.setOnClickListener { alertDialog.dismiss() }
        dialogView.btnClaimTryAgain.setOnClickListener { alertDialog.dismiss() }
        alertDialog.setCancelable(false)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
    }

    fun showSuccessReportFlagDialog(
        context: Context,
        title: String,
        message: String,
        handler: () -> Unit
    ) {
        val builder =
            AlertDialog.Builder(context)
        val dialogView: View =
            LayoutInflater.from(context)
                .inflate(R.layout.layout_success_report_flag, null, false)

        builder.setView(dialogView)
        val alertDialog = builder.create()
        dialogView.tvDialogTitle.text = title
        dialogView.tvDialogMessage.text = message
        dialogView.btnSuccessReportFlag.setOnClickListener {
            handler()
            alertDialog.dismiss()
        }
        alertDialog.setCancelable(false)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
    }

    fun showFailPayment(context: Context, title: String, message: String) {
        val builder =
            AlertDialog.Builder(context)
        val dialogView: View =
            LayoutInflater.from(context)
                .inflate(R.layout.layout_fail_payment, null, false)

        builder.setView(dialogView)
        val alertDialog = builder.create()
        dialogView.tvDialogTitle.text = title
        dialogView.tvDialogMessage.text = message
        dialogView.btnCancel.setOnClickListener { alertDialog.dismiss() }
        dialogView.btnPaymentTryAgain.setOnClickListener { alertDialog.dismiss() }
        alertDialog.setCancelable(false)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun showDatePicker(context: Context) {
        val dialog = DatePickerDialog(context)
        dialog.show()
    }

    fun showTimePicker(context: Context) {
        val c = Calendar.getInstance()
        val mHour = c[Calendar.HOUR_OF_DAY]
        val mMinute = c[Calendar.MINUTE]

        val timePickerDialog = TimePickerDialog(
            context,
            OnTimeSetListener { view, hourOfDay, minute -> },
            mHour,
            mMinute,
            false
        )
        timePickerDialog.show()
    }
}