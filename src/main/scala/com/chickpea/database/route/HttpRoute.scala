package com.chickpea.route



import scala.concurrent.ExecutionContext

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._

import com.chickpea.user.{UserRoute, UserService}


class HttpRoute(userService: UserService, secretKey: String)(implicit executionContext: ExecutionContext) {

    private val userRouter = new UserRoute(secretKey, userService)

    val routes: Route = 
        cors() {
            pathPrefix("api") {
                userRouter.route ~(_)
                pathPrefix("healthcheck") {
                    get {
                        complete("OK")
                    }
                }
            }
        }
}