package words

import java.io.FileNotFoundException
import java.nio.charset.CodingErrorAction

import scala.io.Codec

/**
 * Created by don on 15-05-26.
 */
case class WordCounter(sourceText: String) {

  val listOfCountedWords = parseWords()

  def wordsAndCounts() = {
    listOfCountedWords
  }

  def countOfAllWords() = {
    listOfCountedWords.foldLeft(0)(_ + _._2)
  }

  /**
   * Arguably not very efficient if countWords is called more than once
   * @return List of tuples with word and # times it appears in string
   */
  private def parseWords(): List[(String, Int)] = {
    if (sourceText.isEmpty)
      return List[(String,Int)]()

    // Convert text to lower case, split on non-letters, group by to count words, flatten to word/count pairs and
    // sort from the highest word count to the lowest
    sourceText.toLowerCase
      .split("\\W+")
      .groupBy((word: String) => word)
      .mapValues(_.length)
      .toList
      .sortBy(-_._2)
  }

}

object WordCounter extends App {

  if (args.length == 0) {
    println("You must give me a filename to read and parse.")
    println("e.g. sbt \"run [filename]\"")
    System.exit(0)
  }

  try {
    val counter = new WordCounter(scala.io.Source.fromFile(args(0)).getLines.mkString)
    outputFileStats(counter)
  } catch {
    case e: FileNotFoundException => println(s"The file named ${args(0)} was not found.")
  }
  
  def outputFileStats(counter: WordCounter) = {
    println(s"The file contains ${counter.countOfAllWords()} words")
    println("The top 10 words by the number of times they occurr are:")
    val topTen = counter wordsAndCounts() take 10
    for((word, count) <- topTen) {
      println(s" '${word}' appears ${count} time${if (count > 1) "s" else ""}")
    }
  }
}
