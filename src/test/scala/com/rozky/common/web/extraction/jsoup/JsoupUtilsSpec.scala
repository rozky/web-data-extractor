package com.rozky.common.web.extraction.jsoup

import org.scalatest.{WordSpec, Matchers}
import org.jsoup.nodes.Element

class JsoupUtilsSpec extends WordSpec with Matchers {

    "toInt" should {
        "convert element text with whitespaces to int " in {
            val document: Element = JsoupUtils.parseElement("<span> 12 </span>")

            // when + then
            JsoupUtils.toInt(document) should be(12)
        }

        "use default value if element text is blank" in {
            val document: Element = JsoupUtils.parseElement("<span>  </span>")

            // when + then
            JsoupUtils.toInt(document, 10) should be(10)
        }

        "convert only element own text to int" in {
            // given
            val document: Element = JsoupUtils.parseElement("<span> 12 </span>")

            // when + then
            JsoupUtils.toInt(document) should be(12)
        }

        "use default value if element text is only non-breaking space" in {
            val document: Element = JsoupUtils.parseElement("<span>&nbsp;</span>")

            // when + then
            JsoupUtils.toInt(document, 10) should be(10)
        }
    }

    "toFloat" should {
        "convert element content to float" in {
            val document: Element = JsoupUtils.parseElement("<span> 1.07 </span>")

            // when + then
            JsoupUtils.toFloat(document) should be(1.07f)
        }

        "use default value if element content is not valid number" in {
            val document: Element = JsoupUtils.parseElement("<span> - </span>")

            // when + then
            JsoupUtils.toFloat(document) should be(0)
        }
    }
}
