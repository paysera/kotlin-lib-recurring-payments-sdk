package com.paysera.lib.recurring_payments.retrofit

import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.recurring_payments.clients.RecurringPaymentsApiClient

class NetworkApiFactory(credentials: ApiCredentials, timeout: Long? = null) : BaseApiFactory<RecurringPaymentsApiClient>(credentials, timeout) {

    override fun createClient(baseUrl: String, tokenRefresher: TokenRefresherInterface?): RecurringPaymentsApiClient {
        createRetrofit(baseUrl, tokenRefresher).apply {
            return RecurringPaymentsApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }
}