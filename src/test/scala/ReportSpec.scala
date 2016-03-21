package com.jm2dev.ee

import org.specs2.Specification

class ReportSpec extends Specification {
  def is =
    s2"""
        Given an input string of space separated words
          group different words $e1

        Given a report result
          pretty print it as 'key: value'      $e2

        Given negative integers in input string
          then they are grouped as 'integer'  $e3
      """

  val input = "1 2 lucky 4 buzz"
  val expected = Map("integer" -> 3, "lucky" -> 1, "buzz" -> 1)
  def e1 = Report.generate(input) must be equalTo expected

  val report = Map("c" -> 3)
  val expectedReport = "c: 3"
  def e2 = Report.prettyPrint(report) must be equalTo expectedReport

  val inputWithNegativeIntegers = "buzz -4 lucky"
  val expectedForInputWithNegativeIntegers = Map("integer" -> 1, "buzz" -> 1, "lucky" -> 1)
  def e3 = Report.generate(inputWithNegativeIntegers) must be equalTo expectedForInputWithNegativeIntegers
}
