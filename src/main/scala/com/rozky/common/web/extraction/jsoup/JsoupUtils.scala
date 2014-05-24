package com.rozky.common.web.extraction.jsoup

import org.jsoup.nodes.Element
import org.apache.commons.lang3.StringUtils

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
        if (StringUtils.isNotBlank(el.ownText())) {
            Integer.valueOf(el.ownText())
        } else {
            default
        }

    }
}
