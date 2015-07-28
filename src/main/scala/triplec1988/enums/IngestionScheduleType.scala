package triplec1988.enums

/**
 * Created by chris on 7/27/15.
 */
object IngestionScheduleType extends Enumeration {
  type IngestionScheduleType = Value
  val cron, interval = Value
}
