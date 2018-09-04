package $package$

import cats.effect.IO
import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s.HttpService
import org.http4s.circe.CirceEntityCodec._
import org.http4s.dsl.Http4sDsl

object HelloService extends Http4sDsl[IO] {

  case class User(name: String)
  case class Greeting(greeting: String)

  val service: HttpService[IO] = {
    HttpService[IO] {
      case req @ POST -> Root =>
        for {
          user <- req.as[User]
          resp <- Ok(Greeting(s"Hello, \${user.name}!").asJson)
        } yield resp
    }
  }
}
