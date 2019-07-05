package bot.domain.user

import slick.jdbc.PostgresProfile.api._
import slick.lifted.ProvenShape

class UserScheme(tag: Tag) extends Table[User](tag, "USERS"){
  override def * : ProvenShape[User] = (id , botStatus, telegramId) <> ((User.apply _).tupled, User.unapply)

  def id: Rep[Int] = column[Int]("id", O.PrimaryKey)
  def botStatus: Rep[Boolean] = column[Boolean]("botStatus")
  def telegramId: Rep[Int] = column[Int]("telegramId")
}
