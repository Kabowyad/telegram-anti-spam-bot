import scala.concurrent.Future
//import slick.driver.MySQLDriver.api._
import slick.jdbc.MySQLProfile.api._

object UserDao extends BaseDao {
  def findById(userIdFromTg: Int): Future[Option[UserDB]] = usersTable.filter(_.userId === userIdFromTg).result.headOption
  def create(userDB: UserDB): Future[Int] = (usersTable returning usersTable.map(x => x.id)) += UserDB(userDB.userId, userDB.textMessage)
}
