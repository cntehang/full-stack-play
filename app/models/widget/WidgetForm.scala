package models.widget

/**
  * Form processing classes and objectes
  * For consistency, please use `Data` as the case class name
  * and `form` as the Form object name
  */
object WidgetForm {
  import play.api.data.Forms._
  import play.api.data.Form

  /**
    * A form processing object that maps to the form below.
    *
    * Using a class specifically for form binding reduces the chances
    * of a parameter tampering attack and makes code clearer.
    */
  case class Data(name: String, price: Int)

  /**
    * The form definition for the "create a widget" form.
    * It specifies the form fields and their types,
    * as well as how to convert from a Data to form data and vice versa.
    */
  val form: Form[Data] = Form(
    mapping(
      "name" -> nonEmptyText,
      "price" -> number(min = 0)
    )(Data.apply)(Data.unapply)
  )
}
