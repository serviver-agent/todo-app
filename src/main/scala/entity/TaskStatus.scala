package entity

sealed trait TaskStatus

object TaskStatus {
  case object Undone extends TaskStatus
  case object Done   extends TaskStatus
}
