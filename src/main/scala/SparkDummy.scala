import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description of class/module...
  * Created by angelrojo on 2018-03-21.
  */
object SparkDummy extends LazyLogging {

  private val master = "yarn"
  private val appName = "spark-dummy"

  def main(args: Array[String]): Unit = {

    if ((1 to args.length).end != 1 || !args(0).matches("""(\d+)""")) {
      System.err.println("Usage: SparkDummy <seconds>")
      System.exit(1)
    }

    val conf = new SparkConf().setAppName(appName).setMaster(master)
    val sc = new SparkContext(conf)
    sleeping(sc, args(0).toInt)
  }

  def sleeping(sc: SparkContext, arg: Int): Unit = {
    sc.parallelize(List.range(1, arg).reverse).collect().foreach(seconds => {
      logger.info(s"Sleeping $seconds seconds")
      Thread.sleep(1000)
    })
  }

}
