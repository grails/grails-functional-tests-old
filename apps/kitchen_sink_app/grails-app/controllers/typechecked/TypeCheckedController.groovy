package typechecked

import gorm.Person
import grails.compiler.GrailsTypeChecked

@GrailsTypeChecked
class TypeCheckedController {

    def numberOfPeopleWithName(String name) {
        Integer number = Person.countByName(name)

        render "The number of people with name ${name} is ${number}."
    }

    def findOrSavePersonWithName(String name) {
        def person = Person.findOrSaveByName(name)

        render "The person's name is ${person?.name}."
    }

}
