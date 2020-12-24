package io.brinim.points

object App {
  var points: List[Point] = List()
  def main(args: Array[String]): Unit = {
    Menu.ajouterCommande("ajouter", () => {
      points = inputPoint() :: points
    })

    Menu.ajouterCommande("representer", () => {
      println("Representation graphique: ")
      println(inputChoixPoint())
    })

    Menu.ajouterCommande("deplacer", () => {
      val ancienPoint = inputChoixPoint()
      val nouveauPoint = inputPoint()

      points = points.updated(points.indexOf(ancienPoint), nouveauPoint)
    })

    Menu.ajouterCommande("distance au centre", () => {
      val p1 = inputChoixPoint()
      println(f"La distance est: ${p1.distanceAuCentre()}")
    })

    Menu.ajouterCommande("distance", () => {
      val p1 = inputChoixPoint()
      val p2 = inputChoixPoint()
      println(f"La distance est: ${p1.distanceVers(p2)}")
    })

    Menu.ajouterCommande("exit", () => System.exit(0))

    Menu.loopAsync()
  }

  def inputPoint(): Point = {
    val x = Menu.question("Donner x: ", "^-*[0-9]+$")
    val y = Menu.question("Donner y: ", "^-*[0-9]+$")

    new Point(x.toInt, y.toInt)
  }

  def inputChoixPoint(): Point = {
    for (i <- points.indices)
      println(f"[${i}] - (${points(i).getX()}, ${points(i).getY()})")
    val index = Menu.question("Donner indice: ", "^[0-9]+$")

    points(index.toInt)
  }
}
