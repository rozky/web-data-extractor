package com.rozky.common.web.extraction.html

object HtmlUtils {
    def removeNoBreakingSpaces(value: String): String = {
        // \xA0 is non-breaking space character or &nbsp in HTML
        value.replaceAll("[\\xA0]", "").trim
    }
}
