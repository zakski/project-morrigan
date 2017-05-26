package com.szadowsz.morrigan.ships.uboat

import com.gargoylesoftware.htmlunit.BrowserVersion
import com.szadowsz.common.io.read.CsvReader
import com.szadowsz.common.io.write.CsvWriter
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.browser.MaeveConf
import com.szadowsz.maeve.core.instruction.target.multi.PathTarget
import com.szadowsz.morrigan.ships.uboat.filter.{UboatNetClassFilter, UboatNetShipFilter}
import org.slf4j.LoggerFactory
import org.supercsv.prefs.CsvPreference

/**
  * Created on 10/05/2016.
  */
object UboatNetShipScraper {
  private val _logger = LoggerFactory.getLogger(UboatNetClassScraper.getClass)

  def main(args: Array[String]): Unit = {
    val conf = MaeveConf()
      .setJavaScriptEnabled(false)
      .setHTTPProxy("proxy", 8080, Nil)
      .setThrowExceptionOnScriptError(false)
      .setPrintContentOnFailingStatusCode(false)

    val driver = UboatNetShipTargetting.buildDriver(BrowserVersion.FIREFOX_38, conf)
    driver.scrapeUsingCurrInstruction()
  }
}