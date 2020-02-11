package controllers

import play.api.mvc._

class Utilities(cc: ControllerComponents) extends AbstractController(cc) {
  def animations() = Action {
    Ok(views.html.utilities.animations())
  }

  def borders() = Action {
    Ok(views.html.utilities.borders())
  }

  def colors() = Action {
    Ok(views.html.utilities.colors())
  }

  def other() = Action {
    Ok(views.html.utilities.other())
  }
}
