package com.rozky.common.web.extraction.jsoup

import org.jsoup.nodes.Element
import org.apache.commons.lang3.StringUtils
import org.jsoup.Jsoup
import java.lang

/**
 * Helpers method for JSOUP html parser
 */
object JsoupUtils {

    /**
     * Gets text of the first child matching supplied selector
     * @param parent the parent element
     * @param selector the children css selector
     * @return text of the 1st child element matching css selector
     */
    def firstChildText(parent: Element, selector: String): Option[String] = {
        val children = parent.select(selector)
        if (!children.isEmpty) {
            Some(children.first().text())
        } else {
            None
        }
    }

    def toInt(el: Element, default: Int = 0): Int = {
        val number = removeNonDigits(el.ownText())
        if (StringUtils.isNotBlank(number)) {
            Integer.valueOf(number)
        } else {
            default
        }
    }

    def toFloat(el: Element, default: Float = 0): Float = {
        val number = removeNonDigits(el.text())
        if (StringUtils.isNotBlank(number)) {
            lang.Float.valueOf(number)
        } else {
            default
        }
    }

    def parseElement(el: String): Element = {
        Jsoup.parse(el).body().child(0)
    }

    private def removeNonDigits(value: String): String = {
        if (value != null) {
            value.replaceAll("[^0-9.]", "")
        } else {
            ""
        }
    }
}
