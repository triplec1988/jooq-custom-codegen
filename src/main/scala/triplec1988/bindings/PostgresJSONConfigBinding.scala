package triplec1988.bindings

import java.sql.{SQLFeatureNotSupportedException, Types, SQLException}
import java.util.Objects

import org.jooq.impl.DSL
import org.jooq._
import com.typesafe.config.Config

/**
 * Created by chris on 7/21/15.
 */
class PostgresJSONConfigBinding extends Binding[Object, Config] {

  override final def converter() : Converter[Object, Config] = {
    new PostgresJSONConfigConverter()
  }

  @throws[SQLException]
  override final def sql(ctx: BindingSQLContext[Config]) : Unit = {
    ctx.render().visit(DSL.value(ctx.convert(converter()).value())).sql("::json")
  }

  @throws[SQLException]
  override final def register(ctx: BindingRegisterContext[Config]) : Unit = {
    ctx.statement().registerOutParameter(ctx.index(), Types.VARCHAR)
  }

  @throws[SQLException]
  override final def set(ctx: BindingSetStatementContext[Config]) : Unit = {
    ctx.statement().setString(
      ctx.index(),
      Objects.toString(ctx.convert[Object](converter()).value(), null))
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetResultSetContext[Config]) : Unit = {
    ctx.convert[Object](converter()).value(ctx.resultSet().getString(ctx.index()))
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetStatementContext[Config]) : Unit = {
    ctx.convert[Object](converter()).value(ctx.statement().getString(ctx.index()))
  }

  @throws[SQLException]
  override final def set(ctx: BindingSetSQLOutputContext[Config]) : Unit = {
    throw new SQLFeatureNotSupportedException()
  }

  @throws[SQLException]
  override final def get(ctx: BindingGetSQLInputContext[Config]) : Unit = {
    throw new SQLFeatureNotSupportedException()
  }
}
