package com.szadowsz.morrigan.ships.wiki.uk.scrape

import com.gargoylesoftware.htmlunit.BrowserVersion
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.MaeveDriver
import com.szadowsz.maeve.core.browser.MaeveConf
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.actions.{ActionExecutor, WaitExecutor}
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import com.szadowsz.maeve.core.instruction.target.multi.PathTarget
import com.szadowsz.morrigan.JsoupPathTargetting

/**
  * Created on 18/05/2016.
  */
object RNUrlTargetting extends JsoupPathTargetting{

  override val name: String = "rnUrls"

  override val baseUrl: Uri = Uri("http://en.wikipedia.org/")

  override val urlPaths: Seq[String] = List(
      "/wiki/List_of_ship_names_of_the_Royal_Navy_(A)",
      "/wiki/List_of_ship_names_of_the_Royal_Navy_(B)",
      "/wiki/List_of_ship_names_of_the_Royal_Navy_(C)",
      "/wiki/List_of_ship_names_of_the_Royal_Navy_(D-F)",
      "/wiki/List_of_ship_names_of_the_Royal_Navy_(G-H)",
      "/wiki/List_of_ship_names_of_the_Royal_Navy_(I-L)",
      "/wiki/List_of_ship_names_of_the_Royal_Navy_(M-N)",
      "/wiki/List_of_ship_names_of_the_Royal_Navy_(O-Q)",
      "/wiki/List_of_ship_names_of_the_Royal_Navy_(R-T)",
      "/wiki/List_of_ship_names_of_the_Royal_Navy_(U-Z)"
    )

  override val dPath: String = "./data/wiki/"

  override val filter: JsoupExtractor = new RoyalNavyUrlFilter

  override def createInstruction() : MaeveInstruction[PathTarget] = {
    MaeveInstruction(
      name,
      createProfile(),
      createActionExecutor(),
      filter,
      dPath,
      true,
      false
    )
  }

  def createInstruction(profile : PathTarget, jsfilter : JsoupExtractor) : MaeveInstruction[PathTarget] = {
    MaeveInstruction(
      name,
      profile,
      createActionExecutor(),
      jsfilter,
      dPath,
      true,
      false
    )
  }

  def createRelativeProfile(paths : List[String]) : PathTarget = PathTarget(baseUrl,paths)

  protected override def createActionExecutor() : ActionExecutor = new WaitExecutor(10)

  override def buildDriver(ver: BrowserVersion, conf: MaeveConf):MaeveDriver = {
    val driver = new MaeveDriver(conf)
    driver
  }
}
