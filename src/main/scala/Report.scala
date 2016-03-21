package com.jm2dev.ee

object Report {
  def generate(input: String): Map[String, Int] = {
    val tokens = input.split(" ")
      .map(_.replaceAll("-?[0-9]+", "integer"))
    tokens.groupBy(identity).mapValues(_.size)
  }

  def prettyPrint(report: Map[String, Int]): String =
    report.transform((k, v) => s"$k: $v")
      .values
      .mkString("\n")
}
