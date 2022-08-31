package wood.mike.modelling.one2one

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DoorSpec extends Specification implements DomainUnitTest<Door> {

    void "test create door"() {
        when:
            def door = new Door(width: 50, height: 300, handle: new Handle(colour: 'Gold')).save()
        then:
            door
    }
}
