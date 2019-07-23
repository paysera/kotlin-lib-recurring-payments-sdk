package com.paysera.lib.recurring_payments.retrofit

import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.TokenRefresher
import com.paysera.lib.common.retrofit.BaseRefreshingApiFactory
import com.paysera.lib.recurring_payments.clients.RecurringPaymentsApiClient

class NetworkApiFactory(credentials: ApiCredentials) : BaseRefreshingApiFactory<RecurringPaymentsApiClient>(credentials) {

    override fun createClient(tokenRefresherInterface: TokenRefresher, baseUrl: String): RecurringPaymentsApiClient {
        return RecurringPaymentsApiClient(
            createRetrofit(baseUrl).create(NetworkApiClient::class.java),
            tokenRefresherInterface
        )
    }
}