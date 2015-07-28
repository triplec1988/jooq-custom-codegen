package triplec1988.enums.job

/**
 * Created by chris on 7/27/15.
 */

sealed trait IngestionJobStatus {
  def stringName(): String
}

final object IngestionJobStatusParser {
  def parse(name: String): IngestionJobStatus = name match {
    case "pending"          => Pending.apply()
    case "preparing"        => Preparing.apply()
    case "running"          => Running.apply()
    case "persisting"       => Persisting.apply()
    case "cancelled"        => Cancelled.apply()
    case "failed"           => Failed.apply()
    case "partially_failed" => PartiallyFailed.apply()
    case "success"          => Success.apply()
    case _                  => throw new RuntimeException("Unsupported type for IngestionScheduleType!")
  }

  def all : List[IngestionJobStatus] = {
    List(Pending.apply(), Preparing.apply(), Running.apply(), Persisting.apply(),
         Cancelled.apply(), Failed.apply(), PartiallyFailed.apply(), Success.apply())
  }
}

final case class Pending(override val stringName: String = "pending") extends IngestionJobStatus

final case class Preparing(override val stringName: String = "preparing") extends IngestionJobStatus

final case class Running(override val stringName: String = "running") extends IngestionJobStatus

final case class Persisting(override val stringName: String = "persisting") extends IngestionJobStatus

final case class Cancelled(override val stringName: String = "cancelled") extends IngestionJobStatus

final case class Failed(override val stringName: String = "failed") extends IngestionJobStatus

final case class PartiallyFailed(override val stringName: String = "partially_failed") extends IngestionJobStatus

final case class Success(override val stringName: String = "success") extends IngestionJobStatus