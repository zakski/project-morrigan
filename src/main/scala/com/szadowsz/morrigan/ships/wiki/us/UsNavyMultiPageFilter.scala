package com.szadowsz.morrigan.ships.wiki.us

import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import org.jsoup.nodes.Document

import scala.collection.JavaConverters._

/**
  * Created on 24/05/2016.
  */
class UsNavyMultiPageFilter extends JsoupExtractor {
  private val REDIRECT_PATH: String = "body div#content div#contentSub span.mw-redirectedfrom"
  private val INFOBOX_PATH: String = "body div#content table.infobox"
  private val SHIP_INSTANCE_PATH: String = "body div.mw-content-ltr > ul > li , body div.mw-content-ltr > dl > dd"

  var ships : List[List[(Option[String], Boolean, Boolean, Boolean, String)]] = List()
  private val prefixes = List("USS","USNS")

  override def extract(queryUrl: Uri, returnedUrl: Uri, inst: MaeveInstruction[_], page: Document): Unit = {
    val isRedirected = page.select(REDIRECT_PATH).asScala.nonEmpty
    val hasInfo = page.select(INFOBOX_PATH).asScala.length == 1
    val instances = if (!hasInfo) page.select(SHIP_INSTANCE_PATH).asScala.toList else List()

    val curr = if (instances.isEmpty) {
      List((Some(queryUrl.path), isRedirected, hasInfo, true, ""))
    } else {
      instances.filter(ins => ins.select("a").asScala.exists(e => prefixes.exists(p => e.attr("Title").contains(p)))).map(ins => {
        // Exception in thread "main" java.net.URISyntaxException: Relative path in absolute URI: http://en.wikipedia.orghttps://donate.wikimedia.org/wiki/Special:FundraiserRedirector%3Futm_source=donate&utm_medium=sidebar&utm_campaign=C13_en.wikipedia.org&uselang=en
        val nurl = ins.select("a").asScala.find(e => prefixes.exists(p => e.attr("Title").contains(p))).map(l => l.attr("href"))
        val desc = ins.text()
        val exists = nurl.exists(!Uri(_).containsQueryKey("redlink"))
        (nurl, true, true, exists, desc)
      })
    }
    ships = ships :+ curr
  }

  override def shouldContinue(): Boolean = false
}