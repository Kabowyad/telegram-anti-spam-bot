import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Server {
  def main(args: Array[String]): Unit = {
    val bot = new Bot
    val eol = bot.run()
    scala.io.StdIn.readLine()
    bot.shutdown()
    Await.result(eol, Duration.Inf)
  }
}
