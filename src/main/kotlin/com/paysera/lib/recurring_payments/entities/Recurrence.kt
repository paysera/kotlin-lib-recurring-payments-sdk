package com.paysera.lib.recurring_payments.entities

import com.google.gson.annotations.SerializedName
import com.paysera.lib.accounts.entities.transfers.Transfer
import java.util.*

data class Recurrence(
    var id: Int,
    var status: String,
    @SerializedName("recurrence_type")
    var type: String,
    var transferType: String,
    var createdAt: Date,
    var transfer: Transfer,
    var dayOfWeek: Int?,
    var dayOfMonth: Int?
)