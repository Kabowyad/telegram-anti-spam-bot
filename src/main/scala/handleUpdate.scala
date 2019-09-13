import com.bot4s.telegram.api.declarative.Action
import com.bot4s.telegram.models.{Message, Update, User}
import com.github.nscala_time.time.Imports._
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


case class UserData(user: com.bot4s.telegram.models.User, textMessage: String)

object handleUpdate extends Action[Update] with LazyLogging {
  override def apply(v1: Update): Unit = {
    val message: Option[Message] = v1.message
    val messageDate = new DateTime(message.get.date.toLong * 1000L)
    val сurrentDate = new DateTime(System.currentTimeMillis)
//    logger.info(s"messageDate - $messageDate")
//    logger.info(s"сurrentDate - $сurrentDate")
    if ((Math.abs(messageDate.hour.get() - сurrentDate.hour.get()) < 1)
      && (Math.abs(messageDate.minute.get() - сurrentDate.minute.get()) < 1)
      && (Math.abs(messageDate.second.get() - сurrentDate.second.get()) < 10)) {
//      logger.info(s"Message, ${message.get.text}")
            valueLogic(message)
    }
  }

  def valueLogic(message: Option[Message]) = {
    val textMessage: Option[String] = message.flatMap(_.text)
    val user: Option[User] = message.flatMap(_.from)
    val userOF: Future[Option[UserDB]] = UserDao.findById(user.get.id)
    logger.info(s"User, ${user.get.firstName}")
    userOF.map(x => x.getOrElse(UserDao.create(UserDB(user.get.id, textMessage.get))))
  }
}