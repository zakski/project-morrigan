package com.szadowsz.morrigan.regiments

import com.gargoylesoftware.htmlunit.BrowserVersion
import com.szadowsz.maeve.core.browser.MaeveConf
import org.slf4j.LoggerFactory

/**
  * Created on 10/05/2016.
  */
object WikiRegPageScraper {
  private val _logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    val conf = MaeveConf()
      .setJavaScriptEnabled(false)
      .setThrowExceptionOnScriptError(false)
      .setPrintContentOnFailingStatusCode(false)

    val driver = WikiFootRegimentPageTargetting.buildDriver(BrowserVersion.FIREFOX_38, conf)
    driver.scrapeUsingCurrInstruction()
  }
}