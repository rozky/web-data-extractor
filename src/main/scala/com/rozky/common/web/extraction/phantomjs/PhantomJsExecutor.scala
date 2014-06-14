package com.rozky.common.web.extraction.phantomjs

import org.openqa.selenium.phantomjs.{PhantomJSDriverService, PhantomJSDriver}
import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities}
import org.openqa.selenium.WebDriver

object PhantomJsExecutor {
    val PHANTOM_JS_PATH = "/etc/rozky/phantomjs"

    def execute[T](block: WebDriver => T)(implicit setting: PhantomJsSetting = PhantomJsSetting()): T = {
        var driver: PhantomJSDriver = null
        try {
            driver = createDriver
            block(driver)
        } finally {
            if (driver != null) {
                driver.quit()
            }
        }
    }

    private def createDriver(implicit setting: PhantomJsSetting): PhantomJSDriver = {
        //        val loggingPreferences = new LoggingPreferences()
        //        loggingPreferences.enable("har", Level.ALL)

        val capabilities: DesiredCapabilities = DesiredCapabilities.phantomjs()
        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, setting.takeScreenShots)
        //        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences)
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, setting.cliArguments)
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX, setting.pageSettings)
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, setting.executable)
        new PhantomJSDriver(capabilities)
    }
}
