import com.bot4s.telegram.api.declarative.Action
import com.bot4s.telegram.models.Update

object handleUpdate extends Action[Update] {
  override def apply(v1: Update): Unit = {
    // TODO: do shitty logic here
  }
}

case class UserData(id: Int, firstMessage: Boolean = true)