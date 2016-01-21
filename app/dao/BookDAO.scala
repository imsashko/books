package dao

import scala.concurrent.Future

import models.Book
import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfig
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile

class BookDAO extends HasDatabaseConfig[JdbcProfile] {
  protected val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  import driver.api._

  private val Books = TableQuery[BooksTable]

  def all(): Future[List[Book]] = db.run(Books.result).map(_.toList)

  def insert(Book: Book): Future[Unit] = db.run(Books += Book).map(_ => ())

  private class BooksTable(tag: Tag) extends Table[Book](tag, "Books") {

    def id = column[Int]("id", O.PrimaryKey)
    def title = column[String]("title")

    def * = (id, title) <> (Book.tupled, Book.unapply _)
  }
}