import com.bot4s.telegram.api.declarative.{Commands, Updates}
import com.bot4s.telegram.api.{Polling, TelegramBot}
import com.bot4s.telegram.clients.ScalajHttpClient

class Bot extends TelegramBot
  with Polling
  with Commands
  with Updates {

  def token: String = ""
  override val client = new ScalajHttpClient(token)

  onCommand("/hello") { implicit msg =>
    reply("My token is safe")
  }

  onUpdate(handleUpdate)
}
