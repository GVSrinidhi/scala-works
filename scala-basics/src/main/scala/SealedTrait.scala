sealed trait lang {
  val lang = "Language"
}

class Telugu extends lang {
  override val lang: String = "Language:Telugu"
}

class Hindi extends lang {
  override val lang: String = "Language:Hindi"
}

class English extends lang {
  override val lang: String = "Language:English"
}

object SealedTrait extends App{

  val tel = new Telugu
  val hin = new Hindi
  val eng = new English

  def picklang(language:lang) : String = language match {
    case tel  => tel.lang
    case eng  => eng.lang
    case hin  => hin.lang
  }

  println(picklang(tel))
  println(picklang(hin))
  println(picklang(eng))

}
