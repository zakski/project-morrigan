package com.szadowsz.morrigan.ships.uboat.filter

import com.szadowsz.common.io.write.CsvWriter
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import org.jsoup.nodes.Document

import scala.collection.JavaConverters._

/**
  * Created on 23/05/2016.
  */
class UboatNetShipFilter extends JsoupExtractor {
  private val shipPath: String = "body div[id=content] h1[class=warship_header]"
  private val techPath: String = "body div[id=content] table:contains(Navy) > tbody > tr"
  private val classUrlPath: String = "body div[id=content] table:contains(Navy) > tbody > tr:contains(Class) a[href*=/class/]"

   override def extract(queryUrl : Uri, returnedUrl : Uri, inst : MaeveInstruction[_], page: Document): Unit = {
    val shipHeader = page.select(shipPath).asScala.head.text()
    val info = page.select(techPath).asScala.filter(r => r.children().size() == 2).map(r => (r.child(0).text(),r.child(1).text())).toMap
    val classID = page.select(classUrlPath).attr("href")

    val ship = List(
      shipHeader,
      queryUrl.toString,
      info("Type"),
      info("Navy"),
      info("Class"),
      classID,
      info("Pennant"),
      info("Built by"),
      info("Laid down"),
      info("Launched"),
      info("Commissioned"),
      info.getOrElse("End service",null),
      info("History"),
      info.getOrElse("Former name",null),
      info.getOrElse("Lost",null),
      info.getOrElse("Career notes",null)
    )
    val writer = new CsvWriter(inst.dPath + "uboatShip.csv", "UTF-8", true)
    writer.write(ship)
    writer.close()
}

  override def shouldContinue(): Boolean = false
}

// Navy
// Type
// Class
// Pennant
// Built by
// Ordered
// Laid down
// Launched
// Commissioned
// End service
// History
// Former name
// Lost
// Loss position
//
// U-boat Attack
// Corvettes of the Royal Canadian Navy, 1939-1945 MacPherson, Ken and Milner, Marc
// Career notes
// Frigates of the Royal Canadian Navy 1943-1974 MacPherson, Ken
// U-Boat Attack Logs Daniel Morgan and Bruce Taylor
// In Peril on the Sea Graves, Donald E.
// British Battleships, 1919-1945, Revised Edition R. A. Burt