package wood.mike.eagerLazy

import grails.testing.gorm.DomainUnitTest
import spock.lang.Shared
import spock.lang.Specification

class AirportSpec extends Specification implements DomainUnitTest<Airport> {

    @Shared
    Airport airport

    def setup() {
        airport = new Airport(name: 'Heathrow')
        airport.addToTerminals(new Terminal(name: 'T1'))
        airport.addToTerminals(new Terminal(name: 'T2'))
        airport.addToFlights(new Flight(number: 123, destination: new Location(country: 'USA', city: 'LA')))
        airport.addToFlights(new Flight(number: 321, destination: new Location(country: 'USA', city: 'NY')))
        airport.addToRunways(new Runway(name: 'R1'))
        airport.addToRunways(new Runway(name: 'R2'))
        airport.save()
    }

    void "test airport"() {
        expect:
            airport.flights.size() == 2
            airport.terminals.size() == 2
            airport.runways.size() == 2
    }

    void "test eager fetch with findById query"() {
        when:
            def heathrow = Airport.findById( airport.id, [fetch: [runways: 'join']])
        then:
           heathrow.runways
    }

    void "test eager fetch with findByName query"() {
        when:
            def heathrow = Airport.findByName( 'Heathrow', [fetch: [runways: 'join']])
        then:
            heathrow.runways
    }

    void "test eager fetch with where query"() {
        when:
            def heathrow = Airport.where { name == 'Heathrow' }.join('runways').list()[0]
        then:
            heathrow.runways
    }
}
