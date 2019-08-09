import slick.dbio.NoStream
import slick.lifted.TableQuery
import slick.sql.SqlAction

import scala.concurrent.Future

trait BaseDao extends DatabaseConfig{
  val usersTable = TableQuery[UserDBTable]

  protected implicit def executeFromDb[A](action: SqlAction[A, NoStream, _ <: slick.dbio.Effect]): Future[A] = {
    db.run(action)
  }
}
