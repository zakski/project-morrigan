package com.szadowsz.morrigan.ships.wiki.uk

import com.gargoylesoftware.htmlunit.BrowserVersion
import com.szadowsz.common.io.write.CsvWriter
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.browser.MaeveConf
import com.szadowsz.morrigan.ships.wiki.uk.scrape.{RNUrlTargetting, RoyalNavyInfoBoxFilter, RoyalNavyMultiPageFilter, RoyalNavyUrlFilter}
import org.slf4j.LoggerFactory
import org.supercsv.prefs.CsvPreference

/**
  * Created on 10/05/2016.
  */
object RNScraper {
  private val logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    val conf = MaeveConf()
      .setJavaScriptEnabled(true)
      .setThrowExceptionOnScriptError(false)
      .setPrintContentOnFailingStatusCode(false)

    val driver = RNUrlTargetting.buildDriver(BrowserVersion.FIREFOX_38, conf)
    val urlInst = RNUrlTargetting.createInstruction()
    driver.scrapeUsingInstruction(urlInst)

    val links = urlInst.extractor.asInstanceOf[RoyalNavyUrlFilter].links
    val (shipsWithPages, unWrittenPages) = links.partition { case (name, link) => !Uri(link).containsQueryKey("redlink") }
    val unWrittenPagesMap = unWrittenPages.map(tuple => (tuple._1, Map[String, Any]()))

    val rnMultiTarg = RNUrlTargetting.createRelativeProfile(shipsWithPages.map(_._2))
    val multiInst = RNUrlTargetting.createInstruction(rnMultiTarg, new RoyalNavyMultiPageFilter)

    driver.scrapeUsingInstruction(multiInst)
    val pageInfo = multiInst.extractor.asInstanceOf[RoyalNavyMultiPageFilter].ships

    val multiPageList = shipsWithPages.zip(pageInfo)
    val pageList = multiPageList.flatMap{ case ((name, _), instances) =>
        instances.map{case (uri, redirect, info, exists, desc) => (name,uri,redirect,info,exists,desc) }
    }
    val (shipsWithSinglePages, unWrittenSinglePages) = pageList.partition { case (_, _, _, _, exists, _) => exists }
    val unWrittenPagesDescMap = unWrittenSinglePages.map(tuple => (tuple._1, Map[String, Any]("line_desc" -> tuple._6)))

    val rnSingTarg = RNUrlTargetting.createRelativeProfile(shipsWithSinglePages.map(_._2.get))
    val filter = new RoyalNavyInfoBoxFilter
    val singInst = RNUrlTargetting.createInstruction(rnSingTarg, filter)
    driver.scrapeUsingInstruction(singInst)

    val singlePageResults = shipsWithSinglePages.map(_._1).zip(filter.ships)


    val results = unWrittenPagesMap ++ unWrittenPagesDescMap ++ singlePageResults
    val rows = results.map(x => x._1 +: filter.headers.map(x._2.getOrElse(_, "").toString)).sortBy(_.head)
    val listWriter = new CsvWriter("./data/wiki/shipsRN.csv","UTF-8",false,CsvPreference.STANDARD_PREFERENCE)
    rows.foreach(r => listWriter.write(r:_*))
    listWriter.close()
  }
}

//CsvPreference.STANDARD_PREFERENCE
//
//def read(row: String): CensusDataBean = {
//val csvReader = new CsvBeanReader(new StringReader(row), CsvPreference.STANDARD_PREFERENCE)