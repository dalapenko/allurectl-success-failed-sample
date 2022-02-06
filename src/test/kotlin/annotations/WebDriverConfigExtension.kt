package annotations

import com.browserup.bup.client.ClientUtil
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class WebDriverConfigExtension : BeforeAllCallback, AfterEachCallback {

    override fun beforeAll(context: ExtensionContext) {
        Configuration.baseUrl = "https://security.stackexchange.com"
        Configuration.headless = true
        Configuration.browser = "chrome"
        Configuration.proxyEnabled = true
        Configuration.proxyHost = ClientUtil.getConnectableAddress().hostAddress
        Configuration.fastSetValue = true
        Configuration.timeout = 30000L
    }

    override fun afterEach(context: ExtensionContext) {
        Selenide.closeWebDriver()
    }
}