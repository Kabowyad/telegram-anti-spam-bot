package bot.domain.user

trait UserRepository[F[_]] {
  def create(user: User): F[User]

  def get(telegramId: Long): F[Option[User]]
}

