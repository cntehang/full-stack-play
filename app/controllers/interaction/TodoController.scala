package controllers.interaction

import play.api.data._
import play.api.libs.json.Json
import play.api.Logging
import play.api.mvc._

import models.todo.{TodoForm, TodoListForm}
import models.todo.TodoView.todoList

class TodoController(cc: ControllerComponents)
    extends AbstractController(cc)
    with play.api.i18n.I18nSupport
    with Logging {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.interaction.todo(todoList.toSeq, TodoForm.form))
  }

  def selected() = Action { implicit request: Request[AnyContent] =>
    TodoListForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => {
        val errors = errorForm.errors.map(_.message).mkString(", ")
        BadRequest(s"Error! ${errors}")
      },
      data => {
        logger.error(s"recieved data: ${data.ids}")
        Ok("hello " + data.ids.mkString(", "))
      }
    )
  }
}
