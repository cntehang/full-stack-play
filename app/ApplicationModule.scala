import play.api.i18n.Langs
import play.api.mvc.ControllerComponents
import controllers.{Home, UIElements, Utilities, Pages, ChartTable}
import controllers.interaction.{TodoController, WidgetController}
import controllers.api.{TodoController => ApiTodoController}

trait ApplicationModule {

  import com.softwaremill.macwire._

  lazy val home = wire[Home]
  lazy val uiElement = wire[UIElements]
  lazy val utilities = wire[Utilities]
  lazy val pages = wire[Pages]
  lazy val chartTable = wire[ChartTable]
  lazy val widgets = wire[WidgetController]

  lazy val todo = wire[TodoController]
  lazy val apiTodo = wire[ApiTodoController]

  def langs: Langs

  def controllerComponents: ControllerComponents
}
