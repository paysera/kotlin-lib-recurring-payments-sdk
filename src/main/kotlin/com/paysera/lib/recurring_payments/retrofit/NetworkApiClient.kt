package com.paysera.lib.recurring_payments.retrofit

import com.paysera.lib.accounts.entities.transfers.Transfer
import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.recurring_payments.entities.Recurrence
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface NetworkApiClient {

    @GET("recurrences/{id}")
    fun getRecurrence(
        @Path("id") id: String
    ): Deferred<Recurrence>

    @GET("recurrences")
    fun getRecurrences(
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?,
        @Query("order_direction") orderDirection: String?,
        @Query("after") after: String?,
        @Query("before") before: String?,
        @Query("id") id: String?,
        @Query("recurrence_type") recurrenceType: String?,
        @Query("transfer_type") transferType: String?,
        @Query("day_of_week") dayOfWeek: Int?,
        @Query("day_of_month") dayOfMonth: Int?,
        @Query("sender_covenantee_id") senderCovenanteeId: Int?,
        @Query("sender_account_number") senderAccountNumber: String?
    ): Deferred<MetadataAwareResponse<Recurrence>>

    @GET("recurrences/{id}/transfers")
    fun getRecurrenceTransfers(
        @Path("id") id: String?,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?,
        @Query("order_direction") orderDirection: String?,
        @Query("after") after: String?,
        @Query("before") before: String?
    ): Deferred<MetadataAwareResponse<Transfer>>

    @POST("recurrences/")
    fun createRecurrence(
        @Body recurrence: Recurrence
    ): Deferred<Recurrence>

    @PUT("recurrences/{id}/")
    fun updateRecurrence(
        @Path("id") id: String,
        @Body recurrence: Recurrence
    ): Deferred<Recurrence>

    @DELETE("recurrences/{id}")
    fun cancelRecurrence(
        @Path("id") id: String
    ): Deferred<Response<Void>>
}