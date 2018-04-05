import java.io.File

import net.sourceforge.tess4j.{Tesseract, TesseractException}

object Main extends App {

  val DIR = "./file"
  val filename = getListOfFiles(DIR)

  for(x <- filename) {
    println(x)
    kaiseki(x.toString)
  }

  //https://alvinalexander.com/scala/how-to-list-files-in-directory-filter-names-scala
  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  def kaiseki(filename: String) = {
    val imageFile = new File(filename)
    val instance = new Tesseract()
    instance.setDatapath(System.getenv("TESSDATA_PREFIX"))
    try {
      val result = instance.doOCR(imageFile)
      println(result)
    } catch {
      case e: TesseractException => Console.err.println(e.getMessage())
    }
  }
}
