package triplec1988.enums.task

/**
 * Created by chris on 7/27/15.
 */

sealed trait IngestionTaskStatus {
  def stringName(): String
}

final object IngestionTaskStatusParser {
  def parse(name: String): IngestionTaskStatus = name match {
    case "ready_to_fetch"   => ReadyToFetch.apply()
    case "fetching"         => Fetching.apply()
    case "ready_to_process" => ReadyToProcess.apply()
    case "processing"       => Processing.apply()
    case "ready_to_persist" => ReadyToPersist.apply()
    case "persisting"       => Persisting.apply()
    case "failed"           => Failed.apply()
    case "partially_failed" => PartiallyFailed.apply()
    case "success"          => Success.apply()
    case _                  => throw new RuntimeException("Unsupported type for IngestionScheduleType!")
  }

  def all : List[IngestionTaskStatus] = {
    List(ReadyToFetch.apply(), Fetching.apply(), ReadyToProcess.apply(),
         Processing.apply(), ReadyToPersist.apply(), Persisting.apply(),
         Failed.apply(), PartiallyFailed.apply(), Success.apply())
  }
}

final case class ReadyToFetch(override val stringName: String = "ready_to_fetch") extends IngestionTaskStatus

final case class Fetching(override val stringName: String = "fetching") extends IngestionTaskStatus

final case class ReadyToProcess(override val stringName: String = "ready_to_process") extends IngestionTaskStatus

final case class Processing(override val stringName: String = "processing") extends IngestionTaskStatus

final case class ReadyToPersist(override val stringName: String = "ready_to_persist") extends IngestionTaskStatus

final case class Persisting(override val stringName: String = "persisting") extends IngestionTaskStatus

final case class Failed(override val stringName: String = "failed") extends IngestionTaskStatus

final case class PartiallyFailed(override val stringName: String = "partially_failed") extends IngestionTaskStatus

final case class Success(override val stringName: String = "success") extends IngestionTaskStatus