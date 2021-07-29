package com.dev.topefirstapplication.ui.dashboard

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager.LayoutParams.FLAG_BLUR_BEHIND
import androidx.fragment.app.DialogFragment
import com.dev.topefirstapplication.R

class CreateProductDialogFragment() : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_add_product,
            container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val bundle = arguments
        if(bundle != null){
            courseId = bundle.getInt("courseId")
        }*/
    }

    fun newInstance(bundle : Bundle) : CreateProductDialogFragment{
        val fragment = CreateProductDialogFragment()
        fragment.arguments = bundle
        return fragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val height = resources.getDimensionPixelSize(R.dimen.add_product_card_view_height)
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, height)
        dialog?.window?.setGravity(Gravity.BOTTOM)
        dialog?.window?.clearFlags(FLAG_BLUR_BEHIND)

        if (dialog?.window != null) {
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    interface ReFetchProductListener {
        fun fetchProduct()
    }
}
