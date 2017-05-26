package com.szadowsz.morrigan.regiments

import com.szadowsz.common.io.read.CsvReader
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.actions.{ActionExecutor, WaitExecutor}
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import com.szadowsz.morrigan.JsoupPathTargetting
import com.szadowsz.morrigan.ships.uboat.filter.UboatNetShipFilter


/**
  * Created on 21/06/2016.
  */
object WikiFootRegimentPageTargetting extends JsoupPathTargetting {



  override val baseUrl = Uri("https://en.wikipedia.org/")


  override val urlPaths: Seq[String] = buildRegList()

  val filter: JsoupExtractor = new WikiFootRegimentPageExtractor

  override val name: String = "regPages"

  override val dPath: String = "./data/wiki/"

  protected override def createActionExecutor() : ActionExecutor = new WaitExecutor(100)


  def buildRegList(): Seq[String] = {
    val reader = new CsvReader("./data/wiki/regList.csv", "UTF-8")
    val x =reader.readAll().map(r => r(1)).filter(s => s != null && s.nonEmpty)
    x
  }
}
