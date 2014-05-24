package com.rozky.common.web.extraction.jsoup

import org.scalatest.{WordSpec, Matchers}
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

class JsoupUtilsSpec extends WordSpec with Matchers {

    "toInt" should {
        "convert element text with whitespaces to int " in {
            val document: Element = Jsoup.parse("<span id='1'> 12 </span>").getElementById("1")

            JsoupUtils.toInt(document) should be(12)
        }

        "use default value if element text is blank" in {
            val document: Element = Jsoup.parse("<span id='1'>  </span>").getElementById("1")

            JsoupUtils.toInt(document, 10) should be(10)
        }

        "convert only element own text to int" in {
            val document: Element = Jsoup.parse("<span id='1'> 12 <sup>2</sup></span>").getElementById("1")

            JsoupUtils.toInt(document) should be(12)
        }
    }
}
