import java.io.File

import net.sourceforge.tess4j.{Tesseract, TesseractException}

object Main extends App {
  println("aaaa")
  piyo

  def piyo: Unit = {
    val imageFile = new File("./file/astel.png")
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
