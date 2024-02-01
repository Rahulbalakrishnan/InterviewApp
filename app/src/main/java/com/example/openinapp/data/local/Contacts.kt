package com.example.openinapp.data.local

import com.example.openinapp.R

// TODO [COMPLETED] -> update this here for further expansion.

data class Contact(
    val image: Int,
    val info: String
)


val Contacts = listOf<Contact>(
    Contact(R.drawable.ic_wtsapp, "Talk with us"),
    Contact(R.drawable.ic_question_mark, "Frequently Asked Questions")
)
