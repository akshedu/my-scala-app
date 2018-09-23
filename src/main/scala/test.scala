package mypackage

import org.apache.spark.sql._
import org.apache.spark.sql.types._
    
object SparkTestApp {
    def main(args: Array[String]) = {
        val spark  = SparkSession.builder()
                                 .appName("SparkTestApp")
                                 .enableHiveSupport()
                                 .getOrCreate()

        val df = spark.read.option("header", true).csv(args(0))
        df.createTempView("annotated_docs")
        spark.sql("""select * from annotated_docs 
                    where document_id = 'clueweb09-en0000-00-00011'""")
            .coalesce(1)
            .write
            .csv(args(1))

        spark.stop()
    }
}