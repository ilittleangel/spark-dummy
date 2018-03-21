import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfter, FlatSpec}

/**
  * Description of class/module...
  * Created by angelrojo on 2018-03-21.
  */
class TestSparkDummy extends FlatSpec with BeforeAndAfter {

  private val master = "local[2]"
  private val appName = "spark-dummy"

  private var sc: SparkContext = _

  before {
    val conf = new SparkConf()
      .setAppName(appName)
      .setMaster(master)

    sc = new SparkContext(conf)
  }

  after {
    sc.stop
  }

  "Sleeping funtion" should "be sleep" in {
    val arg = 10
    SparkDummy.sleeping(sc, arg)
  }

}
