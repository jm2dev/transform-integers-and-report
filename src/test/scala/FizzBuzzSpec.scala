package com.jm2dev.ee

import org.specs2.Specification

import scala.collection.immutable.Range.Inclusive

class FizzBuzzSpec extends Specification {
  def is =
    s2"""
        Given an integer number
          when is multiple of 3 then 'fizz' is returned                     $e1
          when is multiple of 5 then 'buzz' is returned                     $e2
          when is multiple of 15 then 'fizzbuzz' is returned                $e3
          when anything else then input number is returned                  $e4
          when it contains a 3 then 'lucky' is returned                     $e5
          when is 0 then 'fizzbuzz' is returned                             $e6

        Given a list of integer numbers as input
          when range 1 to 20 then expected output is returned               $e7
          when range has negative numbers then expected output is returned  $e8
      """

  def e1 = FizzBuzz.transform(6) must be equalTo "fizz"
  def e2 = FizzBuzz.transform(5) must be equalTo "buzz"
  def e3 = FizzBuzz.transform(15) must be equalTo "fizzbuzz"
  def e4 = FizzBuzz.transform(2) must be equalTo "2"
  def e5 = FizzBuzz.transform(3) must be equalTo "lucky"
  def e6 = FizzBuzz.transform(0) must be equalTo "fizzbuzz" //(all non-zero integers are divisors of 0)

  val input = 1 to 20
  val expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz"
  def e7 = FizzBuzz.transform(input) must be equalTo expected

  val inputWithNegativeIntegers = -5 to 5
  val expectedForNegativeIntegers = "buzz -4 lucky -2 -1 fizzbuzz 1 2 lucky 4 buzz"
  def e8 = FizzBuzz.transform(inputWithNegativeIntegers) must be equalTo expectedForNegativeIntegers
}
