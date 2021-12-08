package messages.type_class

import language._

trait MessageProvider {
  def message: String
}
trait HelloMessageProvider[L <: Language] extends MessageProvider {
  override def message: String
}
final class EnglishHelloMessageProvider extends HelloMessageProvider[EnglishLanguage.type] {
  override def message: String = "Hello"
}
object HelloMessageProvider {
  implicit val englishHelloMessageProvider: HelloMessageProvider[EnglishLanguage.type] =
    new EnglishHelloMessageProvider
}

trait GoodbyeMessageProvider[L <: Language] extends MessageProvider {
  override def message: String
}

final class EnglishGoodbyeMessageProvider extends GoodbyeMessageProvider[EnglishLanguage.type] {
  override def message: String = "Goodbye"
}
object GoodbyeMessageProvider {
  implicit val englishGoodbyeMessageProvider: GoodbyeMessageProvider[EnglishLanguage.type] =
    new EnglishGoodbyeMessageProvider
}

object Messages {
  def hello[L <: Language](l: Language)(implicit hmp: HelloMessageProvider[L]): String =
    hmp.message

  def goodbye[L <: Language](l: Language)(implicit gmp: GoodbyeMessageProvider[L]): String =
    gmp.message
}

object TypeClassMessagesApp extends App {
  import Messages._

  println(hello(EnglishLanguage))
  println(goodbye(EnglishLanguage))
}
