package app.zad5

import java.util.Dictionary

object Zadanie5Controller extends cask.Routes {
  @cask.postJson("/mapReduce")
  def mapReduce(listNumbers: List[Int]): ujson.Value = {
    val wynik = listNumbers.groupBy(identity).map { case (number, occurance) =>
      (number.toString, ujson.Num(occurance.size))
    }
    ujson.Obj.from(wynik)
  }
  @cask.postJson("/cubeMapReduce")
  def cubeMapReduce(list: List[Int]): ujson.Value = {
    val wynik = list.map((x: Int) => (x.toString, ujson.Num(x * x * x))).toMap

    ujson.Obj.from(wynik)
  }

  initialize()
}
