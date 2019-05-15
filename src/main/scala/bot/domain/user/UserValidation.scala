package bot.domain.user

import bot.domain.UserAlreadyExistsError
import scala.language.higherKinds
import cats.data.EitherT

trait UserValidation[F[_]] {
  def doesNotExist(user: User): EitherT[F, UserAlreadyExistsError, Unit]
}
