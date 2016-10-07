/**
  * Created by 201401145 on 10/7/2016.
  */


import java.io.File
import java.io._

import scala.collection.immutable.ListMap;

object WordCountTesting {
  def main(args: Array[String]) {
    val output = scala.io.Source.fromFile("C:\\Users\\201401145\\Downloads\\sample.txt")

      .getLines
      .flatMap(_.toLowerCase.split("\\W+"))
      .filter(x => x.matches("[A-Za-z]+") && x.length>1)
      .foldLeft(Map.empty[String, Int]){

        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))


      }

    val sortedOutput = ListMap(output.toSeq.sortWith(_._1.toLowerCase < _._1.toLowerCase):_*)

    val writer = new PrintWriter(new File("test8.txt" ))

    for(a <- sortedOutput) {
      writer.write(a.toString() + "\n")
    }
    writer.close()

  }
}

