package com.szadowsz.babby.target.census.usa

import java.io.File

import com.szadowsz.common.io.explore.{ExtensionFilter, FileFinder}
import com.szadowsz.common.io.read.CsvReader
import com.szadowsz.common.io.write.CsvWriter
import com.szadowsz.common.io.zip.ZipperUtil
import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.MaeveDriver
import com.szadowsz.maeve.core.browser.MaeveConf
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.target.single.SingleTarget
import org.slf4j.LoggerFactory

import scala.collection.mutable

/**
  * Created on 19/10/2016.
  */
object StatesCensusNamesStatsSplicer {
  private val logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    ZipperUtil.unzip("./archives/census/us/popular/names.zip", "./data/census/us/popular/names/")
    ZipperUtil.unzip("./archives/census/us/popular/namesbystate.zip", "./data/census/us/popular/namesbystate/")

    val stateFiles = FileFinder.search("./data/census/us/popular/namesbystate/", Some(new ExtensionFilter(".TXT", false)))
    stateFiles.sortBy(_.getName).foreach { f =>
      var n = f.getName
      n = n.substring(0, n.lastIndexOf("."))
      if (!new File(s"./data/census/us/popular/statesbyyear/1910/$n.csv").exists()) {
        val reader = new CsvReader(f.getAbsolutePath)
        logger.info(s"loading file: ${f.getName}")
        val yearMap = mutable.Map[String, Seq[Seq[String]]]()
        reader.readAll().foreach {
          line =>
            val org = yearMap.getOrElse(line(2), Nil)
            yearMap.put(line(2), org :+ line.tail)
        }
        yearMap.foreach { case (year, lines) =>
          val writer = new CsvWriter(s"./data/census/us/popular/statesbyyear/$year/$n.csv", "UTF-8", false)
          writer.write(List("gender", "year", "name", n))
          writer.writeAll(lines)
          writer.close()
        }
      } else {
        logger.info(s"already loaded file: ${f.getName}")

      }
    }

    FileFinder.search("./data/census/us/popular/names/", Some(new ExtensionFilter(".txt", false))).foreach { f =>
      val n = f.getName.replaceAll("\\D", "")
      if (!new File(s"./data/census/us/popular/namesByYear/$n.csv").exists()) {
        logger.info(s"loading file: ${f.getAbsolutePath}")
        val reader = new CsvReader(f.getAbsolutePath)
        val lines = reader.readAll().map(l => l :+ n)

        val linesWithStates = if (!new File(s"./data/census/us/popular/statesbyyear/$n").exists()) {
          val stateList = List.fill(stateFiles.length)("0")
          lines.map(l => l ++ stateList)
        } else {
          val yearFiles = FileFinder.search(s"./data/census/us/popular/statesbyyear/$n", Some(new ExtensionFilter(".csv", false)))
          var tmp = lines
          yearFiles.foreach { file =>
            logger.info(s"loading state file: ${file.getAbsolutePath}")

            var stateName = file.getName
            stateName = stateName.substring(0, stateName.lastIndexOf("."))

            val reader = new CsvReader(file.getAbsolutePath)
            val map: Map[(String, String), String] = reader.readAll().map(l => ((l(0), l(2)), l(3))).toMap

            tmp = tmp.map { l => l :+ map.getOrElse((l(1), l(0)), "0") }
            logger.info(s"joined state file: ${file.getAbsolutePath} with ${tmp.length} records")
          }
          tmp
        }
        val writer = new CsvWriter(s"./data/census/us/popular/namesByYear/$n.csv", "UTF-8", false)
        writer.write(List("name", "gender", "count", "year") ++ stateFiles.map {
          f =>
            val name = f.getName
            name.substring(0, name.lastIndexOf("."))
        })
        writer.writeAll(linesWithStates)
        writer.close()
      }
    }

    new File("./data/census/us/popular/names/").delete()
    new File("./data/census/us/popular/namesbystate/").delete()
    new File("./data/census/us/popular/statesbyyear/").delete()
  }
}

