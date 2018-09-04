package $package$

object ApiServer extends StreamApp[IO] {

  def stream(args: List[String], requestShutdown: IO[Unit]) =
    BlazeBuilder[IO]
      .bindHttp(8080, "0.0.0.0")
      .mountService(ApiService.service, "/")
      .serve
}
