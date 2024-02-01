package com.example.openinapp.ui.helper.get

import android.content.ClipData
import android.content.Context


// Custom function to copy text directly
// TODO -> ClipboardManagerCompat from the androidx.core.content,
//  is not working in jetpack compose, clipboardManager.setPrimaryClip is not working in jetpack composable,


// TODO -> Generated Custom function by ChatGpt
fun copyTextToClipboard(context: Context, text: String) {
    val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
    val clip = ClipData.newPlainText("Copied Text", text)
    clipboardManager.setPrimaryClip(clip)
}
