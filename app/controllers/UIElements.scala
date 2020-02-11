package controllers

import play.api.mvc._

class UIElements(cc: ControllerComponents) extends AbstractController(cc) {
  def buttons() = Action {
    Ok(views.html.ui.buttons())
  }

  def cards() = Action {
    Ok(views.html.ui.cards())
  }
}
