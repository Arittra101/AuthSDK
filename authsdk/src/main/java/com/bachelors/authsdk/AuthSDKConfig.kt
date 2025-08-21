package com.bachelors.authsdk


data class AuthSDKConfig(
    val baseUrl: String,
    val enableLogging: Boolean = false,
    val timeout: Long = 30000L
) {
    class Builder {
        private var baseUrl = ""
        private var enableLogging: Boolean = false
        private var timeout: Long = 30000L

        fun setBaseUrl(baseUrl: String) = apply { this.baseUrl = baseUrl }
        fun enableLogging(enableLogging: Boolean) = apply { this.enableLogging = enableLogging }
        fun setTimeout(timeout: Long) = apply { this.timeout = timeout }

        fun build(): AuthSDKConfig {
            return AuthSDKConfig(baseUrl, enableLogging, timeout)
        }
    }
}
