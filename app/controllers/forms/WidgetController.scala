package controllers

import models.Widget
import play.api.data._
import play.api.mvc._

import scala.collection._

// need I18nSupport for messages api
class WidgetController(cc: ControllerComponents)
    extends AbstractController(cc)
    with play.api.i18n.I18nSupport {
  import WidgetForm._

  private val widgets = mutable.ArrayBuffer(
    Widget("Widget 1", 123),
    Widget("Widget 2", 456),
    Widget("Widget 3", 789)
  )

  // The URL to the widget.  You can call this directly from the template, but it
  // can be more convenient to leave the template completely stateless i.e. all
  // of the "WidgetController" references are inside the .scala file.
  private val postUrl = routes.WidgetController.createWidget()

  def listWidgets = Action { implicit request =>
    // Pass an unpopulated form to the template
    Ok(views.html.forms.listWidgets(widgets.toSeq, form, postUrl))
  }

  // This will be the action that handles our form post
  def createWidget = Action { implicit request =>
    val errorFunction = { formWithErrors: Form[Data] =>
      // This is the bad case, where the form had validation errors.
      // Let's show the user the form again, with the errors highlighted.
      // Note how we pass the form with errors to the template.
      BadRequest(
        views.html.forms.listWidgets(widgets.toSeq, formWithErrors, postUrl)
      )
    }

    val successFunction = { data: Data =>
      // This is the good case, where the form was successfully parsed as a Data object.
      val widget = Widget(name = data.name, price = data.price)
      widgets += widget
      Redirect(routes.WidgetController.listWidgets())
        .flashing("info" -> "Widget added!")
    }

    form.bindFromRequest.fold(errorFunction, successFunction)
  }
}
