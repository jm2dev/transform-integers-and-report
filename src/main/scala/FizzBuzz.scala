package com.jm2dev.ee

import scala.collection.immutable.Range.Inclusive

object FizzBuzz {
  private val divisors = List(
    (3, "fizz"),
    (5, "buzz"))

  def transform(input: Inclusive): String = input.map(transform(_)).mkString(" ")

  def transform(number: Int): String = {
    s"$number" contains ('3') match {
      case true => "lucky"
      case false => divisibles(number)
    }
  }

  private def divisibles(number: Int): String = {
    val results = divisors.map((divisor) => divisibleBy(number, divisor._1, divisor._2))
      .filter(_.nonEmpty)

    results.length match {
      case 0 => s"$number"
      case _ => results.map(_.getOrElse("")).mkString("")
    }
  }

  private def divisibleBy(number: Int, divisor: Int, result: String): Option[String] = {
    number % divisor match {
      case 0 => Some(result)
      case _ => None
    }
  }
}
