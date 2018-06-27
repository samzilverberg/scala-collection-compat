


package fix

import scala.language.higherKinds


class CanBuildFromSrc() {

  def f[C0, A, C1[_]](c0: C0)(implicit
      cbf: collection.Factory[Int, C1[Int]],
      cbf2: collection.Factory[String, C1[String]],
      cbf3: collection.BuildFrom[C0, A, C1[A]]): C1[Int] = {

    val b = cbf.newBuilder
    val b2 = cbf.newBuilder
    val b3 = cbf.newBuilder
    val b4 = cbf2.newBuilder
    val b5 = cbf3.newBuilder(c0)
    val b6 = cbf3.newBuilder(c0)

    List.empty[Int].to(cbf)
    List.empty[String].to(cbf2)
    b.result()
  }

  def kind(implicit cbf: collection.BuildFrom[String, Char, String],
                    cbf2: collection.BuildFrom[String, (Int, Boolean), Map[Int, Boolean]]): Unit = {

    cbf.newBuilder("")
    cbf2.newBuilder("")
    ()
  }
}