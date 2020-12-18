package KeplerDataReader

import scala.io.BufferedSource
import scala.collection.mutable.{ArrayBuffer, Set, StringBuilder}

case class DataProcessor() {

  def getAllPlanets(data: BufferedSource): Set[String] = {
    val planets = Set[String]()

    //drop header, add rows
    for (line <- data.getLines.drop(47)) {
        planets.add(line)
    }
    planets
  }

  def buildNewCSVTable(rows: Set[String], columnNums: ArrayBuffer[Int]): Set[String] = {
    val table = Set[String]()
    val it = Iterator(columnNums)
    for (row <- rows) {
      val cols = row.split(",").map(_.trim())
      val sb = new StringBuilder()

      sb.addAll(cols(0))
      sb.addOne(',')
      sb.addAll(cols(1))
      sb.addOne(',')

      columnNums.foreach(num =>{
        sb.addAll(cols(num))
        while(it.hasNext) {
          sb.addOne(',')
          it.next()
        }
      })
      table.add(sb.toString())
    }
    table
  }
}