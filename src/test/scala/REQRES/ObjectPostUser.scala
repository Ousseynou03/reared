package REQRES
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps


object ObjectPostUser {

  val scenarioPostUser = scenario("POST USER")
    .exec(http("POST USER")
    .post("/api/users")
      .body(StringBody(
        """
          |{
          |    "name": "morpheus",
          |    "job": "leader"
          |}
          """.stripMargin))
    .check(status is 201))
    .pause(2 seconds)


}
