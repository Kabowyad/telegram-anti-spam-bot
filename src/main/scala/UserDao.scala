import scala.concurrent.Future
import slick.driver.MySQLDriver.api._

object UserDao extends BaseDao {
  def findById(userIdFromTg: Int): Future[Option[UserDB]] = usersTable.filter(_.userId === userIdFromTg).result.headOption
  def create(userDB: UserDB): Future[Int] = usersTable returning usersTable.map(_.id) += userDB
}
