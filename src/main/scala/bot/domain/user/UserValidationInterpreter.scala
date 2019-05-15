package bot.domain.user

import bot.domain.UserAlreadyExistsError
import cats.Monad
import cats.data.EitherT
import cats.implicits._

class UserValidationInterpreter[F[_]: Monad](userRepository: UserRepository[F]) extends UserValidation[F] {
   def doesNotExist(user: User) = EitherT {
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