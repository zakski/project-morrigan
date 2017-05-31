package com.szadowsz.morrigan.ships.uboat

import com.szadowsz.common.io.read.CsvReader
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.actions.{ActionExecutor, WaitExecutor}
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import com.szadowsz.morrigan.JsoupPathTargetting
import com.szadowsz.morrigan.ships.uboat.filter.UboatNetShipFilter


/**
  * Created on 21/06/2016.
  */
object UboatNetShipTargetting extends JsoupPathTargetting {



  override val baseUrl = Uri("http://uboat.net/allies/warships")


  override val urlPaths: Seq[String] = buildShipList()

  val filter: JsoupExtractor = new UboatNetShipFilter

  override val name: String = "uboatShip"

  override val dPath: String = "./data/uboat/"

  protected override def createActionExecutor() : ActionExecutor = new WaitExecutor(100)


  def buildShipList(): Seq[String] = {
    val reader = new CsvReader("./data/uboat/uboatShipUrls.csv", "UTF-8")
    reader.readAll().map(r => r.head)
  }
}
