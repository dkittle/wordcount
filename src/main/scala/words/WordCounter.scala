package words

import java.nio.charset.CodingErrorAction

import scala.io.Codec

/**
 * Created by don on 15-05-26.
 */
case class WordCounter(sourceText: String) {

  implicit val codec = Codec("UTF-8")
  codec.onMalformedInput(CodingErrorAction.REPLACE)
  codec.onUnmappableCharacter(CodingErrorAction.REPLACE)

  def countWords(): List[(String, Int)] = {
    if (sourceText.isEmpty)
      return List[(String,Int)]()
    sourceText.toLowerCase
      .split("\\W+")
      .groupBy((word: String) => word)
      .mapValues(_.length)
      .toList
      .sortBy(-_._2)
  }

}
