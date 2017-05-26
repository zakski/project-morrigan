package com.szadowsz.morrigan

import com.gargoylesoftware.htmlunit.BrowserVersion
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.MaeveDriver
import com.szadowsz.maeve.core.browser.MaeveConf
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.actions.{ActionExecutor, WaitExecutor}
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import com.szadowsz.maeve.core.instruction.target.multi.PathTarget
/**
  * Created on 21/06/2016.
  */
trait JsoupPathTargetting {

  val name : String

  val baseUrl : Uri

  val urlPaths : Seq[String]

  val dPath : String

  val filter : JsoupExtractor

  protected def createProfile() : PathTarget = PathTarget(baseUrl,urlPaths)

  protected def createActionExecutor() : ActionExecutor = new WaitExecutor(1000)

  def createInstruction() : MaeveInstruction[PathTarget] = {
    MaeveInstruction(
      name,
      createProfile(),
      createActionExecutor(),
      filter,
      dPath
    )
  }

  def buildDriver(ver: BrowserVersion, conf: MaeveConf):MaeveDriver = {
    val driver = new MaeveDriver(conf)
    driver.feedInstruction(createInstruction())
    driver
  }
}