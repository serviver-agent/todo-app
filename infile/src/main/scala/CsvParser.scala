package infile

import org.apache.commons.csv._
import java.nio.charset.Charset
import java.io.File
import scala.jdk.CollectionConverters._

object CsvParser {

  def parse[A](file: File, mapDefinition: CSVRecord => A): List[A] = {
    val parser = CSVParser.parse(file, Charset.forName("UTF-8"), CSVFormat.DEFAULT.withHeader())
    val list   = parser.getRecords.asScala.toList.map(mapDefinition)
    list
  }

}
