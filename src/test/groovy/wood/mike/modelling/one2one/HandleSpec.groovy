package wood.mike.modelling.one2one

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class HandleSpec extends Specification implements DomainUnitTest<Handle> {

    void "test create door and handle"() {
        when:
            def handle = new Handle(colour: 'Silver')
            def door = new Door( width: 200, height: 500, handle: handle ).save(validate: true)
        then:
            !door.hasErrors()
            door.handle.colour == 'Silver'
        when:
            def doorSecond =  new Door(width: 20, height: 40 )
            def handleFirst = new Handle( colour: 'Silver', door: doorSecond ).save(validate: true) // the docs say this shouldn't work but it does
        then:
            handleFirst.door.height == 40
    }
}
