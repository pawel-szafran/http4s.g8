package $package$

import cats.effect.IO
import org.http4s.HttpService
import org.http4s.dsl.Http4sDsl
import org.http4s.server.Router
import org.http4s.server.middleware.Logger

object ApiService extends Http4sDsl[IO] {

  val service: HttpService[IO] =
    Logger(logHeaders = false, logBody = true) {
      Router(
        "/hello" -> HelloService.service
      )
    }
}
