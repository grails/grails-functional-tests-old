import criteriatest.LevelC
import criteriatest.LevelB
import criteriatest.LevelA

class BootStrap {

    def init = { servletContext ->

      def levelC = LevelC.build()
      def levelB = LevelB.build()
      levelB.addToLevelsC(levelC)
      def levelA = LevelA.build()
      levelA.addToLevelsB(levelB)

      levelA.save()

     // LevelC.build()

    }
    def destroy = {
    }
}
