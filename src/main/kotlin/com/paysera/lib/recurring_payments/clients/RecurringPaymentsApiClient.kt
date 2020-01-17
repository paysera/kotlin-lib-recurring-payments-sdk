package com.paysera.lib.recurring_payments.clients

import com.paysera.lib.accounts.entities.transfers.Transfer
import com.paysera.lib.common.entities.BaseFilter
import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import com.paysera.lib.recurring_payments.entities.Recurrence
import com.paysera.lib.recurring_payments.filters.RecurrenceFilter
import com.paysera.lib.recurring_payments.retrofit.NetworkApiClient
import kotlinx.coroutines.*
import retrofit2.Response

class RecurringPaymentsApiClient(
    private val networkApiClient: NetworkApiClient,
    private val apiRequestManager: ApiRequestManager
) : BaseApiClient(apiRequestManager) {

    fun getRecurrence(id: String): Deferred<Recurrence> {
        return networkApiClient.getRecurrence(
            id = id
        )
    }

    fun getRecurrences(filter: RecurrenceFilter): Deferred<MetadataAwareResponse<Recurrence>> {
        return networkApiClient.getRecurrences(
            offset = filter.offset,
            limit = filter.limit,
            orderBy = filter.orderBy,
            orderDirection = filter.orderDirection,
            after = filter.after,
            before = filter.before,
            id = filter.id,
            recurrenceType = filter.recurrenceType,
            transferType = filter.transferType,
            dayOfWeek = filter.dayOfWeek,
            dayOfMonth = filter.dayOfMonth,
            senderCovenanteeId = filter.senderCovenanteeId,
            senderAccountNumber = filter.senderAccountNumber
        )
    }

    fun getRecurrenceTransfers(id: String, filter: BaseFilter): Deferred<MetadataAwareResponse<Transfer>> {
        return networkApiClient.getRecurrenceTransfers(
            id = id,
            offset = filter.offset,
            limit = filter.limit,
            orderBy = filter.orderBy,
            orderDirection = filter.orderDirection,
            after = filter.after,
            before = filter.before
        )
    }

    fun createRecurrence(recurrence: Recurrence): Deferred<Recurrence> {
        return networkApiClient.createRecurrence(
            recurrence = recurrence
        )
    }

    fun updateRecurrence(id: String, recurrence: Recurrence): Deferred<Recurrence> {
        return networkApiClient.updateRecurrence(
            id = id,
            recurrence = recurrence
        )
    }

    fun cancelRecurrence(id: String): Deferred<Response<Void>> {
        return networkApiClient.cancelRecurrence(
            id = id
        )
    }
}