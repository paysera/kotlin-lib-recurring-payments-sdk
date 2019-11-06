package com.paysera.lib.recurring_payments.retrofit

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.recurring_payments.clients.RecurringPaymentsApiClient
import retrofit2.converter.gson.GsonConverterFactory

class NetworkApiFactory(credentials: ApiCredentials) : BaseApiFactory<RecurringPaymentsApiClient>(credentials) {

    override fun createClient(baseUrl: String, tokenRefresher: TokenRefresherInterface?): RecurringPaymentsApiClient {
        return RecurringPaymentsApiClient(
            createRetrofit(baseUrl, tokenRefresher).also {
                val exclusionStrategy = object : ExclusionStrategy {
                    val fieldsToExclude = listOf("isPayzaAccount", "isBankAccount", "isWebmoneyAccount", "isTaxAccount", "isPayseraAccount")
                    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
                        return false
                    }

                    override fun shouldSkipField(f: FieldAttributes?): Boolean {
                        fieldsToExclude.firstOrNull {
                            it.equals(f?.name, true)
                        }?.let {
                            println("gibbs not skipped: $it")
                            return true
                        }

                        println("gibbs not skipped: ${f?.name}")
                        return false
                    }
                }
                it.newBuilder().addConverterFactory(GsonConverterFactory.create(GsonBuilder().setExclusionStrategies(exclusionStrategy).create())).build()
            }.create(NetworkApiClient::class.java)
        )
    }
}