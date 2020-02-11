package controllers

import play.api.mvc._

class ChartTable(cc: ControllerComponents) extends AbstractController(cc) {
  def charts() = Action {
    Ok(views.html.chartTable.charts())
  }

  def tables() = Action {
    Ok(views.html.chartTable.tables())
  }
}
