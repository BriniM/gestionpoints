package io.brinim.points

class Point(x: Int, y: Int) {
  def getX(): Int = x
  def getY(): Int = y

  private val tailleRepere = 25

  def distanceVers(p: Point): Double = Math.sqrt((x - p.getX())^2 + (y - p.getY())^2)
  def distanceAuCentre(): Double = Math.sqrt((x^2) + (y^2))

  override def toString: String = {
    var str = ""

    for (i <- 0 until tailleRepere; j <- 0 until tailleRepere) {
      var temp = ""
      if (i ==  (tailleRepere / 2) - y && j == x + tailleRepere / 2)
        temp = "•"
      else
        temp = " "
      if (i == tailleRepere / 2)
        temp = "-"
      if (j == tailleRepere - 1)
        temp = "\n"
      if (j == (tailleRepere - 1) / 2)
        temp = "|"
      str = str.concat(temp)
    }

    str
  }
}