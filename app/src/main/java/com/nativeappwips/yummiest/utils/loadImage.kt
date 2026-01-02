package com.nativeappwips.yummiest.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.RequestOptions

@SuppressLint("CheckResult")
fun loadImage(
        context: Context,
        url: String?,
        localImg: Int? = null,
        imageView: ImageView,
        placeholder: Int? = null,
        error: Int? = null,
        circleCrop: Boolean = false
) {
    val request = if (url.isNullOrEmpty()) {
        Glide.with(context).load(localImg)
    } else {
        Glide.with(context).load(url)
    }

    // Apply placeholder and error if provided
    placeholder?.let { request.placeholder(it) }
    error?.let { request.error(it) }

    // Apply circle crop if enabled
    if (circleCrop) {
        request.apply(RequestOptions.circleCropTransform())
    }

    request.into(imageView)
}