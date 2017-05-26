package com.szadowsz.morrigan.ships.uboat.filter

import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import org.jsoup.nodes.Document

import scala.collection.JavaConverters._

/**
  * Created on 23/05/2016.
  */
class UboatNetClassFilter extends JsoupExtractor {
  private val classPath: String = "body div[id=content] h1[class=warship_header]"
  private val shipPath: String = classPath + " + p"
  private val techPath : String = "body div[id=content] > div:contains(Technical information) > table[align=center][class=table_subtle] > tbody > tr"
  private val shipNamesPath: String = "body div[id=content] h3 + table"

  private val shipRegex = "[0-9]+".r

  var rows : List[List[Any]] = List()

  override def extract(queryUrl : Uri, returnedUrl : Uri, inst : MaeveInstruction[_], page: Document): Unit = {
    val classHeader = page.select(classPath).asScala.head.text()
    val shipCount =  shipRegex.findFirstIn(page.select(shipPath).asScala.head.text()).map(c => c.toInt).getOrElse(-1)

    val shipNames = page.select(shipNamesPath).get(1).select("td a[href*=/ship/]").asScala.map(e => (e.attr("href"),e.text()))

    if (shipCount > shipNames.length) throw new IllegalStateException()

    val techInfo = page.select(techPath).asScala.map(tr => (tr.child(0).text(), tr.child(1).text())).toMap
    val classInfo = List(
      shipNames.toList,
      classHeader,
      shipCount.toInt,
      shipNames.length,
      techInfo("Type"),
      techInfo("Displacement"),
      techInfo("Length"),
      techInfo("Complement"),
      techInfo("Armament"),
      techInfo.getOrElse("Max speed",""),
      techInfo.getOrElse("Engines",""),
      techInfo.getOrElse("Power",""),
      techInfo("Notes on class"),
      returnedUrl.toString
    )
    rows = rows :+ classInfo
  }

  override def shouldContinue(): Boolean = false
}