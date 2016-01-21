package controllers

import dao.BookDAO
import models.Book
import play.api._
import play.api.mvc._
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.libs.concurrent.Execution.Implicits.defaultContext

class Application extends Controller {

  def dao = new BookDAO

  def index = Action.async {
    dao.all().map(c => Ok(views.html.index(c)))
  }

  def oldIndex = Action {
    Ok(views.html.oldIndex("Your new application is ready."))
  }

}
