package com.paysera.lib.recurring_payments.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.paysera.lib.accounts.entities.transfers.Transfer
import java.util.*

data class Recurrence(
    var id: Int? = null,
    var status: String? = null,
    @SerializedName("recurrence_type")
    var type: String,
    var transferType: String? = null,
    var createdAt: Date? = null,
    @SerializedName("transfer_data")
//    @JsonAdapter(TransferDataAdapter::class)
    var transfer: Transfer,
    var dayOfWeek: Int? = null,
    var dayOfMonth: Int? = null
)