package com.paysera.lib.recurring_payments.retrofit

import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.recurring_payments.clients.RecurringPaymentsApiClient
import okhttp3.logging.HttpLoggingInterceptor

class NetworkApiFactory(
    userAgent: String?,
    credentials: ApiCredentials,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC
) : BaseApiFactory<RecurringPaymentsApiClient>(
    userAgent,
    credentials,
    timeout,
    httpLoggingInterceptorLevel
) {

    override fun createClient(
        baseUrl: String,
        tokenRefresher:
        TokenRefresherInterface?
    ): RecurringPaymentsApiClient {
        createRetrofit(baseUrl, tokenRefresher).apply {
            return RecurringPaymentsApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }
}