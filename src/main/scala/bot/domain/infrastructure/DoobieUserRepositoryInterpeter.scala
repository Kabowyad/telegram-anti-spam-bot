package bot.domain.infrastructure

import bot.domain.user.{User, UserRepository}

private object UserSQL {

}

class DoobieUserRepositoryInterpeter[F[_]] extends UserRepository[F]{
  override def create(user: User): F[User] = ???

  override def get(userId: Long): F[Option[User]] = ???
}
