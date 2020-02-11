package controllers

import play.api.mvc._

class Pages(cc: ControllerComponents) extends AbstractController(cc) {
  def login() = Action {
    Ok(views.html.pages.login())
  }

  def register() = Action {
    Ok(views.html.pages.register())
  }

  def forgotPassword() = Action {
    Ok(views.html.pages.forgetPassword())
  }

  def notFound() = Action {
    Ok(views.html.pages.notFound())
  }

  def blank() = Action {
    Ok(views.html.pages.blank())
  }
}
