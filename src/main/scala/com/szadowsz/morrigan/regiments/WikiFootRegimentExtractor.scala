package com.szadowsz.morrigan.regiments

import com.szadowsz.common.io.write.CsvWriter
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import org.jsoup.nodes.{Document, Element}
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._
import scala.util.Try

/**
  * Created on 25/05/2017.
  */
class WikiFootRegimentExtractor extends JsoupExtractor {
  private val logger = LoggerFactory.getLogger(this.getClass)
  private val regPath: String = "div[id=mw-content-text] table[class=wikitable] > tbody > tr"

  protected def hasYearTab(e : Element): Boolean = {
    e.child(0).attr("align") != null &&
      e.child(0).attr("align").length > 0 &&
      e.child(0).attr("valign") != null &&
      e.child(0).attr("valign").length > 0
  }

  protected def getYear(e : Element): String = {
    if (hasYearTab(e)){
      e.child(0).text()
    } else {
      getYear(e.previousElementSibling())
    }
  }

  protected def getLink(e : Element): String = {
    if (hasYearTab(e)){
      e.child(1).select("a[href*=/wiki/]").asScala.headOption.map(link => link.attr("href")).getOrElse("")
    } else {
      e.child(0).select("a[href*=/wiki/]").asScala.headOption.map(link => link.attr("href")).getOrElse("")
    }
  }

  protected def getNames(e : Element): String = {
    if (hasYearTab(e)){
      e.child(1).text()
    } else {
      e.child(0).text()
    }
  }

  protected def getYearRaised(e : Element): String = {
    Try(if (hasYearTab(e)){
      e.child(2).select("b").asScala.headOption.map(year => year.text()).getOrElse("")
    } else {
      e.child(1).select("b").asScala.headOption.map(year => year.text()).getOrElse("")
    }).getOrElse("")
  }

  protected def getCircumstance(e : Element): String = {
    Try(if (hasYearTab(e)){
      e.child(2).text()
    } else {
      e.child(1).text()
    }).getOrElse("")
  }

  override def extract(queryUrl: Uri, returnedUrl: Uri, inst: MaeveInstruction[_], page: Document): Unit = {
    val regiments = page.select(regPath).asScala.toList.filter(tr => tr.child(0).tagName() != "th")
    val regInfo = regiments.map { e =>
      List(
        getYear(e), // number
        getLink(e), // link to own page
        getNames(e), // names
        getYearRaised(e), // year raised
        getCircumstance(e) // circumstances of the raising
      )
    }.toList

    val writer = new CsvWriter(inst.dPath + "regList.csv", "UTF-8", false)
    writer.writeAll(regInfo)
    writer.close()

  }

  override def shouldContinue(): Boolean = false
}
