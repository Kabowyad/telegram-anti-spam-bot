import com.bot4s.telegram.api.declarative.Action
import com.bot4s.telegram.models.{Message, Update, User}
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

case class UserData(user: com.bot4s.telegram.models.User, textMessage: String)

object handleUpdate extends Action[Update] with LazyLogging{
  override def apply(v1: Update): Unit = {
    val message: Option[Message] = v1.message
    val textMessage: Option[String] = message.flatMap(_.text)
    val user: Option[User] = message.flatMap(_.from)
//    val userOF: Future[Option[UserDB]] = UserDao.findById(user.get.id)
    logger.info(s"User, ${user.get.firstName}")
//    userOF.map(x => x.getOrElse(UserDao.create(UserDB(user.get.id, textMessage.get))))
  }
}