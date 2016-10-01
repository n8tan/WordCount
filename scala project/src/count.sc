var output = scala.io.Source.fromFile("C:\\Users\\201403242\\Documents\\scalatest.txt")

  .getLines
  .flatMap(_.split("\\W+"))
  .filter(x => x.matches("[A-Za-z]+") && x.length>1)
  .foldLeft(Map.empty[String, Int]){

    (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))


  }





