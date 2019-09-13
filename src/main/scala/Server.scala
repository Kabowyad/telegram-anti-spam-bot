import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Server extends App with LazyLogging {

  override def main(args: Array[String]): Unit = {
    logger.info("Im alive!")
    val bot = new Bot
    val eol = bot.run()
    scala.io.StdIn.readLine()
    bot.shutdown()
    Await.result(eol, Duration.Inf)
  }

}
