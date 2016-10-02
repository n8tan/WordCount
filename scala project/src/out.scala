import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import  java.io._;

/**
  * Created by 201403242 on 10/1/2016.
  */
object out {
  def main(args: Array[String]) {
    var output = scala.io.Source.fromFile("D:\\Github Repositories\\WordCount\\Sample Text.txt")

      .getLines
      .flatMap(_.split("\\W+"))
      .filter(x => x.matches("[A-Za-z]+") && x.length>1)
      .foldLeft(Map.empty[String, Int]){

        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))


      }

    val writer = new PrintWriter(new File("test2.txt" ))


    for(a <- output) {
      writer.write(a.toString() + "\n")
    }
    writer.close()

  }


}
