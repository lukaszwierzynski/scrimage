package com.sksamuel.scrimage

import org.scalatest.{OneInstancePerTest, BeforeAndAfter, FunSuite}
import java.awt.image.BufferedImage
import sun.awt.resources.awt

/** @author Stephen Samuel */
class ImageTest extends FunSuite with BeforeAndAfter with OneInstancePerTest {

    test("ratio happy path") {
        val awt1 = new BufferedImage(200, 400, BufferedImage.TYPE_INT_ARGB)
        assert(0.5 === Image(awt1).ratio)

        val awt2 = new BufferedImage(400, 200, BufferedImage.TYPE_INT_ARGB)
        assert(2 === Image(awt2).ratio)

        val awt3 = new BufferedImage(333, 333, BufferedImage.TYPE_INT_ARGB)
        assert(1 === Image(awt3).ratio)

        val awt4 = new BufferedImage(333, 111, BufferedImage.TYPE_INT_ARGB)
        assert(3.0 === Image(awt4).ratio)

        val awt5 = new BufferedImage(111, 333, BufferedImage.TYPE_INT_ARGB)
        assert(1 / 3d === Image(awt5).ratio)
    }
}