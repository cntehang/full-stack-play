import _root_.controllers.AssetsComponents
import com.softwaremill.macwire._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.routing.Router
import play.filters.HttpFiltersComponents
import router.Routes
import play.api.i18n.I18nComponents

class MyApplicationLoader extends ApplicationLoader {
  def load(context: Context): Application =
    new ApplicationComponents(context).application
}

class ApplicationComponents(context: Context)
    extends BuiltInComponentsFromContext(context)
    with ApplicationModule
    with AssetsComponents
    with HttpFiltersComponents {

  // set up logger
  LoggerConfigurator(context.environment.classLoader).foreach {
    _.configure(context.environment, context.initialConfiguration, Map.empty)
  }

  lazy val router: Router = {
    // add the prefix string in local scope for the Routes constructor
    val prefix: String = "/"
    wire[Routes]
  }
}
