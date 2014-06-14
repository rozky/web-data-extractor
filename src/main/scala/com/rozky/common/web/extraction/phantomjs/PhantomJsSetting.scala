package com.rozky.common.web.extraction.phantomjs

case class PhantomJsSetting(executable: String = "/usr/bin/phantomjs",
                            takeScreenShots: Boolean = false,
                            logLevel: String = "ERROR",
                            cliArguments: Array[String] = Array("--load-images=no", "--disk-cache=true", "--webdriver-loglevel=ERROR"),
                            pageSettings: Array[String] = Array("resourceTimeout=2000"))
