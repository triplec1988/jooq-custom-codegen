package triplec1988.bindings.enums

import java.sql.{SQLFeatureNotSupportedException, Types, SQLException}
import java.util.Objects
import org.jooq._
import org.jooq.impl.DSL
import triplec1988.enums.task.IngestionTaskStatus

/**
 * Created by chris on 7/28/15.
 */
class IngestionTaskStatusBinding extends Binding[Object, IngestionTaskStatus] {

  override final def converter() : Converter[Object, IngestionTaskStatus] = {
    new IngestionTaskStatusConverter()
  }

  @throws[SQLException]
  override final def sql(ctx: BindingSQLContext[IngestionTaskStatus]) : Unit = {
    ctx.render().visit(DSL.value(ctx.convert(converter()).value())).sql("::ingestion_task_status")
  }

  @throws[SQLException]
  override final def register(ctx: BindingRegisterContext[IngestionTaskStatus]) : Unit = {
    ctx.statement().registerOutParameter(ctx.index(), Types.VARCHAR)
  }

  @throws[SQLException]
  override final def set(ctx: BindingSetStatementContext[IngestionTaskStatus]) : Unit = {
    ctx.statement().setString(
      ctx.index(),
      Objects.toString(ctx.convert[Object](converter()).value(), null))
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetResultSetContext[IngestionTaskStatus]) : Unit = {
    ctx.convert[Object](converter()).value(ctx.resultSet().getString(ctx.index()))
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetStatementContext[IngestionTaskStatus]) : Unit = {
    ctx.convert[Object](converter()).value(ctx.statement().getString(ctx.index()))
  }

  @throws[SQLException]
  override final def set(ctx: BindingSetSQLOutputContext[IngestionTaskStatus]) : Unit = {
    throw new SQLFeatureNotSupportedException()
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetSQLInputContext[IngestionTaskStatus]) : Unit = {
    throw new SQLFeatureNotSupportedException()
  }
}
