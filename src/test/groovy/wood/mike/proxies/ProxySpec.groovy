package wood.mike.proxies

import grails.testing.gorm.DataTest
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ProxySpec extends Specification implements DomainUnitTest<Pet>, DataTest {

    def setupSpec() {
        mockDomains Owner, Fish
    }

    def setup() {
        new Owner(name: 'Bill', pet: new Fish(name: 'Elmo', preferredWaterTemp: 22)).save()
    }

    void "test proxy"() {
        when:
            def owner = Owner.findByName('Bill')
        then:
            owner.pet instanceof Fish                           // this works in unit test but not in live/integration test, see ProxyIntegrationSpec
    }
}
