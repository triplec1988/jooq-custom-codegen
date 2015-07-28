package triplec1988.enums

/**
 * Created by chris on 7/27/15.
 */

sealed trait IngestionScheduleType {
  def stringName(): String
}

final object IngestionScheduleTypeParser {
  def parse(name: String): IngestionScheduleType = name match {
    case "cron" => new Cron(name)
    case "interval" => new Interval(name)
    case _ => throw new RuntimeException("Unsupported type for IngestionScheduleType!")
  }
}

final case class Cron(name: String) extends IngestionScheduleType {
  override def stringName() : String = {
    this.name
  }
}

final case class Interval(name: String) extends IngestionScheduleType {
  override def stringName() : String = {
    this.name
  }
}
