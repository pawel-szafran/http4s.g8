package $package$

object ApiService extends Http4sDsl[IO] {

  val service: HttpService[IO] =
    Logger(logHeaders = false, logBody = true) {
      Router(
        "/hello" -> HelloService.service
      )
    }
}
