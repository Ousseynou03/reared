package REQRES
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps

object ObjectGetUser2 {

  val scenarioGetUser2 = scenario("GET USER 2")
    .exec(http("GET USER")
    .get("/api/users/2")
    .check(status is 200))
    .pause(2 seconds)
}
