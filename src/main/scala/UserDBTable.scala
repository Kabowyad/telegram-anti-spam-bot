import slick.jdbc.MySQLProfile.api._

class UserDBTable(tag: Tag) extends Table[UserDB](tag, "users") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def userId = column[Int]("userId")
  def textMessage = column[String]("textMessage")

  override def * = (id, userId, textMessage) <> ((UserDB.apply _).tupled, UserDB.unapply)
}