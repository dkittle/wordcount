package words

import org.scalatest._

/**
 * Created by don on 15-05-26.
 */
class WordCounterSpec extends FlatSpec with Matchers {

  "A Word Counter" should "return an empty list from an empty string" in {
    new WordCounter("") wordsAndCounts() should have size 0
  }

  it should "return an empty list from a string with punctuation" in {
    new WordCounter(".") wordsAndCounts() should have size 0
    new WordCounter("!") wordsAndCounts() should have size 0
    new WordCounter("* %") wordsAndCounts() should have size 0
  }

  it should "return one word from a one word string" in {
    val counter = new WordCounter("the")
    counter wordsAndCounts() should have size 1
    counter wordsAndCounts() should contain (("the",1))
  }

  it should "return one word from a one number string" in {
    val counter = new WordCounter("5")
    counter wordsAndCounts() should have size 1
    counter wordsAndCounts() should contain (("5",1))
  }

  it should "return two words from a one word, one number string" in {
    val counter = new WordCounter("The 1.")
    counter wordsAndCounts() should have size 2
    counter wordsAndCounts() should contain (("the",1))
    counter wordsAndCounts() should contain (("1",1))
  }

  it should "read words from a file" in {
    val counter = new WordCounter(scala.io.Source.fromFile("src/test/resources/writing.txt").getLines.mkString)
    val text = counter.sourceText
    counter wordsAndCounts() should contain (("the",23))
    counter wordsAndCounts() should contain (("narrative",2))
    counter wordsAndCounts() should contain (("convivial",2))
  }

}
