package com.paysera.lib.recurring_payments.clients

import com.paysera.lib.accounts.entities.transfers.Transfer
import com.paysera.lib.common.entities.BaseFilter
import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.common.interfaces.BaseApiClient
import com.paysera.lib.common.interfaces.TokenRefresher
import com.paysera.lib.common.interfaces.retryWithTokenRefresher
import com.paysera.lib.recurring_payments.entities.Recurrence
import com.paysera.lib.recurring_payments.entities.RecurrenceRequest
import com.paysera.lib.recurring_payments.filters.RecurrenceFilter
import com.paysera.lib.recurring_payments.retrofit.NetworkApiClient
import kotlinx.coroutines.*

class RecurringPaymentsApiClient(
    private val networkApiClient: NetworkApiClient,
    private val tokenRefresherInterface: TokenRefresher
) : BaseApiClient {

    suspend fun getRecurrence(id: Int): Deferred<Recurrence> {
        return networkApiClient.getRecurrence(
            id = id
        ).retryWithTokenRefresher(tokenRefresherInterface)
    }

    suspend fun getRecurrences(filter: RecurrenceFilter): Deferred<MetadataAwareResponse<Recurrence>> {
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
        ).retryWithTokenRefresher(tokenRefresherInterface)
    }

    suspend fun getRecurrenceTransfers(id: Int, filter: BaseFilter): Deferred<MetadataAwareResponse<Transfer>> {
        return networkApiClient.getRecurrenceTransfers(
            id = id,
            offset = filter.offset,
            limit = filter.limit,
            orderBy = filter.orderBy,
            orderDirection = filter.orderDirection,
            after = filter.after,
            before = filter.before
        ).retryWithTokenRefresher(tokenRefresherInterface)
    }

    suspend fun createRecurrence(request: RecurrenceRequest): Deferred<Recurrence> {
        return networkApiClient.createRecurrence(

        ).retryWithTokenRefresher(tokenRefresherInterface)
    }

    suspend fun updateRecurrence(id: Int, request: RecurrenceRequest): Deferred<Recurrence> {
        return networkApiClient.updateRecurrence(
            id = id
        ).retryWithTokenRefresher(tokenRefresherInterface)
    }

    suspend fun cancelRecurrence(id: Int): Deferred<Void> {
        return networkApiClient.cancelRecurrence(
            id = id
        ).retryWithTokenRefresher(tokenRefresherInterface)
    }
}