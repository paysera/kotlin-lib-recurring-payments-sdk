package com.paysera.lib.recurring_payments.retrofit

import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.recurring_payments.clients.RecurringPaymentsApiClient
import okhttp3.logging.HttpLoggingInterceptor

class NetworkApiFactory(
    userAgent: String?,
    credentials: ApiCredentials,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLoggerInterface: ErrorLoggerInterface
) : BaseApiFactory<RecurringPaymentsApiClient>(
    userAgent,
    credentials,
    timeout,
    httpLoggingInterceptorLevel,
    errorLoggerInterface
) {
    override val baseUrl = "https://recurring-payments.paysera.com/recurrence/rest/v1/"
    override val certifiedHosts = listOf("recurring-payments.paysera.com")

    override fun createClient(tokenRefresher: TokenRefresherInterface?): RecurringPaymentsApiClient {
        createRetrofit(tokenRefresher).apply {
            return RecurringPaymentsApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }
}