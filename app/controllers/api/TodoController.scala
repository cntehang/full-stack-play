package controllers.api

import play.api.data._
import play.api.mvc._
import play.api.libs.json.Json

import models.todo.TodoForm
import models.todo.TodoView.{Todo, todoFormat, todoList}

class TodoController(
    cc: ControllerComponents
) extends AbstractController(cc) {

  def getAll() = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(todoList))
  }

  def getById(id: Long) = Action { implicit request: Request[AnyContent] =>
    val item = todoList.find(_.id == id)
    Ok(Json.toJson(item))
  }

  def add() = Action { implicit request: Request[AnyContent] =>
    TodoForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => {
        val errors = errorForm.errors.map(_.message).mkString(", ")
        BadRequest(s"Error! ${errors}")
      },
      data => {
        val id = todoList.length + 1
        val newTodoItem = Todo(id, data.name, data.isComplete)
        todoList += newTodoItem
        Ok(Json.toJson(todoList))
      }
    )
  }

  def update(id: Long) = Action { implicit request: Request[AnyContent] =>
    TodoForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => {
        val errors = errorForm.errors.map(_.message).mkString(", ")
        BadRequest(s"Error! ${errors}")
      },
      data => {
        val todoItem = Todo(id, data.name, data.isComplete)
        val index = todoList.indexWhere(_.id == id)
        todoList(index) = todoItem
        Ok(Json.toJson(todoList))
      }
    )
  }

  def delete(id: Long) = Action { implicit request: Request[AnyContent] =>
    val index = todoList.indexWhere(_.id == id)
    todoList.remove(index)
    Ok(Json.toJson(todoList))
  }
}
