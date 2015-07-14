package triplec1988.strategies

import mojolly.inflector.Inflector
import org.jooq.util.GeneratorStrategy.Mode
import org.jooq.util.{DefaultGeneratorStrategy, Definition}

class SingularNamingStrategy extends DefaultGeneratorStrategy {

  override def getJavaClassName(definition: Definition, mode: Mode): String ={
    return Inflector.singularize(definition.getOutputName)
  }
}
