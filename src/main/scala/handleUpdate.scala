import com.bot4s.telegram.api.declarative.Action
import com.bot4s.telegram.models.{Message, Update, User}

import scala.concurrent.Future
import  scala.concurrent.ExecutionContext.Implicits.global

case class UserData(user: com.bot4s.telegram.models.User, textMessage: String)

object handleUpdate extends Action[Update] {
  override def apply(v1: Update): Unit = {
    val message: Option[Message] = v1.message
    val textMessage: Option[String] = message.flatMap(_.text)
    val user: Option[User] = message.flatMap(_.from)
    val userOF: Future[Option[UserDB]] = UserDao.findById(user.get.id)
    userOF.map(x => x.getOrElse(UserDao.create(UserDB(0, user.get.id, textMessage.get))))
  }
}