package com.paysera.lib.recurring_payments.retrofit

import com.paysera.lib.common.entities.PayseraApiCredentials
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.recurring_payments.clients.RecurringPaymentsApiClient
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class NetworkApiFactory(
    baseUrl: String,
    userAgent: String?,
    credentials: PayseraApiCredentials,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLogger: ErrorLoggerInterface,
    certificateInterceptor: Interceptor?
) : BaseApiFactory<RecurringPaymentsApiClient>(
    baseUrl,
    userAgent,
    credentials,
    timeout,
    httpLoggingInterceptorLevel,
    errorLogger,
    certificateInterceptor
) {
    override fun createClient(tokenRefresher: TokenRefresherInterface?): RecurringPaymentsApiClient {
        createRetrofit(tokenRefresher).apply {
            return RecurringPaymentsApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }
}