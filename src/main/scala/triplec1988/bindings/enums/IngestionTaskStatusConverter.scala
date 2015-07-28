package triplec1988.bindings.enums

import java.sql.SQLException

import org.jooq.Converter
import java.io.IOException
import triplec1988.enums.task.{IngestionTaskStatusParser, IngestionTaskStatus}

/**
 * Created by chris on 7/28/15.
 */
class IngestionTaskStatusConverter extends Converter[Object, IngestionTaskStatus] {

  override final def from(t: Object) : IngestionTaskStatus = {
    try {
      if (t == null) {
        throw new SQLException("ingestion_task_status should never be null!")
      } else {
        IngestionTaskStatusParser.parse(t.toString)
      }
    } catch {
      case ioe: IOException => throw new RuntimeException(ioe)
      case sql: SQLException => throw new RuntimeException(sql)
    }
  }

  override final def to(u: IngestionTaskStatus) : Object = {
    try {
      if (u == null) {
        throw new SQLException("ingestion_task_status cannot be null!")
      } else {
        u.stringName().asInstanceOf[Object]
      }
    } catch {
      case ioe: IOException => throw new RuntimeException(ioe)
      case sql: SQLException => throw new RuntimeException(sql)
    }
  }

  override final def fromType() : Class[Object] = {
    classOf[Object]
  }

  override  final def toType() : Class[IngestionTaskStatus] = {
    classOf[IngestionTaskStatus]
  }
}
