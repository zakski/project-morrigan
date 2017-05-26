package com.szadowsz.morrigan.ships.uboat

import com.gargoylesoftware.htmlunit.BrowserVersion
import com.szadowsz.common.io.write.CsvWriter
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.browser.MaeveConf
import com.szadowsz.morrigan.ships.uboat.filter.UboatNetClassFilter
import org.slf4j.LoggerFactory
import org.supercsv.prefs.CsvPreference

/**
  * Created on 10/05/2016.
  */
object UboatNetClassScraper {
  private val _logger = LoggerFactory.getLogger(UboatNetClassScraper.getClass)

  def main(args: Array[String]): Unit = {
    val conf = MaeveConf()
      .setJavaScriptEnabled(false)
      .setHTTPProxy("proxy", 8080, Nil)
      .setThrowExceptionOnScriptError(false)
      .setPrintContentOnFailingStatusCode(false)

    val driver = UboatNetClassTargetting.buildDriver(BrowserVersion.FIREFOX_38, conf)
    driver.scrapeUsingCurrInstruction()
    val rows = UboatNetClassTargetting.filter.asInstanceOf[UboatNetClassFilter].rows

    val ships = rows.flatMap(r => r.head.asInstanceOf[List[(String, String)]])

    val classRows = rows.map(r => r.tail.map(_.toString))
    var listWriter = new CsvWriter("./data/uboat/uboatClass.csv", "UTF-8", false, CsvPreference.STANDARD_PREFERENCE)
    classRows.foreach(r => listWriter.write(r: _*))
    listWriter.close()

    listWriter = new CsvWriter("./data/uboat/uboatShipUrls.csv", "UTF-8", false, CsvPreference.STANDARD_PREFERENCE)
    ships.foreach(s => listWriter.write(List(s._1,s._2)))
    listWriter.close()
  }
}