package bot.domain.user

class UserValidationInterpreter[F[_]: Monad](userRepository: UserRepository[F]) extends UserValidation[F] {
  override def doesNotExist(user: User) = EitherT {
    userRepository.get(user.telegramId).map {
      case None => Right(())
      case Some(_) => Left(UserAlreadyExistsError(user))
    }
  }
}

object UserValidationInterpreter {
  def apply[F[_]: Monad](userRepository: UserRepository[F]): UserValidation[F] =
    new UserValidationInterpreter[F](userRepository)
}