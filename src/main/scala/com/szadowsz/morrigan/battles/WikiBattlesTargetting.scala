package com.szadowsz.morrigan.battles

import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import com.szadowsz.morrigan.JsoupPathTargetting
import com.szadowsz.morrigan.ships.uboat.filter.UboatNetClassFilter


/**
  * Created on 21/06/2016.
  */
object WikiBattlesTargetting extends JsoupPathTargetting {


  override val baseUrl = Uri("https://en.wikipedia.org/wiki/")

  override val urlPaths: Seq[String] = List(
    "List_of_battles_before_301",
    "List_of_battles_301–1300",
    "List_of_battles_1301–1600",
    "List_of_battles_1601–1800",
    "List_of_battles_1801–1900",
    "List_of_battles_1901–2000" //,
    // "List_of_battles_since_2001"
  )

  val filter: JsoupExtractor = new UboatNetClassFilter
  override val name: String = "battleList"

  override val dPath: String = "./data/wiki/"
}
