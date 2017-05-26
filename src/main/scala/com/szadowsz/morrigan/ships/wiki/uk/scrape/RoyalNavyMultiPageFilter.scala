package com.szadowsz.morrigan.ships.wiki.uk.scrape

import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import org.jsoup.nodes.Document

import scala.collection.JavaConverters._

/**
  * Created on 24/05/2016.
  */
class RoyalNavyMultiPageFilter extends JsoupExtractor {
  private val REDIRECT_PATH: String = "body div#content div#contentSub span.mw-redirectedfrom"
  private val INFOBOX_PATH: String = "body div#content table.infobox"
  private val SHIP_INSTANCE_PATH: String = "body div.mw-content-ltr > ul > li , body div.mw-content-ltr > dl > dd"

  var ships : List[List[(Option[Uri], Boolean, Boolean, Boolean, String)]] = List()

  override def extract(queryUrl: Uri, returnedUrl: Uri, inst: MaeveInstruction[_], page: Document): Unit = {
    val isRedirected = page.select(REDIRECT_PATH).asScala.nonEmpty
    val hasInfo = page.select(INFOBOX_PATH).asScala.length == 1
    val instances = if (!hasInfo) page.select(SHIP_INSTANCE_PATH).asScala.toList else List()

    val curr = if (instances.isEmpty) {
      List((Some(queryUrl), isRedirected, hasInfo, true, ""))
    } else {
      instances.map(ins => {
        val nurl = ins.select("a").asScala.find(e => e.attr("Title").contains("HMS")).map(l => Uri(l.attr("href")))
        val desc = ins.text()
        val exists = nurl.exists(!_.containsQueryKey("redlink"))
        (nurl, true, true, exists, desc)
      })
    }
    ships = ships :+ curr
  }

  override def shouldContinue(): Boolean = false
}
