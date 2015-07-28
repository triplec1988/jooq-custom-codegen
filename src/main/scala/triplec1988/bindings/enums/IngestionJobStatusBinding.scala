package triplec1988.bindings.enums

import java.sql.{SQLFeatureNotSupportedException, Types, SQLException}
import java.util.Objects
import org.jooq._
import org.jooq.impl.DSL
import triplec1988.enums.job.IngestionJobStatus

/**
 * Created by chris on 7/28/15.
 */
class IngestionJobStatusBinding extends Binding[Object, IngestionJobStatus] {

  override final def converter() : Converter[Object, IngestionJobStatus] = {
    new IngestionJobStatusConverter()
  }

  @throws[SQLException]
  override final def sql(ctx: BindingSQLContext[IngestionJobStatus]) : Unit = {
    ctx.render().visit(DSL.value(ctx.convert(converter()).value())).sql("::ingestion_job_status")
  }

  @throws[SQLException]
  override final def register(ctx: BindingRegisterContext[IngestionJobStatus]) : Unit = {
    ctx.statement().registerOutParameter(ctx.index(), Types.VARCHAR)
  }

  @throws[SQLException]
  override final def set(ctx: BindingSetStatementContext[IngestionJobStatus]) : Unit = {
    ctx.statement().setString(
      ctx.index(),
      Objects.toString(ctx.convert[Object](converter()).value(), null))
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetResultSetContext[IngestionJobStatus]) : Unit = {
    ctx.convert[Object](converter()).value(ctx.resultSet().getString(ctx.index()))
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetStatementContext[IngestionJobStatus]) : Unit = {
    ctx.convert[Object](converter()).value(ctx.statement().getString(ctx.index()))
  }

  @throws[SQLException]
  override final def set(ctx: BindingSetSQLOutputContext[IngestionJobStatus]) : Unit = {
    throw new SQLFeatureNotSupportedException()
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetSQLInputContext[IngestionJobStatus]) : Unit = {
    throw new SQLFeatureNotSupportedException()
  }
}
