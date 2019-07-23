package com.paysera.lib.recurring_payments.entities

import com.paysera.lib.accounts.entities.transfers.Transfer
import java.util.*

data class Recurrence(
    var id: Int,
    var status: String,
    var recurrenceType: String,
    var transferType: String,
    var createdAt: Date,
    var transfer: Transfer,
    var dayOfWeek: Int?,
    var dayOfMonth: Int?,
    var senderCovenanteeId: Int,
    var senderAccountNumber: String
)