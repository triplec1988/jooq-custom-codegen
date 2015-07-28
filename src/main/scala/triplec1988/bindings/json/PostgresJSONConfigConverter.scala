package triplec1988.bindings.json

import java.io.IOException

import com.typesafe.config.{Config, ConfigFactory, ConfigRenderOptions}
import org.jooq.Converter

/**
 * Created by chris on 7/21/15.
 */
class PostgresJSONConfigConverter extends Converter[Object, Config] {

  override final def from(t: Object) : Config = {
    try {
      if (t == null) ConfigFactory.parseString("""{}""") else ConfigFactory.parseString(t.toString)

    } catch {
      case ioe: IOException => throw new RuntimeException(ioe)
    }
  }

  override final def  to(u: Config) : Object = {
    try {
      if (u == null) null else u.root().render(ConfigRenderOptions.concise().setJson(true)).asInstanceOf[Object]

    } catch {
      case ioe: IOException => throw new RuntimeException(ioe)
    }
  }

  override final def fromType() : Class[Object] = {
    classOf[Object]
  }

  override  final def toType() : Class[Config] = {
    classOf[Config]
  }
}
