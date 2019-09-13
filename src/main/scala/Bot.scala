import com.bot4s.telegram.api.declarative.{Commands, Messages, Updates}
import com.bot4s.telegram.api.{Polling, TelegramBot}
import com.bot4s.telegram.clients.ScalajHttpClient
import com.github.nscala_time.time.Imports.{DateTime, _}

class Bot extends TelegramBot
  with Polling
  with Commands
  with Updates
  with Messages {

  def token: String = ""

  override val client = new ScalajHttpClient(token)

  onCommand("/test") { implicit msg =>
    val messageDate = new DateTime(msg.date.toLong * 1000L)
    val сurrentDate = new DateTime(System.currentTimeMillis)
    if ((Math.abs(messageDate.hour.get() - сurrentDate.hour.get()) < 1)
      && (Math.abs(messageDate.minute.get() - сurrentDate.minute.get()) < 1)
      && (Math.abs(messageDate.second.get() - сurrentDate.second.get()) < 10)) {
      reply("Гриша отъебись")
    }
  }

  onUpdate(handleUpdate)
}
