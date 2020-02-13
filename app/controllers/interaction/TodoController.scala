package controllers.interaction

import play.api.data._
import play.api.libs.json.Json
import play.api.Logging
import play.api.mvc._

import models.todo.{TodoForm, TodoListForm}
import models.todo.TodoView.{Todo, todoList}
import org.checkerframework.checker.units.qual.s

class TodoController(cc: ControllerComponents)
    extends AbstractController(cc)
    with play.api.i18n.I18nSupport
    with Logging {

  def index() = Action { implicit request: Request[AnyContent] =>
    logger.debug("Enter TodoController::index")
    Ok(views.html.interaction.todo(todoList.toSeq))
  }

  def selected() = Action { implicit request: Request[AnyContent] =>
    logger.debug("Enter TodoController::selected")
    logger.debug(s"selected() recieved body: ${request.body}")

    TodoListForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => {
        val errors = errorForm.errors.map(_.format).mkString(", ")
        logger.warn(s"Error! ${errors}")
        BadRequest(s"Error! ${errors}")
      },
      data => {
        logger.debug(s"ids in POST request: ${data}")
        val selectedIdSet = data.ids.toSet
        val selectedItems = todoList.filter(todo => selectedIdSet(todo.id))
        Ok(views.html.interaction.todo(selectedItems.toSeq))
      }
    )
  }

}
