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

final class RussianHelloMessageProvider extends HelloMessageProvider[RussianLanguage.type] {
  override def message: String = "Привет"
}

final class SpanishHelloMessageProvider extends HelloMessageProvider[SpanishLanguage.type] {
  override def message: String = "Hola"
}


trait GoodbyeMessageProvider[L <: Language] extends MessageProvider {
  override def message: String
}

final class EnglishGoodbyeMessageProvider extends GoodbyeMessageProvider[EnglishLanguage.type] {
  override def message: String = "Goodbye"
}

final class RussianGoodbyeMessageProvider extends GoodbyeMessageProvider[RussianLanguage.type] {
  override def message: String = "До свидания"
}

final class SpanishGoodbyeMessageProvider extends GoodbyeMessageProvider[SpanishLanguage.type] {
  override def message: String = "Adios"
}

object HelloMessageProvider {
  implicit val englishHelloMessageProvider: HelloMessageProvider[EnglishLanguage.type] =
    new EnglishHelloMessageProvider

  implicit val russianHelloMessageProvider: HelloMessageProvider[RussianLanguage.type] =
    new RussianHelloMessageProvider

  implicit val spanishHelloMessageProvider: HelloMessageProvider[SpanishLanguage.type] =
    new SpanishHelloMessageProvider
}

object GoodbyeMessageProvider {
  implicit val englishGoodbyeMessageProvider: GoodbyeMessageProvider[EnglishLanguage.type] =
    new EnglishGoodbyeMessageProvider

  implicit val russianGoodbyeMessageProvider: GoodbyeMessageProvider[RussianLanguage.type] =
    new RussianGoodbyeMessageProvider

  implicit val spanishGoodbyeMessageProvider: GoodbyeMessageProvider[SpanishLanguage.type] =
    new SpanishGoodbyeMessageProvider
}

object Messages {
  def hello[L <: Language](l: L)(implicit hmp: HelloMessageProvider[L]): String =
    hmp.message

  def goodbye[L <: Language](l: L)(implicit gmp: GoodbyeMessageProvider[L]): String =
    gmp.message
}

object TypeClassMessagesApp extends App {
  import Messages._

  println(hello(EnglishLanguage))
  println(hello(RussianLanguage))
  println(hello(SpanishLanguage))

  println(goodbye(EnglishLanguage))
  println(goodbye(RussianLanguage))
  println(goodbye(SpanishLanguage))
}
