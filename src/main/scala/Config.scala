import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.Logger

trait Config {
  val logger = Logger("name")

  private val config = ConfigFactory.load()
  private val databaseConfig = config.getConfig("database")
  val databaseUrl = databaseConfig.getString("url")
  val databaseUser = databaseConfig.getString("user")
  val databasePassword = databaseConfig.getString("password")
  logger.error(s"url - $databaseUrl user - $databaseUser!")
}
