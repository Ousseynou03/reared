package REQRES


import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.recorder.internal.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.{minutes, seconds}

import scala.language.postfixOps

class Test  extends  Simulation{

  private val host: String = System.getProperty("urlCible", "https://reqres.in")

  private val  TpsMonteEnCharge: Int = System.getProperty("tpsMonte", "10").toInt

  private val  TpsPalier: Int = System.getProperty("tpsPalier", (2).toString ).toInt
  private val  nbrUser: Int = System.getProperty("nbUser", (30).toString ).toInt


  val httpProtocol =   http
    .baseUrl(host)
    .acceptHeader("application/json")

  val scenarioGetPage2 = scenario("GET PAGE 2").exec(ObjectGetPage2.scenarioGetPage2)
  val scenarioGetUser2 = scenario("GET USER").exec(ObjectGetUser2.scenarioGetUser2)
  val scenarioPostUser = scenario("POST USER").exec(ObjectPostUser.scenarioPostUser)


  setUp(
    scenarioGetPage2.inject(rampUsers( nbrUser) during ( TpsMonteEnCharge  minutes) , nothingFor(  TpsPalier  minutes), constantUsersPerSec(20).during(20 minutes)),

    scenarioGetUser2.inject(rampUsers( nbrUser) during ( TpsMonteEnCharge  minutes) , nothingFor(  TpsPalier  minutes), constantUsersPerSec(20).during(20 minutes)),

    scenarioPostUser.inject(rampUsers( nbrUser) during ( TpsMonteEnCharge  minutes) , nothingFor(  TpsPalier  minutes), constantUsersPerSec(20).during(20 minutes))
    ,
  ).protocols(httpProtocol)
    //.maxDuration(3 minutes)




}
