package com.szadowsz.morrigan.ships.wiki.uk.scrape

import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import org.jsoup.nodes.Document

import scala.collection.JavaConverters._

/**
  * Created on 24/05/2016.
  */
class RoyalNavyInfoBoxFilter extends JsoupExtractor {
  private val REDIRECT_PATH: String = "body div#content div#contentSub span.mw-redirectedfrom"
  private val INFOBOX_PATH: String = "body div#content table.infobox > tbody > tr"

  val headers: List[String] = List(
    "Name:",
    "Motto:",
    "Identification:",
    "Yard number:",
    "Way number:",
    "Class and type:",
    "Type:",
    "Crew:",
    "Namesake:",
    "Nickname(s):",
    "Renamed:",
    "Homeport:",
    "Builder:",
    "Ordered:",
    "Laid down:",
    "Launched:",
    "Commissioned:",
    "Decommissioned:",
    "Fate:",
    "Armament:",
    "Aircraft carried:",
    "Electronic warfare & decoys:",
    "Boats & landing craft carried:",
    "Aviation facilities:",
    "url_redirected",
    "url_fragment",
    "line_desc",
    "Sunk:",
    "Planned:",
    "Scrapped:",
    "Speed:",
    "Propulsion:",
    "Armour:",
    "Relaunched:",
    "Deck clearance:",
    "Awarded:",
    "Reclassified:",
    "Length:",
    "Succeeded by:",
    "Displacement:",
    "Honours and awards:",
    "Sail plan:",
    "Notes:",
    "Completed:",
    "Out of service:",
    "Lost:",
    "Building:",
    "Route:",
    "Sponsored by:",
    "Maiden voyage:",
    "Part of:",
    "Cost:",
    "In commission:",
    "Draught:",
    "Preceded by:",
    "Commanders:",
    "Owner:",
    "Built:",
    "Depth:",
    "Troops:",
    "Armor:",
    "Depth of hold:",
    "Awards:",
    "Operator:",
    "Acquired:",
    "Test depth:",
    "Port of registry:",
    "Christened:",
    "Retired:",
    "Draft:",
    "Height:",
    "Operations:",
    "Converted",
    "Struck:",
    "Preserved:",
    "Ice class:",
    "Complement:",
    "Sensors and processing systems:",
    "Honors and awards:",
    "Captured:",
    "Cancelled:",
    "Active:",
    "Endurance:",
    "Victories:",
    "Tonnage:",
    "Reinstated:",
    "Tons burthen:",
    "Subclasses:",
    "Capacity:",
    "Decks:",
    "Operators:",
    "Range:",
    "Status:",
    "Badge:",
    "Refit:",
    "In service:",
    "Beam:",
    "Builders:",
    "Installed power:",
    "Recommissioned:",
    "Ramps:"
  )

  var ships : List[Map[String,Any]] = List()
  //  override def filter(queryUrl: URI, returnedUrl: URI, page: Document): List[Map[String, Any]] = {
  //    val isRedirected = page.select(REDIRECT_PATH).asScala.nonEmpty || queryUrl != returnedUrl
  //    val fragment = returnedUrl.fragment
  //
  //    val infobox = page.select(INFOBOX_PATH).asScala.headOption
  //
  //    val infoMap = infobox.map { case box =>
  //      val elements = box.select(INFO_ELEMENT_PATH).asScala.map(e => (e.previousElementSibling().text(), e.text()))
  //      elements.toMap.filterKeys(RNSchema.allowedList.contains)
  //    }.getOrElse(Map())
  //
  //    List(infoMap + ("url_redirected" -> isRedirected) + ("url_fragment" -> fragment.getOrElse("")))
  //  }
  override def extract(queryUrl: Uri, returnedUrl: Uri, inst: MaeveInstruction[_], page: Document): Unit = {
        val isRedirected = page.select(REDIRECT_PATH).asScala.nonEmpty || queryUrl != returnedUrl
        val fragment = returnedUrl.fragmentOpt

        val infoMap = page.select(INFOBOX_PATH).asScala.filter(r => r.children().size() == 2).map(r => (r.child(0).text(),r.child(1).text())).toMap.filterKeys(headers.contains)

//    val infoMap = infobox.map { case box =>
//          val elements = box.select(INFO_ELEMENT_PATH).asScala.map(e => (e.previousElementSibling().text(), e.text()))
//          elements.toMap.filterKeys(headers.contains)
//        }.getOrElse(Map())

        ships = ships :+ (infoMap + ("url_redirected" -> isRedirected) + ("url_fragment" -> fragment.getOrElse("")))
  }

  override def shouldContinue(): Boolean = false
}
