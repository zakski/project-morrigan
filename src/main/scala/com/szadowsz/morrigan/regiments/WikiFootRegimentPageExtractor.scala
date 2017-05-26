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
class WikiFootRegimentPageExtractor extends JsoupExtractor {
  private val logger = LoggerFactory.getLogger(this.getClass)
  private val regPath: String = "div[id=mw-content-text] table[class=infobox] > tbody > tr"

  private val headers: List[String] = List(
    "Active",
    "Country",
    "Branch",
    "Type",
    "Role",
    "Part of",
    "Garrison/HQ",
    "Nickname(s)",
    "Motto(s)",
    "March",
    "Engagements",
    "Tactical recognition flash",
    "Size",
    "Anniversaries",
    "Notable commanders",
    "Battle honours",
    "Disbanded"
  )

  override def extract(queryUrl: Uri, returnedUrl: Uri, inst: MaeveInstruction[_], page: Document): Unit = {
    val rawInfo = page.select(regPath).asScala.toList
    val info = rawInfo.filter(tr =>
      tr.children().size() == 2 && tr.children().asScala.exists(e => e.tagName() == "td") && tr.children().asScala.exists(e => e.tagName() == "th")
    )

    if (info.isEmpty) {
      logger.error(s"${queryUrl.toString()} seems to have no infobox")
    }

    val infoMap = info.map(tr =>
      (tr.children().asScala.find(e => e.tagName() == "th").map(_.text()).getOrElse(""),
        tr.children().asScala.find(e => e.tagName() == "td").map(_.text()).getOrElse("")
      )
    ).toMap

    val details = queryUrl.path +: headers.map(h => infoMap.getOrElse(h,""))

    val writer = new CsvWriter(inst.dPath + "regPage.csv", "UTF-8", true)
    writer.write(details)
    writer.close()

  }

  override def shouldContinue(): Boolean = false
}
