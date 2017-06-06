package com.szadowsz.morrigan.ships.wiki.us

import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.MaeveInstruction
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import org.jsoup.nodes.Document

import scala.collection.JavaConverters._

/**
  * Created on 23/05/2016.
  */
class UsNavyUrlFilter extends JsoupExtractor {
  private val SHIP_INSTANCE_PATH: String = "body h2 + div > ul > li > a[href] , body h3 + div > ul > li > a[href]"

  var links : List[(String,String)] = List()
//  private val prefixes = List("USS","SS-","SP-","SF-","186","191","185","MV","T-A","DD-","DM-","AC-","AG-","IX-","AO-","AW-","YN-","AN-","183","DE-","PF-",
//    "PYc","MSO","AFD","YTB","YTM", "PC-","USN","AT-","ATF","SSB","CVN","AVP","WAV","WHE","AD-","ARS","AMc","AMC","ATA","YT-","YTL","APB","ARL","AKA","AM-","AGP",
//    "PG-","177","188","AKS",190,"ATO","WAT","WAG",WME,"APA",YFB,"179",187,"MMD",YNT,"ID-",LST,"USR",AK-,"AGC",MSF,"AP-",GTS,"CVE",184,"AF-",ATR,"SS ",AS-,
//    "ARC",YTT,"AOG",189,
//    "BAT",FF-,"AR-",ZRS,"AE-",181,"BB-",AVB,"LSD",ARD,"CB-",ACV,"AGS",CL-,"CA-",CG-,"SSN",AMS,"EAM",EMS,"MSC",AV-,"AKL",180,"APD",USC,"WPG",DER,"LKA",182,
//    "AVS",PY-,"AVG",CVH,"DSV",178,"CVA",CV-,"LHA",PCE,"ADG",BM-,"LPD",YAG,"SSK",IXS,"AGM",C-9,"PGM",YO-,"CVS",FFG,"PHM",BAV,"AOE",MCM,"SM-",APS,"ARB",CGN,
//    "DDG",CM-,"APM",YF-,"BAR",WAK,"AGB",AGO,"PCS",DSR,"ARV",MHC,"DDE",AKV,"TB-",DLG,"LPR",AVD,"C-3",T-L,"AGE",SSA,"SSG",ACM,"LPA",SST,"ARG",CVL,"AVT",LHD,
//    "YNG",ATS,"XTR",AGT,"AH-",DDR,"BDE",YP-,"LSM",LFR,"WAO",YHB,"LCS",T-J,"T-E",LPH,"LCC",ASR,"DMS",176,"CAG",CVU,"FFT",E-P,"T-C",DEG,"ACR",WAL,"SSR",BYT,ANL
//  )
  private val prefixes = List("USS","USNS")

  override def extract(queryUrl: Uri, returnedUrl: Uri, inst: MaeveInstruction[_], page: Document): Unit = {
    val rawUrls = page.select(SHIP_INSTANCE_PATH).asScala
    val urls = rawUrls.map(url => (url.attr("title"), url.attr("href"))).toList
      .filter{case(t,s) => prefixes.exists(p => t.startsWith(p))&& s.startsWith("/wiki/")
    }
    links = links ++ urls.map(ship => (ship._1, ship._2))
  }

  override def shouldContinue(): Boolean = false
}
