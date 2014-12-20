package $package$

import org.specs2.mutable._

class MainTest extends Specification{

  "Hello world" should {
    "be equal to 'hello world' in lowercase" in {
      "Hello World".toLowerCase must beEqualTo("hello world")
    }
  }

}
