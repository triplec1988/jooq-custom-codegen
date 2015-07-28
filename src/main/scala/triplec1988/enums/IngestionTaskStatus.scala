package triplec1988.enums

/**
 * Created by chris on 7/27/15.
 */
object IngestionTaskStatus extends Enumeration {
  type IngestionTaskStatus = Value
  val ready_to_fetch, fetching, ready_to_process, processing, ready_to_persist, persisting, failed, partially_failed, success = Value
}
