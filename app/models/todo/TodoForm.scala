package models.todo

/**
  * Form processing classes and objectes
  * For consistency, please use `Data` as the case class name
  * and `form` as the Form object name
  */
object TodoForm {
  import play.api.data.Forms._
  import play.api.data.Form

  /**
    * A form processing view object that maps to the form below.
    * Using a class specifically for form binding reduces the chances
    * of a parameter tampering attack and makes code clearer.
    */
  case class Data(name: String, isComplete: Boolean)

  /**
    * The form definition specifies the form fields and their types,
    * as well as how to convert from a Data to form data and vice versa.
    */
  val form: Form[Data] = Form(
    mapping(
      "name" -> nonEmptyText,
      "isComplete" -> boolean
    )(Data.apply)(Data.unapply)
  )
}
