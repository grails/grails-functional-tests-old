import gorm.Test
import converters.LevelA
import converters.LevelB
import converters.LevelC
class BootStrap {

    def grailsWebDataBinder

    def init = { servletContext ->
        assert new Test(age:10, name:"bob").addToChildren(name:"joy").save(flush:true)
        def levelC = LevelC.build()
        def levelB = LevelB.build()
        levelB.addToLevelsC(levelC)
        def levelA = LevelA.build()
        levelA.addToLevelsB(levelB)

        assert levelA.save()

        grailsWebDataBinder.registerStructuredEditor databinding.Person, new databinding.converters.StructuredPersonEditor()
    }
    def destroy = {
    }
}
