package triplec1988.enums.schedule

/**
 * Created by chris on 7/27/15.
 */

sealed trait IngestionScheduleType {
  def stringName(): String
}

final object IngestionScheduleTypeParser {
  def parse(name: String): IngestionScheduleType = name match {
    case "cron"     => Cron.apply()
    case "interval" => Interval.apply()
    case _          => throw new RuntimeException("Unsupported type for IngestionScheduleType!")
  }

  def all : List[IngestionScheduleType] = {
    List(Cron.apply(), Interval.apply())
  }
}

final case class Cron(override val stringName: String = "cron") extends IngestionScheduleType

final case class Interval(override val stringName: String = "interval") extends IngestionScheduleType
