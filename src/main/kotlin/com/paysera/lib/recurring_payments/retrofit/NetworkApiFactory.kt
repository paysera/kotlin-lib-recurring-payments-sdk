package com.paysera.lib.recurring_payments.retrofit

import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.recurring_payments.clients.RecurringPaymentsApiClient

class NetworkApiFactory(credentials: ApiCredentials) : BaseApiFactory<RecurringPaymentsApiClient>(credentials) {

    override fun createClient(baseUrl: String, tokenRefresher: TokenRefresherInterface?): RecurringPaymentsApiClient {
        return RecurringPaymentsApiClient(
            createRetrofit(baseUrl, tokenRefresher).create(NetworkApiClient::class.java)
        )
    }
}