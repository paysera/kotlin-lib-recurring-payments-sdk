package com.paysera.lib.recurring_payments.filters

import com.paysera.lib.common.entities.BaseFilter

class RecurrenceFilter(
    offset: Int? = null,
    limit: Int? = null,
    orderBy: String? = null,
    orderDirection: String? = null,
    after: String? = null,
    before: String? = null,
    val id: Int? = null,
    val recurrenceType: String? = null,
    val transferType: String? = null,
    val dayOfWeek: Int? = null,
    val dayOfMonth: Int? = null,
    val senderCovenanteeId: Int? = null,
    val senderAccountNumber: String? = null
) : BaseFilter(
    offset = offset,
    limit = limit,
    orderBy = orderBy,
    orderDirection = orderDirection,
    after = after,
    before = before
)