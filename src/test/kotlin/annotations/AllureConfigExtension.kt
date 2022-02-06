package annotations

import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import io.qameta.allure.selenide.LogType
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import java.util.logging.Level

class AllureConfigExtension : BeforeEachCallback {

    override fun beforeEach(context: ExtensionContext) {
        if (!SelenideLogger.hasListener("AllureSelenide")) {
            SelenideLogger.addListener(
                "AllureSelenide", AllureSelenide()
                    .screenshots(true)
                    .includeSelenideSteps(false)
                    .savePageSource(false)
                    .enableLogs(LogType.BROWSER, Level.ALL)
            )
        }
    }
}