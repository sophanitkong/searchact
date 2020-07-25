package com.searchact.app.payment.ui

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.searchact.app.R
import kotlinx.android.synthetic.main.fragment_confirm.view.*

/**
 * A simple [Fragment] subclass.
 */
class ConfirmFragment : Fragment() {

    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_confirm, container, false)

        root.tvCardNumber.text = "****  ****  ****  0123"
        root.tvCardNumber.transformationMethod = PasswordTransformationMethod()

        return root
    }

}
