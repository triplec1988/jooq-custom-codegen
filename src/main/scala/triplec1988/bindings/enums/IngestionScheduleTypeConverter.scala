package triplec1988.bindings.enums

import java.sql.SQLException

import org.jooq.Converter
import java.io.IOException
import triplec1988.enums.schedule.{IngestionScheduleTypeParser, IngestionScheduleType}

/**
 * Created by chris on 7/28/15.
 */
class IngestionScheduleTypeConverter extends Converter[Object, IngestionScheduleType] {

  override final def from(t: Object) : IngestionScheduleType = {
    try {
      if (t == null) {
        throw new SQLException("ingestion_schedule_type should never be null!")
      } else {
        IngestionScheduleTypeParser.parse(t.toString)
      }
    } catch {
      case ioe: IOException => throw new RuntimeException(ioe)
      case sql: SQLException => throw new RuntimeException(sql)
    }
  }

  override final def to(u: IngestionScheduleType) : Object = {
    try {
      if (u == null) {
        throw new SQLException("ingestion_schedule_type cannot be null!")
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

  override  final def toType() : Class[IngestionScheduleType] = {
    classOf[IngestionScheduleType]
  }
}
