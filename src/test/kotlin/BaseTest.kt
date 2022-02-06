import annotations.AllureConfigExtension
import annotations.WebDriverConfigExtension
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(
    WebDriverConfigExtension::class,
    AllureConfigExtension::class
)
abstract class BaseTest {

    @BeforeEach
    fun openPage() {
        Selenide.open(Configuration.baseUrl)
    }
}