package converters

import grails.converters.XML
import org.hibernate.FetchMode

class ConvertersSearchController {

  def cached = {
    def criteria = LevelA.createCriteria()
    def results = criteria {
      fetchMode("levelsB", FetchMode.EAGER)
      fetchMode("levelsB.levelsC", FetchMode.EAGER)
      ge("lvlA", 0)
      levelsB {
        levelsC {
          ge("lvlC", 0)
        }
      }
    }
    render XML.use("deep") {render results as XML}
  }

    def notCached = {
    def criteria = LevelA.createCriteria()
    def results = criteria {
      fetchMode("levelsB", FetchMode.JOIN)
      fetchMode("levelsB.levelsC", FetchMode.JOIN)
      
      setCacheable(false)
    }
    render XML.use("deep") {render results as XML}
  }
}
