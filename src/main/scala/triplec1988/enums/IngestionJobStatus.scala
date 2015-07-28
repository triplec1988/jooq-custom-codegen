package triplec1988.enums

/**
 * Created by chris on 7/27/15.
 */
object IngestionJobStatus extends Enumeration {
  type IngestionJobStatus = Value
  val pending, preparing, running, persisting, cancelled, failed, partially_failed, success = Value
}
