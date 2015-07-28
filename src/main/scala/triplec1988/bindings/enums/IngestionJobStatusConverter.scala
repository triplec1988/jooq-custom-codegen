package triplec1988.bindings.enums

import java.sql.SQLException

import org.jooq.Converter
import java.io.IOException
import triplec1988.enums.job.{IngestionJobStatusParser, IngestionJobStatus}

/**
 * Created by chris on 7/28/15.
 */
class IngestionJobStatusConverter extends Converter[Object, IngestionJobStatus] {

  override final def from(t: Object) : IngestionJobStatus = {
    try {
      if (t == null) {
        throw new SQLException("ingestion_job_status should never be null!")
      } else {
        IngestionJobStatusParser.parse(t.toString)
      }
    } catch {
      case ioe: IOException => throw new RuntimeException(ioe)
      case sql: SQLException => throw new RuntimeException(sql)
    }
  }

  override final def to(u: IngestionJobStatus) : Object = {
    try {
      if (u == null) {
        throw new SQLException("ingestion_job_status cannot be null!")
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

  override  final def toType() : Class[IngestionJobStatus] = {
    classOf[IngestionJobStatus]
  }
}
