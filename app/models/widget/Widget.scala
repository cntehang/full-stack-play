package models.widget

/**
  * Presentation object used for displaying data in a template.
  * Note that it's a good practice to keep the presentation DTO,
  * which are used for reads, distinct from the form processing DTO,
  * which are used for writes.
  *
  * You can also name it with a `Vo` postfix to show that it is an view object.
  */
case class Widget(id: Long, name: String, price: Int)
