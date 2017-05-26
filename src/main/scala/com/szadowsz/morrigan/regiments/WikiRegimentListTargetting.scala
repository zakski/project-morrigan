package com.szadowsz.morrigan.regiments

import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import com.szadowsz.morrigan.JsoupSingleTargetting
import com.szadowsz.morrigan.ships.uboat.filter.UboatNetClassFilter


/**
  * Created on 21/06/2016.
  */
object WikiRegimentListTargetting extends JsoupSingleTargetting {

  override val name: String = "regList"

  override val baseUrl = Uri("https://en.wikipedia.org/wiki/List_of_Regiments_of_Foot")

  val filter: JsoupExtractor = new WikiFootRegimentExtractor

  override val dPath: String = "./data/wiki/"
}
