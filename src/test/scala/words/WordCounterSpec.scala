package words

import org.scalatest._

/**
 * Created by don on 15-05-26.
 */
class WordCounterSpec extends FlatSpec with Matchers {

  "A Word Counter" should "return None from an empty string" in {
    val counter = new WordCounter("")
    counter countWords() should have size 0
  }

  it should "return one word from a one word string" in {
    val counter = new WordCounter("the")
    val the = counter countWords()
    the should have size 1
    the should contain (("the",1))
  }

  it should "read words from a file" in {
    val counter = new WordCounter(scala.io.Source.fromFile("src/test/resources/writing.txt").getLines.mkString)
    val text = counter.sourceText
    val tarzanWords = counter countWords()
    tarzanWords should contain (("the",23))
    tarzanWords should contain (("narrative",2))
    tarzanWords should contain (("convivial",2))
  }

}
