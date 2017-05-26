package com.szadowsz.morrigan.regiments

import com.gargoylesoftware.htmlunit.BrowserVersion
import com.szadowsz.maeve.core.browser.MaeveConf
import org.slf4j.LoggerFactory

/**
  * Created on 10/05/2016.
  */
object WikiRegListScraper {
  private val _logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    val conf = MaeveConf()
      .setJavaScriptEnabled(false)
      .setHTTPProxy("proxy", 8080, Nil)
      .setThrowExceptionOnScriptError(false)
      .setPrintContentOnFailingStatusCode(false)

    val driver = WikiRegimentListTargetting.buildDriver(BrowserVersion.FIREFOX_38, conf)
    driver.scrapeUsingCurrInstruction()
  }
}