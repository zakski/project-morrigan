package com.szadowsz.morrigan.ships.wiki.us

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
object USNUrlTargetting extends JsoupPathTargetting {

  override val name: String = "rnUrls"

  override val baseUrl: Uri = Uri("http://en.wikipedia.org/")

  override val urlPaths: Seq[String] = List(
    "/wiki/List_of_United_States_Navy_ships:_A–B",
    "/wiki/List_of_United_States_Navy_ships:_C",
    "/wiki/List_of_United_States_Navy_ships:_D–F",
    "/wiki/List_of_United_States_Navy_ships:_G–H",
    "/wiki/List_of_United_States_Navy_ships:_I–K",
    "/wiki/List_of_United_States_Navy_ships:_L",
    "/wiki/List_of_United_States_Navy_ships:_M",
    "/wiki/List_of_United_States_Navy_ships:_N–O",
    "/wiki/List_of_United_States_Navy_ships:_P",
    "/wiki/List_of_United_States_Navy_ships:_Q–R",
    "/wiki/List_of_United_States_Navy_ships:_S",
    "/wiki/List_of_United_States_Navy_ships:_T–V",
    "/wiki/List_of_United_States_Navy_ships:_W–Z"
  )

  override val dPath: String = "./data/wiki/usn"

  override val filter: JsoupExtractor = new UsNavyUrlFilter

  override def createInstruction(): MaeveInstruction[PathTarget] = {
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

  def createInstruction(profile: PathTarget, jsfilter: JsoupExtractor): MaeveInstruction[PathTarget] = {
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

  def createRelativeProfile(paths: List[String]): PathTarget = PathTarget(baseUrl, paths)

  protected override def createActionExecutor(): ActionExecutor = new WaitExecutor(10)

  override def buildDriver(ver: BrowserVersion, conf: MaeveConf): MaeveDriver = {
    val driver = new MaeveDriver(conf)
    driver
  }
}
