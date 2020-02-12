package controllers.interaction

import play.api.data._
import play.api.mvc._

import models.todo.TodoForm
import models.todo.TodoView.todoList

class TodoController(cc: ControllerComponents)
    extends AbstractController(cc)
    with play.api.i18n.I18nSupport {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.interaction.todo(todoList.toSeq, TodoForm.form))
  }
}
