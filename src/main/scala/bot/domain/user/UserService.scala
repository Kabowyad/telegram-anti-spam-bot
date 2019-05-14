package bot.domain.user

import bot.domain.UserAlreadyExistsError
import cats.Monad
import cats.data.EitherT

class UserService[F[_]: Monad](userRepository: UserRepository[F], userValidation: UserValidation[F]) {

  def createUser(user: User): EitherT[F, UserAlreadyExistsError, User] =
    for {
      _ <- userValidation.doesNotExist(user)
      saved <- EitherT.liftF(userRepository.create(user))
    } yield saved
}

object UserService {
  def apply[F[_]: Monad](repository: UserRepository[F], validation: UserValidation[F]): UserService[F] =
    new UserService[F](repository, validation)
}
