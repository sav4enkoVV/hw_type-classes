package messages.type_class

import org.scalatest.flatspec._
import org.scalatest.matchers._

class EnglishHelloMessageProviderSpec extends AnyFlatSpec with should.Matchers {

  private val englishHelloMessageProvider = new EnglishHelloMessageProvider
  private val englishGoodbyeMessageProvider = new EnglishGoodbyeMessageProvider

  "EnglishHelloMessageProvider" should "provide hello message" in {
    englishHelloMessageProvider.message should be ("Hello")
  }

  "EnglishGoodbyeMessageProvider" should "provide goodbye message" in {
    englishGoodbyeMessageProvider.message should be ("Goodbye")
  }
}
