import slick.jdbc.MySQLProfile.api._

class UserDBTable(tag: Tag) extends Table[UserDB](tag, "usersT") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def userId = column[Int]("userId")
  def textMessage = column[String]("textMessage")

  override def * = (userId, textMessage, id) <> ((UserDB.apply _).tupled, UserDB.unapply)
}