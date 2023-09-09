package REQRES
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps


object ObjectGetPage2 {

  val scenarioGetPage2 = scenario("GET USER PAGE 2")
    .exec(http("GET")
    .get("/api/users?page=2")
    .check(status is 200))
    .pause(2 seconds)


}
