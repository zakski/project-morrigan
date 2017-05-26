package com.szadowsz.morrigan.ships.wiki.uk.scrape

import com.szadowsz.common.io.write.CsvWriter
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import org.jsoup.nodes.Document

import scala.collection.JavaConverters._

/**
  * Created on 23/05/2016.
  */
class RoyalNavyUrlFilter extends JsoupExtractor {
  private val SHIP_INSTANCE_PATH: String = "body div[class=mw-content-ltr] ul > li > a[href]"

  var links : List[(String,String)] = List()

  override def extract(queryUrl: Uri, returnedUrl: Uri, inst: MaeveInstruction[_], page: Document): Unit = {
    val urls = page.select(SHIP_INSTANCE_PATH).asScala.map(url => (url.text(), url.attr("href"))).toList
    val ships = urls.filter(_._2.contains("HMS"))

    links = links ++ ships.map(ship => (ship._1, ship._2))
  }

  override def shouldContinue(): Boolean = false
}
