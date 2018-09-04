package $package$

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
