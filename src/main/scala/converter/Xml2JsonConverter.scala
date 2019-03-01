package converter

import net.liftweb.json._
import net.liftweb.json.Serialization.write
import org.json4s
import org.json4s.Xml.{toJson, toXml}
import org.json4s.native.JsonMethods._

import scala.xml.Elem

object Xml2JsonConverter {
  def fromXml(xmlString: String): Elem = {
    scala.xml.XML.loadString(xmlString)

//    val incomingXml = scala.xml.XML.loadString(xmlString.trim)
//    val operatorId = incomingXml.\@("operatorId")
//    val orderId = incomingXml.\\("orderId").text
//    val operatorOrderId = incomingXml.\\("operatorOrderId").text
//    val serviceId = incomingXml.\\("modifyFeaturesInstruction").\@("serviceId")
//    val features = incomingXml.\\("feature").map(_.\@("code"))
//    ModifyVoiceFeaturesInstruction(operatorId, orderId, serviceId, operatorOrderId, features)
  }

  def xmlToJson(instruction: String): String = {
    val xml = scala.xml.XML.loadString(instruction)
    val json = toJson(xml)
    compact(render(json))
    //    s"""{"modifyVoiceFeaturesInstruction":${write(instruction)(DefaultFormats)}}"""
  }
}
