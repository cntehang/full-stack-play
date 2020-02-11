package controllers

import play.api.mvc._

class Home(cc: ControllerComponents) extends AbstractController(cc) {
  def index = Action {
    Ok(views.html.main.home())
  }
}
