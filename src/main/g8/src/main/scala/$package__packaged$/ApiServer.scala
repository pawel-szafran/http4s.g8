package $package$

import cats.effect.IO
import fs2.StreamApp
import org.http4s.server.blaze.BlazeBuilder

import scala.concurrent.ExecutionContext

object ApiServer extends StreamApp[IO] {

  import ExecutionContext.Implicits.global

  def stream(args: List[String], requestShutdown: IO[Unit]) =
    BlazeBuilder[IO]
      .bindHttp(8080, "0.0.0.0")
      .mountService(ApiService.service, "/")
      .serve
}
