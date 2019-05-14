import bot.domain.user.User
import com.bot4s.telegram.api.declarative.Action
import com.bot4s.telegram.models.{Message, Update}

object handleUpdate extends Action[Update] {

  var data = scala.collection.immutable.HashMap[Option[User], Option[Message]]()

    def getDataFromUpdate(implicit thatUpdate: Update): Unit = {
    }

  override def apply(thatUpdate: Update): Unit = {
    implicit val update: Update = thatUpdate
  }
}

case class UserData(id: Int, firstMessage: Boolean = true)