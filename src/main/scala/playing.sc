case class WordCounter(sourceText: String) {

  def countWords(): Option[List[(String, Int)]] = {
    None
  }

}

val file = scala.io.Source.fromFile("/tmp/writing.txt")
val counter = new WordCounter(scala.io.Source.fromFile("/tmp/moose12.txt").getLines.mkString)
val text = counter.sourceText
val mooseWords = counter.countWords()
val words = "The quick brown fox jumps over the lazy dog."
  .toLowerCase
  .split("\\W+")
  .groupBy((word: String) => word)
  .mapValues(_.length)
  .toList
  .sortBy(-_._2)
val count = words.foldLeft(0)(_ + _._2)
val topTen = words take(10)
//for((word, count) <- topTen) {
//  println(s"${word} appears ${count} time${if (count > 1) "s" else ""}.")
//}
def extractWords(source: String): List[(String, Int)] = {
  source.toLowerCase.
    split("\\W+").
    groupBy((word: String) => word).
    mapValues(_.size).
    toList.
    sortBy(-_._2)
}
extractWords("The quick brown fox jumps over the lazy dog")