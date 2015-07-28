package triplec1988.bindings.enums

import java.sql.{SQLFeatureNotSupportedException, Types, SQLException}
import java.util.Objects

import triplec1988.enums.IngestionScheduleType
import org.jooq._
import org.jooq.impl.DSL

/**
 * Created by chris on 7/28/15.
 */
class IngestionScheduleTypeEnumBinding extends Binding[Object, IngestionScheduleType] {
  override final def converter() : Converter[Object, IngestionScheduleType] = {
    new IngestionScheduleTypeEnumConverter()
  }

  @throws[SQLException]
  override final def sql(ctx: BindingSQLContext[IngestionScheduleType]) : Unit = {
    ctx.render().visit(DSL.value(ctx.convert(converter()).value())).sql("::ingestion_schedule_type")
  }

  @throws[SQLException]
  override final def register(ctx: BindingRegisterContext[IngestionScheduleType]) : Unit = {
    ctx.statement().registerOutParameter(ctx.index(), Types.VARCHAR)
  }

  @throws[SQLException]
  override final def set(ctx: BindingSetStatementContext[IngestionScheduleType]) : Unit = {
    ctx.statement().setString(
      ctx.index(),
      Objects.toString(ctx.convert[Object](converter()).value(), null))
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetResultSetContext[IngestionScheduleType]) : Unit = {
    ctx.convert[Object](converter()).value(ctx.resultSet().getString(ctx.index()))
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetStatementContext[IngestionScheduleType]) : Unit = {
    ctx.convert[Object](converter()).value(ctx.statement().getString(ctx.index()))
  }

  @throws[SQLException]
  override final def set(ctx: BindingSetSQLOutputContext[IngestionScheduleType]) : Unit = {
    throw new SQLFeatureNotSupportedException()
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetSQLInputContext[IngestionScheduleType]) : Unit = {
    throw new SQLFeatureNotSupportedException()
  }
}
