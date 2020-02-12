package models.todo

import scala.collection.mutable.ArrayBuffer

import play.api.libs.json.Json

/**
  * an object with View postfix to wrap the view object
  * and the imiplicit JSON format
  */
object TodoView {

  /**
    * Presentation object returned in Json format.
    * Note that it's a good practice to keep the presentation DTO,
    * which are used for reads, distinct from the form processing DTO,
    * which are used for writes.
    *
    * Optionally, you may want to name it with a `Vo` postfix
    * to show that it is an view object.
    */
  case class Todo(id: Long, name: String, isComplete: Boolean)
  implicit val todoFormat = Json.format[Todo]

  // For simplicity, all data are defined here
  // In production, they are managed in a service
  val todoList: ArrayBuffer[Todo] = ArrayBuffer(
    Todo(1, "Todo 1", true),
    Todo(2, "Todo 2", true),
    Todo(3, "Todo 3", false)
  )
}
