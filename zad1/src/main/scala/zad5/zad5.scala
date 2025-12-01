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
  @cask.postJson("/students")
  def studentHours(data: List[ujson.Value]): ujson.Value = {
    val grouped = data.groupBy(item => item("student").str)
    val result = grouped.map { case (studentName, entries) =>
      val totalHours = entries.map(entry => entry("hours").num).sum
      (studentName, ujson.Num(totalHours))
    }
    result
  }

  initialize()
}
